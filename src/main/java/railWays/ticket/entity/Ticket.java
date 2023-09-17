package railWays.ticket.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import railWays.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Ticket extends BaseEntity<UUID> {
    private UUID originStationId;
    private UUID destinationStationId;
    private UUID wagonId;
    private boolean isSold;
    private LocalDateTime deportTime;
    private LocalDateTime arrivedTime;
    private LocalDateTime durationTime;
    private double price;

    public Ticket(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID originStationId, UUID destinationStationId, UUID wagonId, boolean isSold, LocalDateTime deportTime, LocalDateTime arrivedTime, LocalDateTime durationTime, double price) {
        super(uuid, modified, created);
        this.originStationId = originStationId;
        this.destinationStationId = destinationStationId;
        this.wagonId = wagonId;
        this.isSold = isSold;
        this.deportTime = deportTime;
        this.arrivedTime = arrivedTime;
        this.durationTime = durationTime;
        this.price = price;
    }
}
