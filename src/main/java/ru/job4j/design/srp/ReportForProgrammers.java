package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportForProgrammers implements Report {

    private Store store;

    public ReportForProgrammers(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>").append(System.lineSeparator());
        text.append("<html>").append(System.lineSeparator());
        text.append("<head>").append(System.lineSeparator());
        text.append("<title>").append("Отчет для отдела программистов в формате HTML").append("</title>").append(System.lineSeparator());
        text.append("</head>").append(System.lineSeparator());
        text.append("<body>").append(System.lineSeparator());
        text.append("<table>").append(System.lineSeparator());
        text.append("<th>").append(System.lineSeparator());
        text.append("<td>").append("name").append("</td>").append(System.lineSeparator());
        text.append("<td>").append("hired").append("</td>").append(System.lineSeparator());
        text.append("<td>").append("fired").append("</td>").append(System.lineSeparator());
        text.append("<td>").append("salary").append("</td>").append(System.lineSeparator());
        text.append("</th>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>").append(System.lineSeparator());
            text.append("<td>").append(employee.getName()).append("</td>").append(System.lineSeparator());
            text.append("<td>").append(employee.getHired()).append("</td>").append(System.lineSeparator());
            text.append("<td>").append(employee.getFired()).append("</td>").append(System.lineSeparator());
            text.append("<td>").append(employee.getSalary()).append("</td>").append(System.lineSeparator());
            text.append("</tr>").append(System.lineSeparator());
        }
        text.append("</table>").append(System.lineSeparator()).append("</body>").append(System.lineSeparator());
        text.append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
