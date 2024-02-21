package forum.controller;

import forum.memory.PostsDAO;
import forum.model.Post;
import forum.model.User;
import forum.sequence.PostSequence;
import forum.services.PostService;
import forum.session.SessionData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Resource
    SessionData sessionData;
    @Autowired
    PostsDAO posts;
    @Autowired
    private PostSequence postSequence;
    @Autowired
    private PostService postService;

    @GetMapping({"/", "/main"})
    public String index(Model model) {
        if(sessionData.getPatter()==null) {
            model.addAttribute("forumPosts", posts.getForumPosts());
        } else{
            model.addAttribute("forumPosts", postService.getByPattern(sessionData.getPatter()));
        }
        model.addAttribute("sessionData", sessionData);
        return "index";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam String username, @RequestParam String postContent, Model model) {
        User user = new User(username);
        int id = postSequence.getId();
        model.addAttribute("post", id);
        model.addAttribute("user", user);
        postService.addPost(posts.getForumPosts(), new Post(user, postContent, id));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable int id){
        this.posts.deletePost(id);
        return "redirect:/";
    }
    @RequestMapping(path= "/filter", method = RequestMethod.GET)
    public String filter(){
        return "redirect:/";
    }

    @RequestMapping(path= "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String pattern){
        sessionData.setPatter(pattern);
        System.out.println(pattern);
        return "redirect:/";
    }


}
