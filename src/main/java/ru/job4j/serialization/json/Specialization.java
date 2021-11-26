package ru.job4j.serialization.json;

public class Specialization {

    private final String speciality;

    public Specialization(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Specialization{"
                + "speciality='" + speciality + '\''
                + '}';
    }
}
