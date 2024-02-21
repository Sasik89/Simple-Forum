package forum.session;

import forum.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@NoArgsConstructor
@Getter
@Component
@SessionScope
public class SessionData {

    private User username = null;
    private String patter;

    public boolean isLogged(){
        return this.username != null;
    }
    public void setUsernameCast(String username){
        this.username = new User(username);
    }
    public void setUsername(User username) {
        this.username = username;
    }
    public String getPatter() {
        return patter;
    }
    public void setPatter(String patter) {
        this.patter = patter;
    }
    public User getUsername() {
        return username;
    }
}
