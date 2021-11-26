package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "specialization")
public class Specialization {

    @XmlAttribute
    private String speciality;

    public Specialization() {
    }

    public Specialization(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Specialization{"
                + "speciality='" + speciality + '\''
                + '}';
    }
}
