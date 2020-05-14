package creativecreators.Repository.TutorialRepository;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tutorials")
public class TutorialPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "tutorialprofile")
    private String tutorialProfile;
    @Column(name = "video")
    private String video;
    @Column(name = "photos")
    private String photos;
    @Column(name = "category")
    private String category;
    @Column(name = "rating")
    private Integer rating;


}
