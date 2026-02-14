import components.Department;
import components.Employee;

public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new Employee("Alice", 50000);
        Employee emp2 = new Employee("Bob", 60000);
        Employee emp3 = new Employee("Charlie", 70000);

        // Create departments
        Department hrDepartment = new Department("HR");
        hrDepartment.addEmployee(emp1);

        Department itDepartment = new Department("IT");
        itDepartment.addEmployee(emp2);
        itDepartment.addEmployee(emp3);

        // Create a top-level department
        Department mainDepartment = new Department("Head Office");
        mainDepartment.addEmployee(hrDepartment);
        mainDepartment.addEmployee(itDepartment);

        // Print total salary
        System.out.println("Total Salary: " + mainDepartment.getTotalSalary());

        // Print organizational structure in XML
        StringBuilder builder = new StringBuilder();
        mainDepartment.printXML(builder, 0);

        try (java.io.FileWriter fileWriter = new java.io.FileWriter("organization_structure.xml")) {
            fileWriter.write(builder.toString());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
    }
}