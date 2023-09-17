package railWays.ui;

import railWays.Main;
import railWays.user.entity.User;
import railWays.user.service.UserService;

import java.util.List;

public class AdminUI {

    private static final UserService userService = UserService.getInstance();

    public void start(User user) {
        boolean isExited = true;
        while (isExited){
            System.out.print("""
                    1. Get users
                    0. Exit
                    >>\s""");
            int command = Main.scannerInt.nextInt();
            switch (command){
                case 0 -> isExited = false;
                case 1 -> getUsers();
                default -> System.out.println("You have entered wrong command !!! ");
            }
        }
    }

    private static void getUsers(){
        List<User> allUsers = userService.getAll();

        for (User user:allUsers){
            System.out.printf(
                    """
                            1. First name : %s
                            2. Last name : %s
                            3. Age %s
                            4. Phone number : %s
                            5. Passport id : %s
                            6. Username : %s
                            7. Password : %s
                            8. User type : %s
                            9. Cards id : %s
                            10. tickets id : %s
                                        
                            --> %n""", user.getFirstName(),
                 user.getLastName(),
                 user.getAge(),
                 user.getPhoneNumber(),
                 user.getPassportId(),
                 user.getUsername(),
                 user.getPassword(),
                 user.getUserType(),
                 user.getCardsId().toString(),
                 user.getTicketsId().toString()
         );
        }

    }


}
