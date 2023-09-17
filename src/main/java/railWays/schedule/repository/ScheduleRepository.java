package railWays.schedule.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.schedule.entity.Schedule;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScheduleRepository extends BaseRepository<UUID, Schedule> {
    private static final ScheduleRepository scheduleRepository = new ScheduleRepository();

    public static ScheduleRepository getInstance(){
        return scheduleRepository;
    }
}
