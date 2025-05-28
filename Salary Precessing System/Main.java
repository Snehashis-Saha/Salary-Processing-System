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

//  Engineer Class
class Engineer extends Employee {
    protected double basicSalary = 50000;
    protected double hra, da, ta, pf, tax, netSalary;

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void processSalary() {
        System.out.println("\n" + name + ": Process Salary for Engineer");

        hra = 0.20 * basicSalary;
        da = 0.10 * basicSalary;
        ta = 0.05 * basicSalary;
        pf = 0.12 * basicSalary;
        tax = 0.05 * basicSalary;

        netSalary = basicSalary + hra + da + ta - pf - tax;

        display();
    }

    public void display() {
        System.out.println("Basic Salary: ₹" + String.format("%.2f", basicSalary));
        System.out.println("HRA (20%): ₹" + String.format("%.2f", hra));
        System.out.println("DA (10%): ₹" + String.format("%.2f", da));
        System.out.println("TA (5%): ₹" + String.format("%.2f", ta));
        System.out.println("PF Deduction (12%): ₹" + String.format("%.2f", pf));
        System.out.println("Tax Deduction (5%): ₹" + String.format("%.2f", tax));
        System.out.println("Net Salary: ₹" + String.format("%.2f", netSalary));
    }

}

//  Manager Class
class Manager extends Engineer {
    public Manager(String name) {
        super(name);
        this.basicSalary = 70000; // Manager gets more
    }

    @Override
    public void processSalary() {
        System.out.println("\n" + name + ": Process Salary for Manager");

        hra = 0.25 * basicSalary;
        da = 0.15 * basicSalary;
        ta = 0.07 * basicSalary;
        pf = 0.12 * basicSalary;
        tax = 0.10 * basicSalary;

        netSalary = basicSalary + hra + da + ta - pf - tax;

        display();
    }
}

//  Director Class
class Director extends Manager {
    public Director(String name) {
        super(name);
        this.basicSalary = 100000; // Director gets highest fixed salary
    }

    @Override
    public void processSalary() {
        System.out.println("\n" + name + ": Process Salary for Director");

        hra = 0.30 * basicSalary;
        da = 0.20 * basicSalary;
        ta = 0.10 * basicSalary;
        pf = 0.12 * basicSalary;
        tax = 0.15 * basicSalary;

        netSalary = basicSalary + hra + da + ta - pf - tax;

        display();
    }
}

//  Sales Executive Class
class SalesExecutive extends Employee {
    private double basicSalary = 40000;
    private double salesAmount = 300000; // tu chaahe toh yeh constructor se pass kara sakta hai
    private double hra, da, ta, pf, tax, commission, netSalary;

    public SalesExecutive(String name) {
        super(name);
    }

    @Override
    public void processSalary() {
        System.out.println("\n" + name + ": Process Salary for Sales Executive");

        hra = 0.15 * basicSalary;
        da = 0.10 * basicSalary;
        ta = 0.05 * basicSalary;
        commission = 0.10 * salesAmount;
        pf = 0.12 * basicSalary;
        tax = 0.05 * basicSalary;

        netSalary = basicSalary + hra + da + ta + commission - pf - tax;

        display();
    }

    public void display() {
        System.out.println("Basic Salary: ₹" + String.format("%.2f", basicSalary));
        System.out.println("HRA (15%): ₹" + String.format("%.2f", hra));
        System.out.println("DA (10%): ₹" + String.format("%.2f", da));
        System.out.println("TA (5%): ₹" + String.format("%.2f", ta));
        System.out.println("Sales Commission (10% of ₹" + String.format("%.2f", salesAmount) + "): ₹"
                + String.format("%.2f", commission));
        System.out.println("PF Deduction (12%): ₹" + String.format("%.2f", pf));
        System.out.println("Tax Deduction (5%): ₹" + String.format("%.2f", tax));
        System.out.println("Net Salary: ₹" + String.format("%.2f", netSalary));
    }

}

// Main Class
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
