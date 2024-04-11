package DesignPrinciples.ProgramToAnInterface.src;

import java.util.Arrays;
import java.util.List;

// BEFORE: Programming to an implementation
/*
class Company {
    Designer designer = new Designer();
    Programmer programmer = new Programmer();
    Tester tester = new Tester();

    void doWork() {
        designer.design();
        programmer.program();
        tester.test();
    }
}

class Designer {
    void design() {
        // Implementation
    }
}

class Programmer {
    void program() {
        // Implementation
    }
}

class Tester {
    void test() {
        // Implementation
    }
}
*/

// AFTER: Programming to an interface
interface Employee {
    void doWork();
}

class Designer implements Employee {
    public void doWork() {
        System.out.println("Designing...");
    }
}

class Programmer implements Employee {
    public void doWork() {
        System.out.println("Programming...");
    }
}

class Tester implements Employee {
    public void doWork() {
        System.out.println("Testing...");
    }
}

/*class Company {
    List<Employee> employees = Arrays.asList(new Designer(), new Programmer(), new Tester());

    void doWork() {
        for (Employee employee : employees) {
            employee.doWork();
        }
    }

    void createSoftware() {
        System.out.println("Starting software creation process...");
        doWork();
        System.out.println("Software creation process completed.");
    }
}*/

abstract class Company {
    List<Employee> employees;

    abstract List<Employee> getEmployees();

    void doWork() {
        employees = getEmployees();
        for (Employee employee : employees) {
            employee.doWork();
        }
    }

    void createSoftware() {
        System.out.println("Starting software creation process...");
        doWork();
        System.out.println("Software creation process completed.");
    }
}

class GameDevCompany extends Company {
    List<Employee> getEmployees() {
        return Arrays.asList(new Designer(), new Programmer());
    }
}

class OutsourcingCompany extends Company {
    List<Employee> getEmployees() {
        return Arrays.asList(new Tester(), new Programmer());
    }
}

public class Main {
    public static void main(String[] args) {
        Company gameDevCompany = new GameDevCompany();
        gameDevCompany.createSoftware();

        Company outsourcingCompany = new OutsourcingCompany();
        outsourcingCompany.createSoftware();
    }
}