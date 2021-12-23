package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        List<Employee> employees = store.findBy(filter);
        JAXBContext context = JAXBContext.newInstance(Employee.Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employee.Employees(employees), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }

    public static void main(String[] args) throws JAXBException {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.DECEMBER, 23, 0, 0, 0);
        Employee emp1 = new Employee("abc", calendar, calendar, 200);
        Employee emp2 = new Employee("def", calendar, calendar, 1500);
        store.add(emp1);
        store.add(emp2);
        ReportXML reportXML = new ReportXML(store);
        System.out.println(reportXML.generate(em -> true));
    }
}
