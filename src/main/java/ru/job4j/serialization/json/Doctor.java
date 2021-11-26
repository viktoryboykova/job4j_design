package ru.job4j.serialization.json;

import javax.print.Doc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "doctor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Doctor {

    @XmlAttribute
    private boolean paid;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;
    private Specialization specialization;

    @XmlElementWrapper(name = "patients")
    @XmlElement(name = "patient")
    private String[] patients;

    public Doctor() {
    }

    public Doctor(boolean paid, int age, String name, Specialization specialization, String[] patients) {
        this.paid = paid;
        this.age = age;
        this.name = name;
        this.specialization = specialization;
        this.patients = patients;
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

    public static void main(String[] args) throws JAXBException {

        final Doctor doctor = new Doctor(false, 28, "John", new Specialization("Surgeon"),
                new String[] {"Anna", "Helen", "Max"});

        JAXBContext context = JAXBContext.newInstance(Doctor.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(doctor, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
