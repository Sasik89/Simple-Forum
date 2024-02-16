package forum.memory;

import forum.exceptions.LoginAlreadyExistException;
import forum.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDAO implements IUsersDAO{

    List<User> users = new ArrayList<>();

    public UsersDAO(){
      users.add(new User("admin", "admin"));
      users.add(new User("janusz", "janusz"));
    }
    public List<User> getForumPosts() {
        return users;
    }

    @Override
    public void addUser(String username, String password) {
        for(User user : users){
            if(user.getUsername().equals(username)){
                throw new LoginAlreadyExistException();
            }
        }
        users.add(new User(username, password));
    }

    public boolean logged(String username, String password){
        for(User user : users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
