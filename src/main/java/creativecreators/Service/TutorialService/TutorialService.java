package creativecreators.Service.TutorialService;

import creativecreators.Entities.Tutorial;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TutorialService {

    List<Tutorial> findAllTutorials();
    List<Tutorial> findTutorialsByCategory(String category);
    void addTutorial(String tutorialTitle,String description,String tutorialImage,String video,String photos,String category);
}
