package railWays.station.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.station.entity.Station;
import railWays.station.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static railWays.station.entity.Location.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationService implements Service<Station, UUID> {
    private static final StationService stationService = new StationService();
    private static final StationRepository stationRepository = StationRepository.getInstance();
    public static List<Station> stationList = new ArrayList<>();


    static {
        Station stationFergana = new Station();
        stationFergana.setId(UUID.randomUUID());
        stationFergana.setStationLocation(FERGANA);
        stationFergana.setName("Farg'ona Janubiy Vogzali");

        Station stationNamangan = new Station();
        stationNamangan.setId(UUID.randomUUID());
        stationNamangan.setStationLocation(NAMANGAN);
        stationNamangan.setName("Namangan Shahar Vogzali");

        Station stationAndijan = new Station();
        stationAndijan.setId(UUID.randomUUID());
        stationAndijan.setStationLocation(ANDIJAN);
        stationAndijan.setName("Andijon Shahar Vogzali");

        Station stationToshkent = new Station();
        stationToshkent.setId(UUID.randomUUID());
        stationToshkent.setStationLocation(TASHKENT);
        stationToshkent.setName("Toshkent Shahar Vogzali");

        Station stationSamarkand = new Station();
        stationSamarkand.setId(UUID.randomUUID());
        stationSamarkand.setStationLocation(SAMARQAND);
        stationSamarkand.setName("Samarqand Shahar Vogzali");

        Station stationNavoi = new Station();
        stationNavoi.setId(UUID.randomUUID());
        stationNavoi.setStationLocation(NAVOI);
        stationNavoi.setName("Navoi Shahar Vogzali");

        Station stationBuhkara = new Station();
        stationBuhkara.setId(UUID.randomUUID());
        stationBuhkara.setStationLocation(BUKHARA);
        stationBuhkara.setName("Buxoro Shahar Vogzali");

        Station stationJizzakh = new Station();
        stationJizzakh.setId(UUID.randomUUID());
        stationJizzakh.setStationLocation(JIZZAKH);
        stationJizzakh.setName("Jizzax Shahar Vogzali");

        Station stationQashkadarya = new Station();
        stationQashkadarya.setId(UUID.randomUUID());
        stationQashkadarya.setStationLocation(KASHKADARYA);
        stationQashkadarya.setName("Qashqadarya Shahar Vogzali");

        Station stationSurkhandarya = new Station();
        stationSurkhandarya.setId(UUID.randomUUID());
        stationSurkhandarya.setStationLocation(SURKHANDARYA);
        stationSurkhandarya.setName("Surxondaryo Shahar Vogzali");

        Station stationNukus = new Station();
        stationNukus.setId(UUID.randomUUID());
        stationNukus.setStationLocation(NUKUS);
        stationNukus.setName("Nukus Shahar Vogzali");

        Station stationSirdarya = new Station();
        stationSirdarya.setId(UUID.randomUUID());
        stationSirdarya.setStationLocation(SIRDARYA);
        stationSirdarya.setName("Sirdaryo Shahar Vogzali");

        Station stationKhorazm = new Station();
        stationKhorazm.setId(UUID.randomUUID());
        stationKhorazm.setStationLocation(KHORAZM);
        stationKhorazm.setName("Xorazim Shahar Vogzali");


        stationRepository.add(stationFergana);
        stationRepository.add(stationNamangan);
        stationRepository.add(stationAndijan);
        stationRepository.add(stationToshkent);
        stationRepository.add(stationSamarkand);
        stationRepository.add(stationSirdarya);
        stationRepository.add(stationBuhkara);
        stationRepository.add(stationNavoi);
        stationRepository.add(stationQashkadarya);
        stationRepository.add(stationSurkhandarya);
        stationRepository.add(stationNukus);
        stationRepository.add(stationKhorazm);
        stationRepository.add(stationJizzakh);

        stationList = List.of(
                stationAndijan,
                stationFergana,
                stationNamangan,
                stationToshkent,
                stationSirdarya,
                stationSamarkand,
                stationBuhkara,
                stationJizzakh,
                stationNavoi,
                stationSurkhandarya,
                stationQashkadarya,
                stationKhorazm,
                stationNukus
        );
    }

    @Override
    public Station findById(UUID uuid) {
        return stationRepository.findById(uuid);
    }

    @Override
    public List<Station> getAll() {
        return stationRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Station add(Station station) {
        return null;
    }

    public List<Station> getStationList(){
        return stationList;
    }

    public static StationService getInstance() {
        return stationService;
    }
}
