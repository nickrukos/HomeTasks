package hw11.task03;

import java.util.*;

class EmployeeNameComparator implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        if(a.getName().compareTo(b.getName())<0) return -1;
        else if(a.getName().compareTo(b.getName())>0) return 1;
        return 0;
    }

}
class EmployeeSalaryComparator implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
         if(a.getSalary() < b.getSalary()) return -1;
         else if(a.getSalary() < b.getSalary()) return 1;
         return 0;
    }
}
class EmployeeAgeComparator implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        if(a.getAge() < b.getAge()) return -1;
        else if(a.getAge() < b.getAge()) return 1;
        return 0;
    }

}
class EmloyeeCompanyComparator implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        if(a.getCompany().compareTo(b.getCompany())<0) return -1;
        else if(a.getCompany().compareTo(b.getCompany())>0) return 1;
        return 0;
    }
}

public class Task03 {
    public static void main(String[] args) {
        // 1. Дописать класс Employee

        List<Employee> employeeList = Employee.employeeGenerator(20);
        Comparator<Employee> employeeComparator = new EmployeeNameComparator().
                                                      thenComparing(new EmployeeSalaryComparator()).
                                                      thenComparing(new EmployeeAgeComparator()).
                                                      thenComparing(new EmloyeeCompanyComparator());


        // 2. Отсортировать employeeList:
        // 2.1. по имени
        // 2.2. по имени и зп
        // 2.3. по имени, зп, возрасту, компании

        // Для сортировки используйте тип Comparator
        System.out.println("Before Sorting");
        for(Employee employee : employeeList)
        {
            System.out.println(employee.toString());
        }

        Collections.sort(employeeList,new EmployeeNameComparator());

        System.out.println("After first Sorting");
        for(Employee employee : employeeList)
        {
            System.out.println(employee.toString());
        }

        Collections.sort(employeeList,new EmployeeNameComparator().
                         thenComparing(new EmployeeSalaryComparator()));

        System.out.println("After second Sorting");
        for(Employee employee : employeeList)
        {
            System.out.println(employee.toString());
        }

        Collections.sort(employeeList,new EmployeeNameComparator().
                         thenComparing(new EmployeeSalaryComparator().
                         thenComparing(new EmloyeeCompanyComparator())));

        System.out.println("After third Sorting");
        for(Employee employee : employeeList)
        {
            System.out.println(employee.toString());
        }
    }
}
