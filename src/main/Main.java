package main;


import gui.EmployeesFrame;
import gui.MainMenuFrame;
import gui.TicketFrame;
import model.*;
import repositories.*;
import service.EmployeeSalaryService;
import service.RouteDistanceService;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*//Employees Service
        MapEmployeeRepository mapEmployeeRepository = new MapEmployeeRepository();
        Employee e1 = new Employee();
        e1.setId(0);
        e1.setName("AAA");
        e1.setSalary(10000);
        Employee e2 = new Driver("B",10);
        e2.setId(1);
        e2.setName("BBB");
        e2.setSalary(8000);
        Employee e3 = new Pilot(20,10,200);
        e3.setId(2);
        e3.setName("CCC");
        e3.setSalary(20000);
        mapEmployeeRepository.AddEmployee(e1);
        mapEmployeeRepository.AddEmployee(e2);
        mapEmployeeRepository.AddEmployee(e3);
        EmployeeSalaryService employeeSalaryService = new EmployeeSalaryService(mapEmployeeRepository);
        employeeSalaryService.GetAllEmployeesSortedBySalary();
        //Route Service
        MapRouteRepository mapRouteRepository = new MapRouteRepository();
        City TarguJiu = new City();
        TarguJiu.setName("Targu Jiu");
        TarguJiu.setLatitude(45.050f);
        TarguJiu.setLongitude(23.28330f);
        City Bucuresti = new City();
        Bucuresti.setName("Bucuresti");
        Bucuresti.setLatitude(44.4396630f);
        Bucuresti.setLongitude(26.0963060f);
        City Constanta = new City();
        Constanta.setName("Constanta");
        Constanta.setLatitude(44.180f);
        Constanta.setLongitude(28.630f);
        List<City> list1 = new ArrayList<>();
        list1.add(TarguJiu);
        list1.add(Bucuresti);
        list1.add(Constanta);
        List<City> list2 = new ArrayList<>();
        list2.add(TarguJiu);
        list2.add(Bucuresti);
        Route r1 = new Route();
        r1.setCities(list1);
        r1.setName("Targu Jiu - Bucuresti - Constanta");
        r1.setId(0);
        r1.setDate("19-12-2020");
        Route r2 = new Route();
        r2.setCities(list2);
        r2.setName("Targu Jiu - Bucuresti");
        r2.setId(1);
        r2.setDate("20-7-2021");
        /*
        mapRouteRepository.addRoute(r1);
        mapRouteRepository.addRoute(r2);
        RouteDistanceService  routeDistanceService = new RouteDistanceService(mapRouteRepository);
        System.out.print(routeDistanceService.Distance(0));
        System.out.print("\n");
        System.out.print(routeDistanceService.Distance(1));*/
        //Part2
        /*EmployeeRepository employeeRepository = EmployeeRepository.build(EmployeeRepository.Type.FILE);
        employeeRepository.AddEmployee(e1);
        employeeRepository.AddEmployee(e2);
      /*  System.out.print("\n");
        System.out.print(employeeRepository.GetEmployeeById(1));
        System.out.print("\n");
        System.out.print(employeeRepository.getEmployees());*/
      /*  RouteRepository routeRepository = RouteRepository.build(RouteRepository.Type.FILE);
        routeRepository.addRoute(r1);
        routeRepository.addRoute(r2);
        Route r3 = routeRepository.findRouteById(0);
        System.out.print(r3.toString());
        TicketRepository ticketRepository = TicketRepository.build(TicketRepository.Type.FILE);
        Ticket ticket = new Ticket();
        ticket.setCode("0");
        ticket.setVehicleNumber(1234);
        ticket.setPrice(100);
        ticket.setSeat(5);
        ticket.setDate("20");
        ticketRepository.addTicket(ticket);
        Optional<Ticket> t1 =ticketRepository.findTicketByCode("0");
        System.out.print("\n");
        System.out.print(t1.get().toString());
        VehicleRepository vehicleRepository = VehicleRepository.build(VehicleRepository.Type.FILE);
        Vehicle v1 =new Vehicle();
        v1.setSeats(10);
        v1.setFuelConsumption(11.0f);
        v1.setNumber(0);
        Vehicle v2 = new Plane(10,2,3);
        v2.setSeats(100);
        v2.setFuelConsumption(100.0f);
        v2.setNumber(100);
        Vehicle v3 = new Car("GJ:27:PLM");
        v3.setNumber(2);
        v3.setFuelConsumption(10.0f);
        v3.setSeats(15);
        vehicleRepository.addVehicle(v1);
        vehicleRepository.addVehicle(v2);
        vehicleRepository.addVehicle(v3);
        Optional<Vehicle> v4 = vehicleRepository.findVehicleByNumber(2);
        System.out.print("\n");
        System.out.print(v4.get().toString());
        //Part3
        EmployeeRepository dbEmployeeRep = new DBEmployeeRepository();
        dbEmployeeRep.AddEmployee(e1);
        dbEmployeeRep.AddEmployee(e2);
        dbEmployeeRep.AddEmployee(e3);
        Employee e4 = dbEmployeeRep.GetEmployeeById(30);
        Map<Integer, Employee> mp = new HashMap<>();
        mp = dbEmployeeRep.getEmployees();
        VehicleRepository dbVehicleRep = VehicleRepository.build(VehicleRepository.Type.DB);
        dbVehicleRep.addVehicle(v1);
        dbVehicleRep.addVehicle(v2);
        Optional<Vehicle> veh = dbVehicleRep.findVehicleByNumber(2);
        RouteRepository dbRouteRep = RouteRepository.build(RouteRepository.Type.DB);
        dbRouteRep.addRoute(r1);
        dbRouteRep.addRoute(r2);
        dbRouteRep.addRoute(r3);
        Route r4 = dbRouteRep.findRouteById(14);
        System.out.print("\n");
        System.out.print(r4.toString());
        TicketRepository dbTicketRep = TicketRepository.build(TicketRepository.Type.DB);
        dbTicketRep.addTicket(ticket);
        Optional<Ticket> tik = dbTicketRep.findTicketByCode("0");
        System.out.print("\n");
        System.out.print(tik.get().toString());
        */
        new MainMenuFrame();

    }

}
