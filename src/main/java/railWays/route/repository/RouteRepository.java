package railWays.route.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.route.entity.Route;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RouteRepository extends BaseRepository<UUID, Route> {
    private static final RouteRepository routeRepository = new RouteRepository();

    public static RouteRepository getInstance(){
        return routeRepository;
    }
}
