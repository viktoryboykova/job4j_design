package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForProgrammers() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForProgrammers(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>").append(System.lineSeparator());
        expect.append("<html>").append(System.lineSeparator());
        expect.append("<head>").append(System.lineSeparator());
        expect.append("<title>").append("Отчет для отдела программистов в формате HTML").append("</title>").append(System.lineSeparator());
        expect.append("</head>").append(System.lineSeparator());
        expect.append("<body>").append(System.lineSeparator());
        expect.append("<table>").append(System.lineSeparator());
        expect.append("<th>").append(System.lineSeparator());
        expect.append("<td>").append("name").append("</td>").append(System.lineSeparator());
        expect.append("<td>").append("hired").append("</td>").append(System.lineSeparator());
        expect.append("<td>").append("fired").append("</td>").append(System.lineSeparator());
        expect.append("<td>").append("salary").append("</td>").append(System.lineSeparator());
        expect.append("</th>").append(System.lineSeparator());
        expect.append("<tr>").append(System.lineSeparator());
        expect.append("<td>").append(worker.getName()).append("</td>").append(System.lineSeparator());
        expect.append("<td>").append(worker.getHired()).append("</td>").append(System.lineSeparator());
        expect.append("<td>").append(worker.getFired()).append("</td>").append(System.lineSeparator());
        expect.append("<td>").append(worker.getSalary()).append("</td>").append(System.lineSeparator());
        expect.append("</tr>").append(System.lineSeparator());
        expect.append("</table>").append(System.lineSeparator()).append("</body>").append(System.lineSeparator());
        expect.append("</html>").append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForBookkeeping() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForBookkeeping(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(10000).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForHR() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Egor", now, now, 360);
        Employee worker3 = new Employee("Alex", now, now, 90);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedJSON() throws JAXBException {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.DECEMBER, 23, 0, 0, 0);
        Employee emp1 = new Employee("abc", calendar, calendar, 200);
        Employee emp2 = new Employee("def", calendar, calendar, 1500);
        store.add(emp1);
        store.add(emp2);
        Report engine = new ReportJSON(store);
        String expected =
                "{"
                        + "\"name\":\"abc\","
                        + "\"hired\":"
                        + "{"
                        + "\"year\":2021,"
                        + "\"month\":11,"
                        + "\"dayOfMonth\":23,"
                        + "\"hourOfDay\":0,"
                        + "\"minute\":0,"
                        + "\"second\":0"
                        + "},"
                        + "\"fired\":"
                        + "{"
                        + "\"year\":2021,"
                        + "\"month\":11,"
                        + "\"dayOfMonth\":23,"
                        + "\"hourOfDay\":0,"
                        + "\"minute\":0,"
                        + "\"second\":0"
                        + "},"
                        + "\"salary\":200.0"
                        + "}"
                        + System.lineSeparator()
                        + "{"
                        + "\"name\":\"def\","
                        + "\"hired\":"
                        + "{"
                        + "\"year\":2021,"
                        + "\"month\":11,"
                        + "\"dayOfMonth\":23,"
                        + "\"hourOfDay\":0,"
                        + "\"minute\":0,"
                        + "\"second\":0"
                        + "},"
                        + "\"fired\":"
                        + "{"
                        + "\"year\":2021,"
                        + "\"month\":11,"
                        + "\"dayOfMonth\":23,"
                        + "\"hourOfDay\":0,"
                        + "\"minute\":0,"
                        + "\"second\":0"
                        + "},"
                        + "\"salary\":1500.0"
                        + "}"
                        + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expected));
    }
}