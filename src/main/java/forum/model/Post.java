package forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Cloneable {

    private User user;
    private String content;
    private int id;

    public String getContent() {
        return content;
    }
    public Post clone(){
        Post post = new Post();
        post.setId(this.id);
        post.setUser(this.user);
        post.setContent(this.content);
        return post;
    }

}
