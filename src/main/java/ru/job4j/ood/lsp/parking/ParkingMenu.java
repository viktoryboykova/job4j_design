package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingMenu {

    private List<Parking> parkings;

    public ParkingMenu(List<Parking> parkings) {
        this.parkings = parkings;
    }

    public void park(Vehicle vehicle) {
        for (Parking parking : parkings) {
            if (parking.park(vehicle)) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        Parking car = new CarParking(10, new ArrayList<>());
        Parking truck = new TruckParking(2, new ArrayList<>());
        ParkingMenu parkingMenu = new ParkingMenu(List.of(truck, car));
        Vehicle car1 = new Car("car_1");
        Vehicle car2 = new Car("car_2");
        Vehicle truck1 = new Truck("truck_1", 3);
        Vehicle truck2 = new Truck("truck_2", 3);
        Vehicle truck3 = new Truck("truck_3", 3);
        System.out.println("Парковка 1");
        parkingMenu.park(car1);
        System.out.println("\n" + "Парковка 2");
        parkingMenu.park(car2);
        System.out.println("\n" + "Парковка 3");
        parkingMenu.park(truck1);
        System.out.println("\n" + "Парковка 4");
        parkingMenu.park(truck2);
        System.out.println("\n" + "Парковка 5");
        parkingMenu.park(truck3);
    }
}
