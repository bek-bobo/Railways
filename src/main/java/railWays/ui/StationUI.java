package railWays.ui;

import railWays.station.entity.Station;
import railWays.user.entity.User;

public class StationUI {


    protected static void getStations(Station station) {
        System.out.printf(
                """
                        {}--------------------------{}
                          
                              Name : %s
                              Location : %s
                           
                        ------------------------------> \n""",
                station.getName(),
                station.getStationLocation()
        );
    }


}
