package railWays.card.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.card.entity.Card;
import railWays.common.repository.BaseRepository;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardRepository extends BaseRepository<UUID, Card> {
    private static final CardRepository cardRepository = new CardRepository();
    public static CardRepository getInstance(){
        return cardRepository;
    }
}
