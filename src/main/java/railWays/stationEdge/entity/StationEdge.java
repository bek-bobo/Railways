package railWays.stationEdge.entity;

import lombok.*;
import railWays.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class StationEdge extends BaseEntity<UUID> {
    private UUID leftStation;
    private UUID rightStation;
    private double distance;


    @Builder
    public StationEdge(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID leftStation, UUID rightStation, int distance) {
        super(uuid, modified, created);
        this.leftStation = leftStation;
        this.rightStation = rightStation;
        this.distance = distance;
    }
}
