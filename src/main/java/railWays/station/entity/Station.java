package railWays.station.entity;

import lombok.*;
import railWays.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Station extends BaseEntity<UUID> {
    private Location stationLocation;
    private String name;

    @Builder
    public Station(UUID uuid, LocalDateTime modified, LocalDateTime created, Location stationLocation, String name) {
        super(uuid, modified, created);
        this.stationLocation = stationLocation;
        this.name = name;
    }
}
