package railWays.station.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.station.entity.Station;
import railWays.station.repository.StationRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationService implements Service<Station, UUID> {
    private static final StationService stationService = new StationService();
    private final StationRepository stationRepository = StationRepository.getInstance();
    @Override
    public Station findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Station> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Station add(Station station) {
        return null;
    }

    public static StationService getInstance(){
        return stationService;
    }
}
