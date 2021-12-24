package ru.job4j.ood.lsp;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingMenuTest {

    @Test
    public void whenParkingCar() {
        ParkingMenu parkingMenu = new ParkingMenu(10, 10, new ArrayList<>(), new ArrayList<>());
        Vehicle car = new Car("легковая машина");
        parkingMenu.park(car);
        assertThat(parkingMenu.getCarPlaces(), is(9));
    }

    @Test
    public void whenParkingTruck() {
        ParkingMenu parkingMenu = new ParkingMenu(10, 10, new ArrayList<>(), new ArrayList<>());
        Vehicle truck1 = new Truck("грузовик_1", 3);
        Vehicle truck2 = new Truck("грузовик_2", 3);
        parkingMenu.park(truck1);
        parkingMenu.park(truck2);
        assertThat(parkingMenu.getTruckPlaces(), is(8));
    }

    @Test
    public void whenParkingTruckOnCarPlace() {
        ParkingMenu parkingMenu = new ParkingMenu(5, 2, new ArrayList<>(), new ArrayList<>());
        Vehicle truck1 = new Truck("грузовик_1", 3);
        Vehicle truck2 = new Truck("грузовик_2", 3);
        Vehicle truck3 = new Truck("грузовик_3", 3);
        parkingMenu.park(truck1);
        parkingMenu.park(truck2);
        parkingMenu.park(truck3);
        assertThat(parkingMenu.getTruckPlaces(), is(0));
        assertThat(parkingMenu.getCarPlaces(), is(2));
    }

}