package railWays.train.entity;

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
public class Train extends BaseEntity<UUID> {
    private UUID routeId;
    private String name;
    private TrainType type;
    private int speed;

    public Train(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID routeId, String name, TrainType type, int speed) {
        super(uuid, modified, created);
        this.routeId = routeId;
        this.name = name;
        this.type = type;
        this.speed = speed;
    }
}
