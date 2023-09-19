package railWays.stationEdge.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.station.entity.Station;
import railWays.station.service.StationService;
import railWays.stationEdge.entity.StationEdge;
import railWays.stationEdge.repository.StationEdgeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationEdgeService implements Service<StationEdge, UUID> {

    private static final StationEdgeService stationEdgeService = new StationEdgeService();
    private static final StationService stationService = StationService.getInstance();
    private static final List<StationEdge> stationEdges = new ArrayList<>();
    private static final StationEdgeRepository stationEdgeRepository = StationEdgeRepository.getInstance();

    static {
        List<Station> stations = stationService.getStationList();
        Random random = new Random();
        for (int i=0; i<stations.size()-1; i++){
            StationEdge stationEdge = new StationEdge();
            stationEdge.setLeftStation(stations.get(i));
            stationEdge.setRightStation(stations.get(i+1));
            stationEdge.setDistance(50+(600-50)*random.nextDouble());
            stationEdges.add(stationEdge);
        }

    }
    @Override
    public StationEdge findById(UUID uuid) {
        return null;
    }

    @Override
    public List<StationEdge> getAll() {
        return stationEdgeRepository.getAll();
    }

    public List<StationEdge> getStationEdges(){
        return stationEdges;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public StationEdge add(StationEdge stationEdge) {
        return null;
    }

    public static StationEdgeService getInstance(){
        return stationEdgeService;
    }
}
