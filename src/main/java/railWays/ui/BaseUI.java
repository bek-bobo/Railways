package railWays.ui;

import railWays.Main;
import railWays.user.entity.User;
import railWays.user.entity.UserType;
import railWays.user.repository.UserRepository;
import railWays.user.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BaseUI {
    private static final UserService userService = UserService.getInstance();
    private static final UserRepository userRepository = UserRepository.getInstance();
    private static final HashMap<UUID, User> users = userRepository.users;

    {
        User build = User.builder()
                .uuid(UUID.randomUUID())
                .firstName("Abbi")
                .lastName("A")
                .age(19)
                .phoneNumber("+998972227999")
                .passportId("AA12345")
                .username("qod1r_c1k")
                .password("1234")
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
        System.out.print("Please enter your passwordId: ");
        String passwordId = Main.scannerStr.nextLine();
        System.out.print("Please enter your username: ");
        String username = Main.scannerStr.nextLine();
        System.out.print("Please enter your password: ");
        String password = Main.scannerStr.nextLine();
        User userBuild = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .phoneNumber(phoneNumber)
                .passportId(passwordId)
                .username(username)
                .password(password)
                .userType(UserType.USER)
                .build();
        userBuild = userService.add(userBuild);
        if (userBuild == null){
            System.out.println("This phone number has been already used !!! ");
        }else {
            System.out.println("You have register successfully !!! ");
        }
    }
    public void signIn(){
        System.out.print("Please enter your phoneNumber: ");
        String phoneNumber = Main.scannerStr.nextLine();
        System.out.print("Please enter your password: ");
        String password = Main.scannerStr.nextLine();
        User user = userService.signIn(phoneNumber, password);
        if (user == null){
            System.out.println("Phone number of password is wrong !!! ");
        }else {
            switch (user.getUserType()){
                case USER -> new UserUI().start(user);
                case ADMIN -> new AdminUI().start();
                case DRIVER -> new DriverUI().start(user);
            }
        }
    }
}
