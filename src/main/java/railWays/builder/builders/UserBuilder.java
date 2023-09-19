package railWays.builder.builders;

import railWays.user.entity.User;
import railWays.user.entity.UserType;
import railWays.user.service.UserService;

import java.util.ArrayList;
import java.util.UUID;

import static railWays.builder.builders.CardBuilder.generateCard;
import static railWays.builder.builders.OwnBuilder.*;

public class UserBuilder extends Thread {

    private static final UserService userService = UserService.getInstance();


    private static void creatUsers() {

        for (int i = 0; i < 50; i++) {
            userService.add(
                    User.builder()
                            .uuid(UUID.randomUUID())
                            .firstName(faker.name().firstName())
                            .lastName(faker.name().lastName())
                            .age(random.nextInt(16, 90))
                            .phoneNumber("+"+generateNumber("12"))
                            .passportId(generateLetters() + generateNumber("7"))
                            .username(faker.name().username())
                            .password(generatePassword())
                            .userType(UserType.USER)
                            .cardsId(generateCard())
                            .ticketsId(new ArrayList<>()
                            ).build());
        }

    }


    @Override
    public synchronized void start() {
        creatUsers();
    }
}
