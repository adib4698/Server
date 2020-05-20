package creativecreators.Entities;

import creativecreators.Repository.TutorialRepository.TutorialPersistence;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Tutorial{
    private String id;
    private String title;
    private String description;
    private String tutorialProfile;
    private String video;
    private String photos;
    private String category;
    private Integer rating;
    private Integer visibility;


}
