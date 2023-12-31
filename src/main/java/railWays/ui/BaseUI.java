package railWays.ui;

import railWays.Main;
import railWays.user.entity.User;
import railWays.user.entity.UserType;
import railWays.user.service.UserService;

import java.util.ArrayList;
import java.util.UUID;

public class BaseUI {
    private static final UserService userService = UserService.getInstance();


    static {
        User build = User.builder()
                .uuid(UUID.randomUUID())
                .firstName("1")
                .lastName("1")
                .age(19)
                .phoneNumber("+998972227999")
                .passportId("AA12345")
                .username("1")
                .password("1")
                .userType(UserType.ADMIN)
                .cardsId(new ArrayList<>())
                .ticketsId(new ArrayList<>())
                .build();
        userService.add(build);
    }

    public void start(){
        boolean isExited = true;
        while (isExited){
            System.out.print("""
                    1. Register
                    2. SignIn
                    0. Exit
                    >>>\s""");
            int command = Main.scannerInt.nextInt();
            switch (command){
                case 1 -> register();
                case 2 -> signIn();
                case 0 -> isExited = false;
                default -> System.out.println("You have entered wrong command !!! ");
            }

        }
    }
    public void register(){
        System.out.print("Please enter your firstName: ");
        String firstName = Main.scannerStr.nextLine();
        System.out.print("Please enter your lastName: ");
        String lastName = Main.scannerStr.nextLine();
        System.out.print("Please enter your age: ");
        int age = Main.scannerInt.nextInt();
        System.out.print("Please enter your phoneNumber: ");
        String phoneNumber = Main.scannerStr.nextLine();
        System.out.print("Please enter your username: ");
        String username = Main.scannerStr.nextLine();
        System.out.print("Please enter your password: ");
        String password = Main.scannerStr.nextLine();
        User userBuild = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .phoneNumber(phoneNumber)
                .username(username)
                .password(password)
                .userType(UserType.USER)
                .cardsId(new ArrayList<>())
                .ticketsId(new ArrayList<>())
                .build();

        userBuild = userService.add(userBuild);
        if (userBuild == null){
            System.out.println("This username has been already used !!! ");
        }else {
            System.out.println("You have register successfully !!! ");
        }
    }
    public void signIn(){
        System.out.print("Please enter your username: ");
        String userName = Main.scannerStr.nextLine();
        System.out.print("Please enter your password: ");
        String password = Main.scannerStr.nextLine();
        User user = userService.signIn(userName, password);
        if (user == null){
            System.out.println("Current user doesn't exist! Please try again!");
        }else {
            switch (user.getUserType()){
                case USER -> new UserUI().userUI(user);
                case ADMIN -> new AdminUI().start(user);
            }
        }
    }
}
