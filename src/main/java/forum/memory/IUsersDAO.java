package forum.memory;

import forum.model.User;

import java.util.List;

public interface IUsersDAO {

    public List<User> getForumPosts();

    public void addUser(String username, String password);
    public boolean logged(String username, String password);
    public void logout();
}
