package forum.services;

import forum.memory.IPostsDAO;
import forum.memory.IUsersDAO;
import forum.model.Post;
import forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostsDAO postsDAO;

    public void addPost(List<Post> forumPosts, Post post) {
        forumPosts.add(post);
    }
    public List<Post> getByPattern(String pattern) {
        List<Post> result = new ArrayList<>();
        for(Post post : this.postsDAO.getForumPosts()){
            if(post.getContent().toLowerCase().contains(pattern.toLowerCase())){
                result.add(post.clone());
            }
        }
        return result;
    }
}
