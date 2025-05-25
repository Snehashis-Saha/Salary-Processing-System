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
    private double basicSalary;
    private double hra, da, ta, pf, tax, netSalary;

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void processSalary() {
        System.out.println(name + ": Process Salary for Engineer");

        hra = 0.20 * basicSalary;
        da = 0.10 * basicSalary;
        ta = 0.05 * basicSalary;

        pf = 0.12 * basicSalary;
        tax = 0.05 * basicSalary;

        netSalary = basicSalary + hra + da + ta - pf - tax;

        display();
    }
    
    public void display(){
        System.out.printf("Basic Salary: ₹%.2f%n", basicSalary);
        System.out.printf("HRA (20%%): ₹%.2f%n", hra);
        System.out.printf("DA (10%%): ₹%.2f%n", da);
        System.out.printf("TA (5%%): ₹%.2f%n", ta);
        System.out.printf("PF Deduction (12%%): ₹%.2f%n", pf);
        System.out.printf("Tax Deduction (5%%): ₹%.2f%n", tax);
        System.out.printf("Net Salary: ₹%.2f%n", netSalary);
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
