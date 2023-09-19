package railWays.ui;

import railWays.Main;
import railWays.station.entity.Station;
import railWays.station.service.StationService;
import railWays.user.entity.User;
import railWays.user.service.UserService;

import java.util.List;

public class AdminUI {

    private static final UserService userService = UserService.getInstance();

    private static final StationService service = StationService.getInstance();


    public void start(User user) {
        boolean isExited = true;
        while (isExited){
            System.out.print("""
                    1. Get users
                    2. Get Stations
                    0. Exit
                    >>\s""");
            int command = Main.scannerInt.nextInt();
            switch (command){
                case 0 -> isExited = false;
                case 1 -> getUsers();
                case 2 -> getStations();
                default -> System.out.println("You have entered wrong command !!! ");
            }
        }
    }



    private static void getUsers(){
        List<User> allUsers = userService.getAll();

        for (User user:allUsers){
            UserUI.getUser(user);
        }
    }


    private static void getStations(){
        List<Station> serviceAll = service.getAll();

        for (Station station:serviceAll){
            StationUI.getStations(station);
        }
    }


}