package forum.memory;

import forum.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public class PostsDAO implements IPostsDAO {

    private final List<Post> forumPosts = new ArrayList<>();
    public List<Post> getForumPosts() {
        return forumPosts;
    }
    public void deletePost(int id) {
        Iterator<Post> iterator = this.forumPosts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return;
            }
        }
    }


}