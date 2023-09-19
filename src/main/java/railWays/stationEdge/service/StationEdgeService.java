package railWays.stationEdge.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.stationEdge.entity.StationEdge;
import railWays.stationEdge.repository.StationEdgeRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationEdgeService implements Service<StationEdge, UUID> {

    private static final StationEdgeService stationEdgeService = new StationEdgeService();
    private final StationEdgeRepository stationEdgeRepository = StationEdgeRepository.getInstance();
    @Override
    public StationEdge findById(UUID uuid) {
        return stationEdgeRepository.findById(uuid);
    }

    @Override
    public List<StationEdge> getAll() {
        return stationEdgeRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {
        stationEdgeRepository.delete(uuid);
    }

    @Override
    public StationEdge add(StationEdge stationEdge) {
        return null;
    }

    public static StationEdgeService getInstance(){
        return stationEdgeService;
    }
}
