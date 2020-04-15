
public class ParamTest {
    public static void main(String[] args)
    {
    /* 
    * Test 1: Mothods can not modify numeric parameters
    */
        System.out.println("Testing tripleValue");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

    /* 
    * Test 2: Methods can change the state of object parameters
    */
        System.out.println("\nTesting tripleSalary");
        Employee3 harry = new Employee3("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

    /* 
    * Test 3: Methods can not attach new objects to object parameters
    */
        System.out.println("\nTesting swap:");
        Employee3 a = new Employee3("Alice", 70000);
        Employee3 b = new Employee3("Bob", 60000);
        System.out.println("Before: a=" + a.getName() + "\nBefore: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName() + "\nAfter: b=" + b.getName());
        
    }

    public static void tripleValue(double x) //does not work
    {   
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    
    }

    public static void tripleSalary(Employee3 x)  //works
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employee3 x, Employee3 y)
    {
        Employee3 temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}

class Employee3
{
    private String name;
    private double salary;

    public Employee3(String n, double s)
    {
        name = n;
        salary = s;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }


}