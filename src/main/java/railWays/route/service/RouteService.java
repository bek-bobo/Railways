package railWays.route.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.route.entity.Route;
import railWays.route.repository.RouteRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RouteService implements Service<Route, UUID> {

    private static final RouteService routeService = new RouteService();
    private final RouteRepository routeRepository = RouteRepository.getInstance();
    @Override
    public Route findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Route> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Route add(Route route) {
        return null;
    }

    public static RouteService getInstance(){
        return routeService;
    }
}
