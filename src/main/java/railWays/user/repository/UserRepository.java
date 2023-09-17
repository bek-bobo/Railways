package railWays.user.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.user.entity.User;

import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository extends BaseRepository<UUID, User> {
    private static final UserRepository userRepository = new UserRepository();

    public User findByPhoneNumber(String phoneNumber){
        ArrayList<User> users = new ArrayList<>(entities.values());
        for(User user : users){
            if (user.getPhoneNumber().equals(phoneNumber)){
                return user;
            }
        }
        return null;
    }

    public static UserRepository getInstance(){
        return userRepository;
    }
}
