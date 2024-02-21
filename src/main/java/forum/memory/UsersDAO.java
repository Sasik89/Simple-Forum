package forum.memory;

import forum.exceptions.LoginAlreadyExistException;
import forum.model.User;
import forum.session.SessionData;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersDAO implements IUsersDAO{

    @Resource
    SessionData sessionData;

    List<User> users = new ArrayList<>();

    public UsersDAO(){
      users.add(new User("admin", "admin"));
      users.add(new User("janusz", "janusz"));
    }
    public List<User> getForumPosts() {
        return users;
    }

    public Optional<User> getUsername(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return Optional.of(user);
            }
        }
        return null;
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
        Optional<User> userBox = this.getUsername(username);
        for(User user : users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                this.sessionData.setUsername(userBox.get());
                return true;
            }
        }
        return false;
    }
    public void logout(){
        sessionData.setUsername(null); //nuluje obiekt sesji
    }
}
