package railWays.station.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.station.entity.Station;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationRepository extends BaseRepository<UUID, Station> {
    private static final StationRepository stationRepository = new StationRepository();

    public static StationRepository getInstance(){
        return stationRepository;
    }
}
