package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DoctorJSONObject {
    public static void main(String[] args) {
        JSONObject jsonSpecialization = new JSONObject("{\"speciality\":\"Surgeon\"}");
        List<String> list = new ArrayList<>();
        list.add("Anna");
        list.add("Helen");
        list.add("Max");
        JSONArray jsonPatients = new JSONArray(list);
        Doctor doctor = new Doctor(false, 28, "John", new Specialization("Surgeon"),
                new String[] {"Anna", "Helen", "Max"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("paid", doctor.isPaid());
        jsonObject.put("age", doctor.getAge());
        jsonObject.put("name", doctor.getName());
        jsonObject.put("specializatoin", jsonSpecialization);
        jsonObject.put("patients", jsonPatients);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(doctor));
    }
}
