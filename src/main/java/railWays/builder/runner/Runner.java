package railWays.builder.runner;

import railWays.builder.builders.StationBuilder;
import railWays.builder.builders.UserBuilder;

public class Runner {

    public static void runCode(){
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.start();
        StationBuilder stationBuilder = new StationBuilder();
        stationBuilder.start();
    }
}
