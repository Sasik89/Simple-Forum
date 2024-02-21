package forum.sequence;

import org.springframework.stereotype.Component;

@Component
public class PostSequence {

    private int id = 0;
    public int getId(){
        return ++id;
    }
}
