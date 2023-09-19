package railWays.stationEdge.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import railWays.common.entity.BaseEntity;
import railWays.station.entity.Station;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class StationEdge extends BaseEntity<UUID> {
    private Station leftStation;
    private Station rightStation;
    private double distance;

    public StationEdge(UUID uuid, LocalDateTime modified, LocalDateTime created, Station leftStation, Station rightStation, int distance) {
        super(uuid, modified, created);
        this.leftStation = leftStation;
        this.rightStation = rightStation;
        this.distance = distance;
    }
}
