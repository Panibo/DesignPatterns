package com.mariapori.components;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {

    private String name;
    private List<OrganizationComponent> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(OrganizationComponent employee) {
        employees.add(employee);
    }

    public void removeEmployee(OrganizationComponent employee) {
        employees.remove(employee);
    }

    @Override
    public void printXML(StringBuilder builder, int indentLevel) {
        String indent = "    ".repeat(indentLevel);
        builder.append(indent).append("<Department name=\"").append(name).append("\">\n");
        for (OrganizationComponent employee : employees) {
            employee.printXML(builder, indentLevel + 1);
        }
        builder.append(indent).append("</Department>\n");
    }

    @Override
    public double getTotalSalary() {
        double total = 0;
        for (OrganizationComponent employee : employees) {
            total += employee.getTotalSalary();
        }
        return total;
    }

}
