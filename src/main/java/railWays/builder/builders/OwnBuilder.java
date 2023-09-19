package railWays.builder.builders;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
import java.util.Random;

public class OwnBuilder {

    protected static Faker faker = new Faker();
    protected static Random random = new Random();
    protected static FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());


    protected static String generateNumber(String num) {
        //"+998 97 707 18 08;
        return fakeValuesService.regexify("[1-9]{%s}".formatted(num));

    }

    protected static String generateLetters() {
        return fakeValuesService.regexify("[A-Z]{2}");
    }

    protected static String generatorEmail() {
        return fakeValuesService.bothify("????##@gmail.com");
    }

    protected static String generatePassword() {
        String number = String.valueOf(random.nextInt(8, 16));
        return fakeValuesService.regexify("[a-z1-9A-z]{%s}".formatted(number));
    }

}
