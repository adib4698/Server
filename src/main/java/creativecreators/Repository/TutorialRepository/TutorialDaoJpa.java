package creativecreators.Repository.TutorialRepository;
import creativecreators.Entities.Tutorial;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@EnableJpaRepositories(basePackageClasses = TutorialJparepository.class)
public class TutorialDaoJpa {
    private TutorialJparepository jpaRepository;

    public TutorialDaoJpa(TutorialJparepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    public List<Tutorial> findAllTutorials(){
        return jpaRepository.findAll().stream().map(this::convertTutorialPersistenceToTutorial)
                .collect(Collectors.toList());
    }
    public Tutorial convertTutorialPersistenceToTutorial(TutorialPersistence tutorialPersistence){
        return  tutorialPersistence == null ? null : Tutorial
                .builder().id(tutorialPersistence.getId())
                .title(tutorialPersistence.getTitle())
                .description(tutorialPersistence.getDescription())
                .tutorialProfile(tutorialPersistence.getTutorialProfile())
                .video(tutorialPersistence.getVideo())
                .photos(tutorialPersistence.getPhotos())
                .category(tutorialPersistence.getCategory())
                .rating(tutorialPersistence.getRating())
                .build();
    }

}
