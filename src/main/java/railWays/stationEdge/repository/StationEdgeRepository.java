package railWays.stationEdge.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.stationEdge.entity.StationEdge;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationEdgeRepository extends BaseRepository<UUID, StationEdge> {
    private static final StationEdgeRepository stationEdgeRepository = new StationEdgeRepository();
    public static StationEdgeRepository getInstance(){
        return stationEdgeRepository;
    }
}
