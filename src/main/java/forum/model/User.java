package forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private String password;
    public User(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
