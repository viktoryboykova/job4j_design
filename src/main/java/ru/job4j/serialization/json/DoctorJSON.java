package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DoctorJSON {
    public static void main(String[] args) {
        final Doctor doctor = new Doctor(false, 28, "John", new Specialization("Surgeon"),
                new String[] {"Anna", "Helen", "Max"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(doctor));
        final String doctorJson =
                "{"
                + "\"paid\":false,"
                + "\"age\":28,"
                + "\"name\":\"John\","
                + "\"specialization\":"
                + "{"
                + "\"speciality\":\"Surgeon\""
                + "},"
                + "\"patients\":"
                + "[\"Anna\", \"Helen\", \"Max\"]"
                + "}";
        final Doctor doctorMod = gson.fromJson(doctorJson, Doctor.class);
        System.out.println(doctorMod);
    }
}
