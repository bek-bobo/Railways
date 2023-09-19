package railWays.ui;

import railWays.Main;
import railWays.user.entity.User;

public class TicketUI {



    protected static void ticketUi(User user) {
        boolean isExited = true;
        while (isExited){
            System.out.println("""
                    1. Buy ticket
                    2. My ticket
                    0. Exit
                    >>>\s""");
            int index = Main.scannerInt.nextInt();
            switch (index){
                case 0 -> isExited = false;
                case 1 -> buyTicket(user);
                case 2 -> myTickets(user);
                default -> System.out.println("You have chosen wrong command!");
            }
        }
    }

    private static void buyTicket(User user) {

    }


    protected static void myTickets(User user){}
}
