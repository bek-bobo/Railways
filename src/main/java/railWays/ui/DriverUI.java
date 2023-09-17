package railWays.ui;


import railWays.Main;
import railWays.user.entity.User;

public class DriverUI {
    public void start(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.print("""
                    1. D
                    2.
                    0. Exit
                    >>\s""");
            int command = Main.scannerInt.nextInt();
            switch (command){
                case 0 -> isExited = false;
                default -> System.out.println("You have entered wrong command !!! ");
            }
        }
    }
}
