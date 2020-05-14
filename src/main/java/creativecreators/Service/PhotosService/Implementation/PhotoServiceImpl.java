package creativecreators.Service.PhotosService.Implementation;


import creativecreators.Repository.PhotosRepository.PhotosDaoJpa;
import creativecreators.Service.PhotosService.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@org.springframework.stereotype.Service
@Component
@Primary
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotosDaoJpa photosDao;

    @Override
    public String getPhotos(Integer idTutorial) {
        return photosDao.getPhotos(idTutorial);

    }
}
