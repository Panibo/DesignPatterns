package components;

public interface OrganizationComponent {
    void printXML(StringBuilder builder, int indentLevel);

    double getTotalSalary();
}
