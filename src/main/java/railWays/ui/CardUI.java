package railWays.ui;

import railWays.Main;
import railWays.card.entity.Card;
import railWays.card.service.CardService;
import railWays.user.entity.User;

import java.util.List;
import java.util.UUID;

public class CardUI {

    private static final CardService cardService = CardService.getInstance();

    protected static void cardUI(User user) {
        boolean isExit = true;
        while (isExit){
            System.out.print("""
                    
                    {}--------------------------{}
                        1. add Card
                        2. My cards
                        3. Complete balance
                        4. Card setting
                        
                        0. Exit
                    """);

            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExit = false;
                case 1 -> CardUI.addCard(user);
                    default -> {
                        System.out.println("Wrong command, please try again!");
                    }

            }

        }
    }

    private static void addCard(User user) {
        System.out.println();
    }


    protected static void MyCards(User user) {

        StringBuilder myCars = new StringBuilder();
        for (UUID uuid: user.getCardsId()){
            Card card = cardService.findById(uuid);
            myCars.append("""
                    [%s - %s]\s
                    """.formatted(card.getCardType(), card.getCardNumber()));
        }

        System.out.printf("""
                --------------
                %s
                --------------- %n""", myCars);
    }


    protected static String getUserCards(User user) {
        List<UUID> cardsId = user.getCardsId();
        StringBuilder cardUi = new StringBuilder();
        for (UUID uuid : cardsId) {
            Card card = cardService.findById(uuid);

            cardUi.append("""
                                
                                {
                                      (1). Card number : %s
                                      (2). Card password : %s
                                      (3). CArd ended time: %s
                                      (4). Card type: %s
                                      (5). Balance : %s
                                } \s
                    """.formatted(
                    card.getCardNumber(),
                    "****",
                    card.getEndDate(),
                    card.getCardType(),
                    card.getBalance()));

        }

        return cardUi.toString();
    }


}
