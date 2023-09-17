package railWays.order.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.order.entity.Order;
import railWays.order.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderService implements Service<Order, UUID> {

    private static final OrderService orderService = new OrderService();
    private final OrderRepository orderRepository = OrderRepository.getInstance();
    @Override
    public Order findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Order add(Order order) {
        return null;
    }

    public static OrderService getInstance(){
        return orderService;
    }
}
