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
@Table(name = "contact")
public class ContactPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    @Column(name = "email")
    String email;
    @Column(name = "phone")
    String phone;
    @Column(name = "comment")
    String comment;
}
