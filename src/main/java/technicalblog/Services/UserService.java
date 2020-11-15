package technicalblog.Services;

import org.springframework.stereotype.Service;
import technicalblog.model.User;

@Service
public class UserService {

    public Boolean login(User user) {
        if (user.getUsername().equals("valid user")) {
            return true;
        }
        else {
            return false;
        }
    }
}
