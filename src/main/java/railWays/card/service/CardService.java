package railWays.card.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.card.entity.Card;
import railWays.card.repository.CardRepository;
import railWays.common.service.Service;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardService implements Service<Card, UUID> {
    private static final CardService cardService = new CardService();
    private final CardRepository cardRepository = CardRepository.getInstance();

    @Override
    public Card findById(UUID uuid) {
        Card byId = cardRepository.findById(uuid);
        if (byId != null) {
            return byId;
        }
        System.out.println("Card didn't find!");
        return null;
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {
        cardRepository.delete(uuid);
    }

    @Override
    public Card add(Card card) {
        List<Card> cards = getAll();
        for (Card existingUser : cards) {
            if (existingUser.getCardNumber().equals(card.getCardNumber())
                && existingUser.getPassword().equals(card.getPassword())) {
                return null;
            }
        }
        return cardRepository.add(card);
    }

    public static CardService getInstance() {
        return cardService;
    }
}
