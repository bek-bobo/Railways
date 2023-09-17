package railWays.ticket.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.service.Service;
import railWays.ticket.entity.Ticket;
import railWays.ticket.repository.TicketRepository;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketService implements Service<Ticket, UUID> {

    private static final TicketService ticketService = new TicketService();
    private final TicketRepository ticketRepository = TicketRepository.getInstance();
    @Override
    public Ticket findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Ticket add(Ticket ticket) {
        return null;
    }

    public static TicketService getInstance(){
        return ticketService;
    }
}
