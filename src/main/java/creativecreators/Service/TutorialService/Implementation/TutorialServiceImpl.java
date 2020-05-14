package creativecreators.Service.TutorialService.Implementation;


import creativecreators.Entities.Tutorial;
import creativecreators.Repository.TutorialRepository.TutorialDaoJpa;
import creativecreators.Service.TutorialService.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@Component
@Primary
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialDaoJpa tutorialDao;
    @Override
    public List<Tutorial> findAllTutorials() {
        return tutorialDao.findAllTutorials();
    }

    @Override
    public List<Tutorial> findTutorialsByCategory(String category) {
        List<Tutorial> tutorials = new ArrayList<>();
        for (Tutorial t: tutorialDao.findAllTutorials()
             ) {
            if(t.getCategory().equals(category))
                tutorials.add(t);
        }
        return tutorials;
    }

}
