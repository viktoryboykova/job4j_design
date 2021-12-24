package ru.job4j.ood.lsp.parking;

import java.util.List;

public class TruckParking implements Parking {

    private int truckPlaces;
    private List<Vehicle> trucks;

    public TruckParking(int truckPlaces, List<Vehicle> trucks) {
        this.truckPlaces = truckPlaces;
        this.trucks = trucks;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        if (vehicle.getSize() > 1 && truckPlaces != 0) {
            System.out.println("Мест для грузовых машин до парковки: " + truckPlaces);
            trucks.add(vehicle);
            System.out.println(vehicle.getName() + " добавлен(а) на парковку грузовых машин");
            result = true;
            truckPlaces -= 1;
            System.out.println("Мест для грузовых машин после парковки: " + truckPlaces);
        } else if (truckPlaces == 0) {
            System.out.println("Места для грузовых машин закончились");
        }
        return result;
    }
}
