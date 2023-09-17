package railWays.ui;

import railWays.Main;
import railWays.card.entity.Card;
import railWays.card.service.CardService;
import railWays.user.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserUI {
    private static final CardService cardService = CardService.getInstance();

    public void start(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.print("""
                    1. Account
                    2. Ticket
                    3. Balance
                    0. Exit
                    >>>\s""");
            int command = Main.scannerInt.nextInt();
            switch (command) {
                case 0 -> isExited = false;
                case 1 -> myAccount(user);
                case 2 -> ticket(user);
                default -> System.out.println("You have entered wrong command !!! ");
            }
        }
    }

    private void ticket(User user) {
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

    private void buyTicket(User user) {

    }

    private void myAccount(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.println("Name: %s(%s) \nSurname: %s\nUsername: %s\nPhone number: %s\nAge: %d\n"
                    .formatted(user.getFirstName(), user.getUserType().toString(), user.getLastName(),
                            user.getUsername(), user.getPhoneNumber(), user.getAge()));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("""
                    1. Complete balance
                    2. Change personal information
                    3. My cards
                    4. My tickets
                    0. Exit
                    >>>\s""");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                case 1 -> completeBalance(user);
                case 2 -> changePersonalInfo(user);
                case 4 -> myTickets(user);
                default -> System.out.println("Entered wrong command!");
            }
        }
    }

    private void myTickets(User user) {

    }

    private void changePersonalInfo(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.println("Name: %s(%s) \nSurname: %s\nUsername: %s\nPhone number: %s\nAge: %d\n"
                    .formatted(user.getFirstName(), user.getUserType().toString(), user.getLastName(),
                            user.getUsername(), user.getPhoneNumber(), user.getAge()));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("""
                    1. Change name
                    2. Change surname
                    3. Change phone number
                    4. Change username
                    5. Change password
                    0. Exit
                    >>>\s""");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                case 1 -> changeName(user);
                case 2 -> changeSurname(user);
                case 3 -> changePhoneNumber(user);
                case 4 -> changeUserName(user);
                case 5 -> changePassword(user);
                default -> {
                    System.out.println("Wrong command, please try again!");
                }
            }

        }
    }

    private void changeName(User user) {
        boolean isExited = true;
        while (isExited) {
            System.out.println("Current name is: %s".formatted(user.getFirstName()));
            System.out.println("Please write a new name: \s");
            String name = Main.scannerStr.nextLine();
            if (name.length() > 2 && name.length() < 21) {
                user.setFirstName(name);
                System.out.println("Name successfully changed to: " + name);
                isExited = false;
            } else {
                System.out.println("Please write name min length-3 and max 20");
                System.out.println("Write 0 to cansel! ");
                int cansel = Main.scannerInt.nextInt();
                if (cansel == 0) {
                    isExited = false;
                }
            }
        }
    }

    private void completeBalance(User user) {
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
                            .formatted(card.getCardNumber(), card.getEndDate().toString(), card.getBalance()));
                    count++;
                }
                System.out.println("0. Exit");
            }
            System.out.println("Choose card");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                default -> {
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
    }
}
