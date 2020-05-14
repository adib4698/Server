package creativecreators.Service.TutorialService;

import creativecreators.Entities.Tutorial;

import java.util.List;

public interface TutorialService {

    List<Tutorial> findAllTutorials();
    List<Tutorial> findTutorialsByCategory(String category);
}
