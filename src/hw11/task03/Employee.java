package hw11.task03;

import java.util.*;

public class Employee implements Comparable<Employee>
{
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name,String company,int salary, int age)
    {
        if(salary == 0 || age == 0)
        {
            System.out.println("Salary or age == 0");
            throw new IllegalArgumentException("Salary or age == 0");
        }
        if(company == null || name == null)
        {
            System.out.println("Name or Company == null");
            throw new IllegalArgumentException("Name or Company == null");
        }
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee)o;
        if(!this.name.equals(employee.name)) return false;
        if(this.salary != employee.salary) return false;
        if(this.age != employee.age) return false;
        return this.company.equals(employee.company);
    }
    @Override
    public int hashCode()
    {
       return 13 * age + 17 * salary + name.hashCode() + company.hashCode();
    }
    @Override
    public String toString()
    {
        return "Employee{" +
                "name=" + name +
                ", salary=" + salary +
                ", age=" + age +
                ", company=" + company +
                '}';
    }
    public int compareTo(Employee a)
    {
        if(this.name.compareTo(a.name)<0) return -1;
        else if(this.name.compareTo(a.name)>0) return 1;
        else if(this.salary < a.salary) return -1;
        else if(this.salary > a.salary) return 1;
        else if(this.age < a.age) return -1;
        else if(this.age > a.age) return 1;
        else if(this.company.compareTo(a.company)<0) return -1;
        else if(this.company.compareTo(a.company)>0) return 1;
        return 0;
    }

// TODO: добавить необходимые конструкторы, геттеры, сеттеры и другие методы


    // TODO: дописать реализацию метода для создания списка объектов класса Employee.
    //  Объекты Employee создавать со случайными значениями:
    //  возраст от 21 до 60;
    //  диапазон ЗП на Ваш выбор.
    //  name - случайное значения из массива names
    //  company - случайное значения из массива companies
    public static List<Employee> employeeGenerator(int num) { //  num - количество объектов в списке
        if (num <= 0) {
            return Collections.emptyList();
        }
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний


        Random random = new Random();
        ArrayList<Employee> employees = new ArrayList<>();

        // создание объектов, наполнение списка
        for (int i = 0; i < num; i++)
        {
            Employee employee = new Employee(names[(int)random.nextInt(names.length)], companies[(int)random.nextInt(companies.length)],
                                       100000 + random.nextInt(100000+1), 21 + random.nextInt(60+1));
            employees.add(employee);
        }

        return employees;
    }
}