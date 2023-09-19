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
    private  final  StationRepository stationRepository = StationRepository.getInstance();
    @Override
    public  Station findById(UUID uuid) {
        return stationRepository.findById(uuid);
    }

    @Override
    public List<Station> getAll() {
        return stationRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {
        stationRepository.delete(uuid);
    }

    @Override
    public Station add(Station station) {
        List<Station> all = getAll();
        for (Station existingStation:all){
            if(existingStation.getName().equals(station.getName())){
                return null;
            }
        }
        return stationRepository.add(station);
    }

    public static StationService getInstance(){
        return stationService;
    }
}
