package railWays.ui;

import railWays.Main;
import railWays.user.entity.User;

public class UserUI {
    public void start(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.print("""
                    1. U
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
