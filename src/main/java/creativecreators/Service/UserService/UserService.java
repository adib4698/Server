package creativecreators.Service.UserService;



import creativecreators.Entities.UserCC;

import java.util.List;

public interface UserService {

    List<UserCC> findAllUsers();
    String register(String username, String password,String nickname, String email);
}
