package railWays.order.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.order.entity.Order;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRepository extends BaseRepository<UUID, Order> {
    private static final OrderRepository orderRepository = new OrderRepository();

    public static OrderRepository getInstance(){
        return orderRepository;
    }
}
