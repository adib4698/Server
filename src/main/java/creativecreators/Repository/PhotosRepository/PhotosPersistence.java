package creativecreators.Repository.PhotosRepository;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "photos")
public class PhotosPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTutorial")
    private String idTutorial;
    @Column(name = "photo")
    private String photo;

}