package repositories;


import model.Ticket;
import service.AuditService;
import service.FileService;

import java.util.List;
import java.util.Optional;

public class FileTicketRepository implements TicketRepository {
    private final String  filePath = "Tickets";
    @Override
    public void addTicket(Ticket t) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String ticketData = t.toString();
        auditService.writeAction("S-a adaugat un ticket in fisierul " + filePath);
        service.writeFile(filePath,ticketData);
    }

    @Override
    public Optional<Ticket> findTicketByCode(String code) {
        FileService service = FileService.getInstance();
        Ticket ticket =new Ticket();;
        try {
            List<String> ticketList = service.getFile(filePath);
            for (String u : ticketList) {
                String [] attr = u.split(",");
                if (attr[3].equals(code))  {
                    ticket.setSeat(Integer.parseInt(attr[0]));
                    ticket.setPrice(Float.parseFloat(attr[1]));
                    ticket.setVehicleNumber(Integer.parseInt(attr[2]));
                    ticket.setCode(attr[3]);
                    ticket.setDate(attr[4]);
                    break;
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.of(ticket);

    }
}
