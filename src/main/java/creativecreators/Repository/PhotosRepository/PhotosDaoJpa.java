package creativecreators.Repository.PhotosRepository;

import creativecreators.Entities.Photos;
import creativecreators.Entities.UserCC;
import creativecreators.Repository.UserRepository.UserDaoJpa;
import creativecreators.Repository.UserRepository.UserPersistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@EnableJpaRepositories(basePackageClasses = PhotosJparepository.class)
public class PhotosDaoJpa implements PhotosRepository {
    private PhotosJparepository photosJparepository;

    public PhotosDaoJpa(PhotosJparepository photosJparepository) {
        this.photosJparepository = photosJparepository;
    }
    private final Logger logger = LogManager.getLogger(UserDaoJpa.class);

    private Photos convertPhtosPersistenceToPhotos(PhotosPersistence photosPersistence) {
        return  photosPersistence == null ? null : Photos
                .builder().idTutorial(photosPersistence.getIdTutorial())
                .photo(photosPersistence.getPhoto())
                .build();
    }

    @Override
    public String getPhotos(Integer idTutorial) {
        logger.info("+++++++++LOGGING findUser+++++++++");
        logger.info("tutorial: {}", idTutorial);
        try {
            PhotosPersistence photosPersistence = photosJparepository.findById(idTutorial.toString()).orElse(null);
            logger.info("+++++++++SUCCESSFUL LOGGING findUser+++++++++");
            return photosPersistence.getPhoto();
        }
        catch (Exception e){
            logger.error("ERROR IN FIND USER BY USERNAME:{}",idTutorial);
            logger.error("MESSAGE: {}",e.getMessage());
        }
        return null;
    }

}
