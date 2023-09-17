package railWays.vagon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import railWays.common.entity.BaseEntity;
import railWays.train.entity.TrainType;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Wagon extends BaseEntity<UUID> {
    private UUID trainId;
    private String number;
    private TrainType trainType;
    private int capacity;
    private double price;

    public Wagon(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID trainId, String number,
                 TrainType trainType, int capacity, double price) {
        super(uuid, modified, created);
        this.trainId = trainId;
        this.number = number;
        this.trainType = trainType;
        this.capacity = capacity;
        this.price = price;
    }
}
