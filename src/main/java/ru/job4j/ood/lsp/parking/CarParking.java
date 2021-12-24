package ru.job4j.ood.lsp.parking;

import java.util.List;

public class CarParking implements Parking {

    private int carPlaces;
    private List<Vehicle> cars;

    public CarParking(int carPlaces, List<Vehicle> cars) {
        this.carPlaces = carPlaces;
        this.cars = cars;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        if (carPlaces != 0) {
            System.out.println("Мест для легковых машин до парковки: " + carPlaces);
            cars.add(vehicle);
            System.out.println(vehicle.getName() + " добавлен(а) на парковку легковых машин");
            result = true;
            carPlaces -= vehicle.getSize();
            System.out.println("Мест для легковых машин после парковки: " + carPlaces);
        } else {
            System.out.println("Места для легковых машин закончились");
        }
        return result;
    }
}
