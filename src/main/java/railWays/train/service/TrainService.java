package railWays.train.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.train.entity.Train;
import railWays.train.repository.TrainRepository;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrainService implements Service<Train, UUID> {
    private static final TrainService trainService = new TrainService();
    private final TrainRepository trainRepository = TrainRepository.getInstance();
    @Override
    public Train findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Train> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Train add(Train train) {
        return null;
    }

    public static TrainService getInstance(){
        return trainService;
    }
}
