package railWays.user.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.user.entity.User;
import railWays.user.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService implements Service<User, UUID> {
    private static final UserService userService = new UserService();
    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public User findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.delete(uuid);
    }

    @Override
    public User add(User user) {
        List<User> users = getAll();
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
        return userRepository.add(user);
    }

    public User signIn(String userName, String password) {
        User byUserName = userRepository.findByUserName(userName);
        if (byUserName != null) {
            if (byUserName.getPassword().equals(password)) {
                return byUserName;
            }
        }
        return null;
    }

    public static UserService getInstance() {
        return userService;
    }
}
