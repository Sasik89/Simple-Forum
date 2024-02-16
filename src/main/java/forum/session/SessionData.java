package forum.session;

import forum.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionData {

    private User username = null;

    public boolean isLogged(){
        return this.username != null;
    }

}
