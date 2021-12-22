package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {

    private Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> sortedEmployees = store.findBy(filter).stream().sorted((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary())).toList();
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : sortedEmployees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
