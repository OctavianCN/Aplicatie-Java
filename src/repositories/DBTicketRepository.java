package repositories;

import model.Ticket;
import model.Vehicle;
import service.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBTicketRepository implements TicketRepository {
    @Override
    public void addTicket(Ticket t) {
        String sql = "INSERT INTO tickets VALUES (?,?, ?,?,?)";
        try {
            PreparedStatement statement =  DatabaseService.getStatament(sql);
            statement.setString(1,t.getCode());
            statement.setInt(2,t.getVehicleNumber());
            statement.setFloat(3,t.getPrice());
            statement.setInt(4,t.getSeat());
            statement.setString(5,t.getDate());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Optional<Ticket> findTicketByCode(String code) {
        String sql = "SELECT * FROM tickets WHERE code = ?";
        try{
            PreparedStatement statement = DatabaseService.getStatament(sql);
            statement.setString(1, code);
            ResultSet set = statement.executeQuery();
            if(set.next()){
                Ticket ticket = new Ticket();
                ticket.setCode(set.getString("code"));
                ticket.setDate(set.getString("date"));
                ticket.setSeat(set.getInt("seat"));
                ticket.setPrice(set.getFloat("price"));
                ticket.setVehicleNumber(set.getInt("vehicleNumber"));
                return Optional.of(ticket);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
