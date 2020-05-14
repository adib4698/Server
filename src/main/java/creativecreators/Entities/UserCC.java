package creativecreators.Entities;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCC {
    private String userName;
    private String password;
    private String nickName;
    private String email;
    private String category;


}

