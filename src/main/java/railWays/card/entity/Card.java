package railWays.card.entity;

import lombok.*;
import railWays.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Card extends BaseEntity<UUID> {
    private String cardNumber;
    private String password;
    private LocalDateTime endDate;
    private double balance;
    private CardType cardType;


    @Builder
    public Card(UUID uuid, LocalDateTime modified, LocalDateTime created, String cardNumber,
                String password, LocalDateTime endDate, double balance, CardType cardType) {
        super(uuid, modified, created);
        this.cardNumber = cardNumber;
        this.password = password;
        this.endDate = endDate;
        this.balance = balance;
        this.cardType = cardType;
    }

}
