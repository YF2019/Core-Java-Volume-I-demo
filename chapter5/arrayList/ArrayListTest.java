package arrayList;

import java.util.ArrayList;

import abstractClasses.Employee;


/**
 * This program demonstrates the ArrayList class
 * @version 5.4.1 2020-4-18
 * @author yefan_jiang
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // fill the staff array list with three objects
        ArrayList<Employee> staff  = new ArrayList<>();
        
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        // raise everyon's salary by 5%
        for (Employee e : staff)
        {
            e.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee e : staff)
        {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() +
                ",hireDay=" + e.getHireDay());
        }
    }

}