package railWays.builder.builders;

import railWays.station.entity.Location;
import railWays.station.entity.Station;
import railWays.station.service.StationService;

import java.time.LocalDateTime;
import java.util.UUID;

public class StationBuilder extends Thread
{
    private static final StationService service = StationService.getInstance();

    private static void generateStation(){
        for(int i = 0;i < 13;i++){
            Station station = Station.builder()
                    .stationLocation(chooseLocation(OwnBuilder.random.nextInt(1,14)))
                    .created(LocalDateTime.now().minusYears(OwnBuilder.random.nextInt(1, 5)))
                    .modified(LocalDateTime.now())
                    .name(OwnBuilder.faker.address().firstName())
                    .uuid(UUID.randomUUID())
                    .build();

            service.add(station);
        }

    }

    private static Location chooseLocation(int count) {
        switch (count){
            case 1 ->{return Location.ANDIJAN;}
            case 2 ->{return Location.NAMANGAN;}
            case 3 ->{return Location.FERGANA;}
            case 4 ->{return Location.TASHKENT;}
            case 5 ->{return Location.SAMARQAND;}
            case 6 ->{return Location.BUKHARA;}
            case 7 ->{return Location.NAVOI;}
            case 8 ->{return Location.JIZZAKH;}
            case 9 ->{return Location.SURKHANDARYA;}
            case 10 ->{return Location.KASHKADARYA;}
            case 11 ->{return Location.KHORAZM;}
            case 12 ->{return Location.SIRDARYA;}
            default ->{return Location.NUKUS;}
        }
    }

    @Override
    public synchronized void start() {
        generateStation();
    }
}
