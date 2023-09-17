package railWays.vagon.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.vagon.entity.Wagon;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WagonRepository extends BaseRepository<UUID, Wagon> {
    private static final WagonRepository wagonRepository = new WagonRepository();
    public static WagonRepository getInstance(){
        return wagonRepository;
    }
}
