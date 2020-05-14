package creativecreators.Repository.CommentsRepository;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class CommentsPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTutorial")
    private String idTutorial;
    @Column(name = "userUsername")
    private String userUsername;
    @Column(name = "comment")
    private String comment;

}