package railWays.ticket.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import railWays.common.repository.BaseRepository;
import railWays.ticket.entity.Ticket;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketRepository extends BaseRepository<UUID, Ticket> {
    private static final TicketRepository ticketRepository = new TicketRepository();

    public static TicketRepository getInstance(){
        return ticketRepository;
    }
}
