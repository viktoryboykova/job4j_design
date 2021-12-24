package ru.job4j.ood.lsp;

import java.util.List;

public class ParkingMenu implements Parking {

    private int carPlaces;
    private int truckPlaces;
    private List<Vehicle> cars;
    private List<Vehicle> trucks;

    public ParkingMenu(int carPlaces, int truckPlaces, List<Vehicle> cars, List<Vehicle> trucks) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
        this.cars = cars;
        this.trucks = trucks;
    }

    public int getCarPlaces() {
        return carPlaces;
    }

    public int getTruckPlaces() {
        return truckPlaces;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        if (vehicle.getSize() == 1) {
            cars.add(vehicle);
            carPlaces -= 1;
        } else if (vehicle.getSize() > 1 && truckPlaces != 0) {
            trucks.add(vehicle);
            truckPlaces -= 1;
        } else {
            trucks.add(vehicle);
            carPlaces -= vehicle.getSize();
        }
        return result;
    }

}
