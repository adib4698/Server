package creativecreators.Service.UserService.Implementation;

import creativecreators.Entities.UserCC;
import creativecreators.Repository.UserRepository.UserDaoJpa;
import creativecreators.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;



@org.springframework.stereotype.Service
@Component
@Primary
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoJpa userDao;



    @Override
    public List<UserCC> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public String register(String username, String password,String nickname, String email) {

        userDao.register(new UserCC(username,password,nickname,email,"user"));
        return "Ok";
    }

}
