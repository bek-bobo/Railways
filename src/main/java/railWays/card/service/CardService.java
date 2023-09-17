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
        return null;
    }

    @Override
    public List<Card> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Card add(Card card) {
        return null;
    }

    public static CardService getInstance(){
        return cardService;
    }
}
