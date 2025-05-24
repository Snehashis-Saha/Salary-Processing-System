import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    protected String name;
    protected List<Employee> reports = new ArrayList<>();
    static List<Employee> staffs = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
        addStaff(this);
    }

    public static void addStaff(Employee e) {
        staffs.add(e);
    }

    public abstract void processSalary();
}

class Engineer extends Employee {
    public Engineer(String name) {
        super(name);
    }

    public void processSalary() {
        System.out.println(name + ": Process Salary for Engineer");
    }
}

class Manager extends Engineer {
    public Manager(String name) {
        super(name);
    }

    public void processSalary() {
        System.out.println(name + ": Process Salary for Manager");
    }
}

class Director extends Manager {
    public Director(String name) {
        super(name);
    }

    public void processSalary() {
        System.out.println(name + ": Process Salary for Director");
    }
}

class SalesExecutive extends Employee {
    public SalesExecutive(String name) {
        super(name);
    }

    public void processSalary() {
        System.out.println(name + ": Process Salary for Sales Executive");
    }
}

public class Main {
    public static void main(String[] args) {
        Engineer e1 = new Engineer("Rohit");
        Engineer e2 = new Engineer("Kavita");
        Engineer e3 = new Engineer("Shambhu");
        Manager m1 = new Manager("Kamala");
        Manager m2 = new Manager("Rajib");
        SalesExecutive s1 = new SalesExecutive("Hari");
        SalesExecutive s2 = new SalesExecutive("Bishnu");
        Director d = new Director("Ranjana");

        for (Employee emp : Employee.staffs) {
            emp.processSalary();
        }
    }
}
