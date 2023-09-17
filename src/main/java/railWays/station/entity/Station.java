package railWays.station.entity;

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
public class Station extends BaseEntity<UUID> {
    private String stationLocation;
    private String name;

    public Station(UUID uuid, LocalDateTime modified, LocalDateTime created, String stationLocation, String name) {
        super(uuid, modified, created);
        this.stationLocation = stationLocation;
        this.name = name;
    }
}
