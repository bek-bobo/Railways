package railWays.schedule.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.schedule.entity.Schedule;
import railWays.schedule.repository.ScheduleRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScheduleService implements Service<Schedule, UUID> {
    private static final ScheduleService scheduleService = new ScheduleService();
    private final ScheduleRepository scheduleRepository = ScheduleRepository.getInstance();
    @Override
    public Schedule findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Schedule> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Schedule add(Schedule schedule) {
        return null;
    }

    public static ScheduleService getInstance(){
        return scheduleService;
    }
}
