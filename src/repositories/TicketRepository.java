package repositories;

import model.Ticket;

import java.util.Optional;

public interface TicketRepository {

    void addTicket(Ticket t);
    Optional<Ticket> findTicketByCode(String code);
    static TicketRepository build(TicketRepository.Type type) {
        switch (type) {
            case DB: return new DBTicketRepository();
            case FILE: return new FileTicketRepository();
            case ARRAY:return new MapTicketRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }
}
