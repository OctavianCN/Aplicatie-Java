package repositories;

import exceptions.InexistentRouteIdException;
import model.Ticket;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapTicketRepository implements TicketRepository{

    private Map<String, Ticket> tickets;

    public MapTicketRepository(){

        tickets = new HashMap<>();
    }
    public void addTicket(Ticket t){
        tickets.put(t.getCode(),t);
    }

    public Optional<Ticket> findTicketByCode(String code){

        Ticket ticket = null;

        try{
            if(tickets.get(code).equals(null)){
                throw new InexistentRouteIdException();
            }
            ticket = tickets.get(code);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.ofNullable(ticket);
    }

}
