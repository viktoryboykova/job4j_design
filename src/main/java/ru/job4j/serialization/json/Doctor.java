package ru.job4j.serialization.json;

import java.util.Arrays;

public class Doctor {

    private final boolean paid;
    private final int age;
    private final String name;
    private final Specialization specialization;
    private final String[] patients;

    public Doctor(boolean paid, int age, String name, Specialization specialization, String[] patients) {
        this.paid = paid;
        this.age = age;
        this.name = name;
        this.specialization = specialization;
        this.patients = patients;
    }

    public boolean isPaid() {
        return paid;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public String[] getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "Doctor{"
                + "paid=" + paid
                + ", age=" + age
                + ", name='" + name + '\''
                + ", specializatoin=" + specialization
                + ", patients=" + Arrays.toString(patients)
                + '}';
    }
}
