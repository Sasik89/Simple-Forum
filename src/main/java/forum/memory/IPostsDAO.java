package forum.memory;

import forum.model.Post;

import java.util.Iterator;
import java.util.List;

public interface IPostsDAO {

    public List<Post> getForumPosts();
    public void deletePost(int id);


}

