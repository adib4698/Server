package creativecreators.Repository.UserRepository;
import creativecreators.Entities.UserCC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@EnableJpaRepositories(basePackageClasses = UserJparepository.class)
public class UserDaoJpa implements UserRepository {
    private UserJparepository jpaRepository;

    private final Logger logger = LogManager.getLogger(UserDaoJpa.class);

    public UserDaoJpa(UserJparepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public List<UserCC> findAllUsers(){
        return jpaRepository.findAll().stream().map(this::convertUserPersistenceToUser)
                .collect(Collectors.toList());
    }
    public String save (UserCC user){
            UserPersistence userPersistence = jpaRepository.save(this.convertUserToUserPersistence(user));
            return user.getUserName();
    }

    @Override
    public UserCC findUser(String username) {
        logger.info("+++++++++LOGGING findUser+++++++++");
        logger.info("username: {}", username);
        try {
            UserPersistence userPersistence = jpaRepository.findById(username).orElse(null);
            logger.info("+++++++++SUCCESSFUL LOGGING findUser+++++++++");
            return convertUserPersistenceToUser(userPersistence);
        }
        catch (Exception e){
            logger.error("ERROR IN FIND USER BY USERNAME:{}",username);
            logger.error("MESSAGE: {}",e.getMessage());
        }
        return null;
    }

    public UserCC convertUserPersistenceToUser(UserPersistence userPersistence){
        return  userPersistence == null ? null : UserCC
                .builder().userName(userPersistence.getUsername())
                .password(userPersistence.getPassword())
                .nickName(userPersistence.getNickName())
                .email(userPersistence.getEmail())
                .category(userPersistence.getCategory()).build();
    }
    public UserPersistence convertUserToUserPersistence(UserCC user){
        return user == null ? null : UserPersistence.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .nickName(user.getNickName())
                .email(user.getEmail())
                .category(user.getCategory())
                .build();
    }

}
