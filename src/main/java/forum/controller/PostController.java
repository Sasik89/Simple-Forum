package forum.controller;

import forum.memory.PostsDAO;
import forum.model.Post;
import forum.model.User;
import forum.sequence.PostSequence;
import forum.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired
    PostsDAO posts;
    @Autowired
    private PostSequence postSequence;
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("forumPosts", posts.getForumPosts());
        return "index";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam String username, @RequestParam String postContent, Model model) {
        User user = new User(username);
        int id = postSequence.getId();
        model.addAttribute("post", id);
        postService.addPost(posts.getForumPosts(), new Post(user, postContent, id));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable int id){
        this.posts.deletePost(id);
        return "redirect:/";
    }



}
