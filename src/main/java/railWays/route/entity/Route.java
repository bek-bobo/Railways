package railWays.route.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import railWays.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Route extends BaseEntity<UUID> {
    private UUID originStation;
    private UUID destination;
    private List<UUID> stationIds;

    public Route(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID originStation, UUID destination, List<UUID> stationIds) {
        super(uuid, modified, created);
        this.originStation = originStation;
        this.destination = destination;
        this.stationIds = stationIds;
    }
}
