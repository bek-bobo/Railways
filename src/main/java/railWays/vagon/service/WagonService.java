package railWays.vagon.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.vagon.entity.Wagon;
import railWays.vagon.repository.WagonRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WagonService implements Service<Wagon, UUID> {
    private static final WagonService wagonService = new WagonService();
    private final WagonRepository wagonRepository = WagonRepository.getInstance();
    @Override
    public Wagon findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Wagon> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Wagon add(Wagon wagon) {
        return null;
    }

    public static WagonService getInstance(){
        return wagonService;
    }
}
