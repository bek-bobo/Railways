package railWays.builder.builders;

import railWays.card.entity.Card;
import railWays.card.entity.CardType;
import railWays.card.service.CardService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static railWays.builder.builders.OwnBuilder.*;

public class CardBuilder {


    private static final CardService cardService = CardService.getInstance();


    protected static List<UUID> generateCard() {
        ArrayList<UUID> cards = new ArrayList<>();
        for (int i = 0; i < random.nextInt(1, 6); i++) {
            Card build = Card.builder()
                    .uuid(UUID.randomUUID())
                    .balance(random.nextInt())
                    .cardNumber(generateNumber("16"))
                    .endDate(LocalDateTime.now().plusYears(1))
                    .modified(LocalDateTime.now())
                    .password(generateNumber("4"))
                    .cardType(chooseCardType(random.nextInt(1, 6)))
                    .build();

            cardService.add(build);
            cards.add(build.getId());
        }
        return cards;

    }

    private static CardType chooseCardType(int i) {
        switch (i) {
            case 1 -> {
                return CardType.HUMO;
            }
            case 2 -> {
                return CardType.MASTERCARD;
            }
            case 3 -> {
                return CardType.VISA;
            }
            case 4 -> {
                return CardType.UZCARD;
            }
            default -> {
                return CardType.ASIA_ALLIANCE_BANK;
            }
        }
    }
}
