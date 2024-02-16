package forum.services;

import forum.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    public void addPost(List<Post> forumPosts, Post post) {
        forumPosts.add(post);
    }



}
