package creativecreators.Repository.UserRepository;


import creativecreators.Entities.UserCC;

import java.util.List;

public interface UserRepository {
    public List<UserCC> findAllUsers();
    public String register (UserCC user);
    public UserCC findUser(String username);

}
