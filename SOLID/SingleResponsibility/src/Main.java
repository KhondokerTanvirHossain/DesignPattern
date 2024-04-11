package SOLID.SingleResponsibility.src;

/*class Employee {
    String name;
    String position;
    // Other employee data...

    // Methods for managing employee data...
    void printReport() {
        // Code for formatting and printing the timesheet report...
        System.out.println("Printing timesheet report for " + employee.getName());
    }
}
*/

class Employee {
    String name;
    String position;
    // Other employee data...

    // Methods for managing employee data...
}

class TimesheetReport {
    Employee employee;

    TimesheetReport(Employee employee) {
        this.employee = employee;
    }

    void printReport() {
        // Code for formatting and printing the timesheet report...
        System.out.println("Printing timesheet report for " + employee.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "John Doe";
        employee.position = "Software Engineer";
        // Set other employee data...

        System.out.println("Employee created: " + employee.name);

        TimesheetReport report = new TimesheetReport(employee);
        report.printReport();
    }
}