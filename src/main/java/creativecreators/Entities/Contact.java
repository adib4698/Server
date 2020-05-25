package creativecreators.Entities;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Contact {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String comment;
}
