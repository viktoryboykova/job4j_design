package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class DoctorJAXB {

    public static void main(String[] args) throws Exception {
        Doctor doctor = new Doctor(false, 28, "John", new Specialization("Surgeon"),
                new String[] {"Anna", "Helen", "Max"});
        JAXBContext context = JAXBContext.newInstance(Doctor.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(doctor, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Doctor result = (Doctor) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
