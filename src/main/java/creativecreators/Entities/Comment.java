package creativecreators.Entities;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Comment {
    String idTutorial;
    String userUsername;
    String comment;
}
