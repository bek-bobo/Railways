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
    private int password;
    private String endDate;
    private double balance;

    @Builder

    public Card(UUID uuid, LocalDateTime modified, LocalDateTime created, String cardNumber, int password, String endDate, double balance) {
        super(uuid, modified, created);
        this.cardNumber = cardNumber;
        this.password = password;
        this.endDate = endDate;
        this.balance = balance;
    }
}
