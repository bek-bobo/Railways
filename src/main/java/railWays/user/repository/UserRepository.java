package railWays.user.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository extends BaseRepository<UUID, User> {
    private static final UserRepository userRepository = new UserRepository();

    {
        entities = new HashMap<>();
    }

    public User findByUserName(String userName) {
        ArrayList<User> users = new ArrayList<>(entities.values());
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public static UserRepository getInstance() {
        return userRepository;
    }
}
