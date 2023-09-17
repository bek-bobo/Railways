package railWays.schedule.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import railWays.common.entity.BaseEntity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Schedule extends BaseEntity<UUID> {
    private UUID routeId;
    private UUID trainId;
    private Time arrivalTime;
    private Time departureTime;
    private Time travelTime;

    public Schedule(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID routeId, UUID trainId,
                    Time arrivalTime, Time departureTime, Time travelTime) {
        super(uuid, modified, created);
        this.routeId = routeId;
        this.trainId = trainId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.travelTime = travelTime;
    }
}
