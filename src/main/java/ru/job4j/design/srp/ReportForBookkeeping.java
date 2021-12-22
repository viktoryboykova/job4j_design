package ru.job4j.design.srp;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class ReportForBookkeeping implements Report {

    private Store store;

    public ReportForBookkeeping(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(new BigDecimal(employee.getSalary()).multiply(new BigDecimal(100)).intValue()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
