package railWays.train.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.train.entity.Train;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrainRepository extends BaseRepository<UUID, Train> {
    private static final TrainRepository trainRepository = new TrainRepository();

    public static TrainRepository getInstance(){
        return trainRepository;
    }
}
