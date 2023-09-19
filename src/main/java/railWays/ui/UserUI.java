package railWays.ui;

import railWays.Main;
import railWays.card.entity.Card;
import railWays.card.service.CardService;
import railWays.user.entity.User;
import railWays.user.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserUI {
    private static final CardService cardService = CardService.getInstance();
    private static final UserService userService = UserService.getInstance();


    public void userUI(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.print("""
                                        
                    {}----------------------------------{}
                        1. Account
                        2. Ticket
                        3. Balance
                        0. Exit
                    >>> \s""");
            int command = Main.scannerInt.nextInt();
            switch (command) {
                case 0 -> isExited = false;
                case 1 -> myAccount(user);
                case 2 -> TicketUI.ticketUi(user);
                case 3 -> completeBalance(user);
                default -> System.out.println("You have entered wrong command !!! ");
            }
        }
    }

    private static void myAccount(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.print("""
                                        
                    {}----------------------------------{}
                        1. Complete balance
                        2. My Cards
                        3. My Ticket
                        4. User setting
                        
                        0. Exit
                    >>> \s""");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                case 1 -> UserUI.changePersonalInfo(user);
                case 2 -> CardUI.MyCards(user);
                case 3 -> TicketUI.myTickets(user);
                case 4 -> UserUI.userSetting(user);
                default -> System.out.println("Entered wrong command!");
            }
        }
    }

    private static void userSetting(User user){
        boolean isExited = true;
        while (isExited) {
            System.out.print("""
                                        
                    {}----------------------------------{}
                        1. Show user info
                        2. Change user info
                        
                        0. Exit
                    >>> \s""");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                case 1-> UserUI.showUserInfo(user);
                case 2 -> UserUI.changePersonalInfo(user);
                default -> System.out.println("Entered wrong command!");
            }
        }



    }

    private static void changePersonalInfo(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.printf("Name: %s(%s) \nSurname: %s\nUsername: %s\nPhone number: %s\nAge: %d\n\n"
                    .formatted(user.getFirstName(), user.getUserType().toString(), user.getLastName(),
                            user.getUsername(), user.getPhoneNumber(), user.getAge()));
            System.out.print("""
                                        
                    {}----------------------------------{}
                        1. Change name
                        2. Change surname
                        3. Change phone number
                        4. Change username
                        5. Change password
                        6. Change passportID
                        
                        0. Exit
                    >>>\s""");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                case 1 -> UserUI.changeName(user);
                case 2 -> UserUI.changeSurname(user);
                case 3 -> UserUI.changePhoneNumber(user);
                case 4 -> UserUI.changeUserName(user);
                case 5 -> UserUI.changePassword(user);
                case 6 -> UserUI.changePassportId(user);
                default -> {
                    System.out.println("Wrong command, please try again!");
                }
            }

        }
    }

    private static void changePassportId(User user) {

    }

    private static void changePassword(User user) {
    }

    private static void changeUserName(User user) {

    }

    private static void changePhoneNumber(User user) {

    }

    private static void changeSurname(User user) {

    }

    private static void changeName(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.printf("""
                                        
                    {}----------------------------------{}
                        Current name is: %s
                        Please write a new name: \s
                    """, user.getFirstName());
            String name = Main.scannerStr.nextLine();


            if (name.length() > 2 && name.length() < 21) {
                user.setFirstName(name);
                System.out.printf("""
                                                
                        {}----------------------------------{}
                            Name successfully changed to: %s
                        """, name);
                isExited = false;
            } else {
                System.out.println("""
                                                
                        {}----------------------------------{}
                            Please write name min length-3 and max 20
                            Write 0 to cansel!
                            ---> \s""");
                int cansel = Main.scannerInt.nextInt();
                if (cansel == 0) {
                    isExited = false;
                }
            }
        }
    }

    private static void completeBalance(User user) {
        boolean isExited = true;
        List<Card> cards = new ArrayList<>();
        int count = 1;
        while (isExited) {
            System.out.println("Choose card which you need: ");
            for (UUID cardId : user.getCardsId()) {
                Card card = cardService.findById(cardId);
                cards.add(card);
                if (card != null) {
                    System.out.println(count + ". Card number: %s\nEnd date: %s\nBalance: %s"
                            .formatted(card.getCardNumber(), card.getEndDate(), card.getBalance()));
                    count++;
                }
                System.out.println("0. Exit");
            }
            System.out.println("Choose card");
            int index = Main.scannerInt.nextInt();
            if (index == 0) {
                isExited = false;
            } else {
                if (index > 0 && index < count) {
                    System.out.println("Write amount of money for top up balance: ");
                    double amount = Main.scannerInt.nextInt();
                    if (amount > 0) {
                        cards.get(count - 1).setBalance(amount);
                        System.out.println("Successfully changed balance of card %s to: "
                                                   .formatted(cards.get(count - 1).getCardNumber()) + amount);
                    } else {
                        System.out.println("Please write of money bigger than zero!");
                    }
                } else {
                    System.out.println("Incorrect chose!");
                }
            }
        }
    }

    private static void showUserInfo(User user) {
        boolean isExited = true;
        while (isExited) {
            UserUI.getUser(user);
            System.out.println("""
                    Exit -> 0
                    ----> \s""");
            int index = Main.scannerInt.nextInt();
            if (index == 0) {
                isExited = false;
            }
        }
    }

    protected static void getUser(User user) {
        System.out.printf(
                """
                        {}--------------------------{}
                          
                              First name : %s
                              Surname : %s
                              Age %s
                              Phone number : %s
                              Passport id : %s
                              Username : %s
                              Password : %s
                              User type : %s
                              Cards id : %s
                              tickets id : %s
                                     
                        ------------------------------> \n""",
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getPhoneNumber(),
                user.getPassportId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserType(),
                CardUI.getUserCards(user),
                user.getTicketsId().toString()
        );
    }





}
