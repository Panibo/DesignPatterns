package components;

public class Employee implements OrganizationComponent {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void printXML(StringBuilder builder, int indentLevel) {
        String indent = "    ".repeat(indentLevel);
        builder.append(indent).append("<Employee name=\"").append(name)
                .append("\" salary=\"").append(salary).append("\" />\n");
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

}
