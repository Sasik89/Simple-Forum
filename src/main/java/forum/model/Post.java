package forum.model;

public class Post {

    private User user;
    private String content;
    private int id;

    public Post(User user, String content, int id) {
        this.user = user;
        this.content = content;
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
