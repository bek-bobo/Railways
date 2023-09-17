package railWays.user.entity;

import lombok.*;
import railWays.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity<UUID> {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String passportId;
    private String username;
    private String password;
    private UserType userType;

    @Builder
    public User(UUID uuid, LocalDateTime modified, LocalDateTime created, String firstName, String lastName,
                int age, String phoneNumber, String passportId, String username, String password, UserType userType) {
        super(uuid, modified, created);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.passportId = passportId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}
