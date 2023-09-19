package railWays.ui;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import railWays.Main;
import railWays.route.entity.Route;
import railWays.route.service.RouteService;
import railWays.station.entity.Station;
import railWays.station.service.StationService;
import railWays.stationEdge.entity.StationEdge;
import railWays.stationEdge.service.StationEdgeService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminRouteUI {
    private static final AdminRouteUI adminRouteUI = new AdminRouteUI();
    private static final RouteService routeService = RouteService.getInstance();
    private static StationService stationService = StationService.getInstance();
    private static final StationEdgeService stationEdgeService = StationEdgeService.getInstance();

    public static AdminRouteUI getInstance() {
        return adminRouteUI;
    }

    public void mainMenu() {
        boolean isExited = true;
        while (isExited) {
            System.out.println("""
                    1. Create route
                    2. All routes
                    3. Delete route
                    0. Exit
                    >>>\s""");
            int index = Main.scannerInt.nextInt();
            switch (index) {
                case 0 -> isExited = false;
                case 1 -> createRoute();
                case 2 -> allRoutes();
                default -> {
                    System.out.println("Wrong command, please try again!");
                }
            }
        }
    }

    private void allRoutes() {
        List<Route> allRoute = routeService.getAll();
       if (allRoute.isEmpty()){
           System.out.println("Didn't created routes!");
       }else {
           for (int i=0; i<allRoute.size(); i++){
               Route route = allRoute.get(i);
               List<UUID> stationIds = route.getStationIds();
               for (int j=0; j<stationIds.size(); j++){
                   if (j==stationIds.size()-1){
                       System.out.println(stationService.findById(stationIds.get(j)).getName());
                   }else {
                       System.out.print(stationService.findById(stationIds.get(j)).getName()+"-->");
                   }
               }
               System.out.println("All distance: "+Math.round(route.getAllDistance())+" km");
           }
       }
    }

    private void createRoute() {
        List<Station> allStations = stationService.getAll();
        List<StationEdge> stationEdges = stationEdgeService.getStationEdges();
        double allDistance = 0;

        Route route = new Route();
        route.setId(UUID.randomUUID());
        int count_1 = 1;
        int count_2 = 1;
        System.out.println("Choose origin station: ");
        System.out.println("-------------------------------------------------");
        for (Station station : allStations) {
            System.out.println(count_1 + ". Station name: " + station.getName() + "\nLocation: " + station.getStationLocation());
            System.out.println("-------------------------------------------------");
            count_1++;
        }
        int origin = Main.scannerInt.nextInt();
        if (origin > 0 && origin <= allStations.size()) {
            route.setOriginStation(allStations.get(origin - 1).getId());
        } else {
            System.out.println("Wrong command, please try again!");
            mainMenu();
        }

        System.out.println("Choose destination station: ");
        System.out.println("-------------------------------------------------");
        for (Station station : allStations) {
            if (count_2 != origin) {
                System.out.println(count_2 + ". Station name: " + station.getName() + "\nLocation: " + station.getStationLocation());
                System.out.println("-------------------------------------------------");
            }
            count_2++;
        }
        int destination = Main.scannerInt.nextInt();
        if (destination > 0 && destination <= allStations.size()) {
            route.setDestination(allStations.get(destination - 1).getId());
        } else {
            System.out.println("Wrong command, please try again!");
            mainMenu();
        }
        List<UUID> betweenStations = findStationsFromBetween(allStations.get(origin - 1), allStations.get(destination - 1));

        route.setStationIds(betweenStations);
        for (int z = 0; z < betweenStations.size() - 1; z++) {
            for (StationEdge stationEdge : stationEdges) {
                if (betweenStations.get(z).equals(stationEdge.getLeftStation().getId())
                        && betweenStations.get(z+1).equals(stationEdge.getRightStation().getId())) {
                    allDistance += stationEdge.getDistance();
                } else if (betweenStations.get(z).equals(stationEdge.getRightStation().getId())
                        && betweenStations.get(z+1).equals(stationEdge.getLeftStation().getId())) {
                    allDistance += stationEdge.getDistance();
                }
            }
        }
        System.out.println("Successfully created route!");
        route.setAllDistance(allDistance);
        routeService.add(route);
    }

    private List<UUID> findStationsFromBetween(Station originStation, Station destinationStation) {
        List<Station> stationList = stationService.getStationList();
        List<UUID> betweenStations = new ArrayList<>();
        int originIndex = 0;
        int destinationIndex = 0;
        for (int i = 0; i < stationList.size(); i++) {
            if (stationList.get(i).getStationLocation().equals(originStation.getStationLocation())) {
                originIndex = i;
            }
            if (stationList.get(i).getStationLocation().equals(destinationStation.getStationLocation())) {
                destinationIndex = i;
            }
        }
        if (originIndex > destinationIndex) {
            for (int j = originIndex; j >= destinationIndex; j--) {
                betweenStations.add(stationList.get(j).getId());
            }
        }

        if (originIndex < destinationIndex) {
            for (int j = originIndex; j <= destinationIndex; j++) {
                betweenStations.add(stationList.get(j).getId());
            }
        }


        return betweenStations;
    }
}
