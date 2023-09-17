package railWays.user.userBuilder;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import railWays.user.entity.User;
import railWays.user.entity.UserType;
import railWays.user.repository.UserRepository;
import railWays.user.service.UserService;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class UserBuilder extends Thread{

    private final UserService userService = UserService.getInstance();

    Faker faker = new Faker();

    Random random= new Random();

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public void creatUsers(){

        for (int i= 0; i < 50;i++){
            userService.add(
                    User.builder()
                    .uuid(UUID.randomUUID())
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .age(random.nextInt(16,90))
                    .phoneNumber(generateNumber("12"))
                    .passportId(generateLetters() + generateNumber("7"))
                    .username(faker.name().username())
                    .password(generatePassword())
                    .userType(UserType.USER)
                    .cardsId(new ArrayList<>())
                    .ticketsId(new ArrayList<>()

            ).build());
        }

    }

    public String generateNumber(String num){
        //"+998 97 707 18 08;
        return "+" + fakeValuesService.regexify("[1-9]{%s}".formatted(num));

    }
    public String generateLetters(){
        return fakeValuesService.regexify("[A-Z]{2}");
    }

    public String generatorEmail(){
      return  fakeValuesService.bothify("????##@gmail.com");
    }

    public String generatePassword(){
        String number = String.valueOf(random.nextInt(8,16));
        return fakeValuesService.regexify("[a-z1-9A-z]{%s}".formatted(number));
    }

    @Override
    public synchronized void start() {
        creatUsers();
    }
}
