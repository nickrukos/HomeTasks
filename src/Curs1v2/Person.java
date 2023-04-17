package Curs1v2;

import java.time.LocalDate;

public class Person
{
    public final String customer;             //ФИО посетителя
    public final LocalDate birthDate;         //Дата рождения посетителя

    public Person(String customer, LocalDate birthDate) {
        if (customer == null || birthDate == null) {
            throw new IllegalArgumentException("There is now Person!");
        }
        if(customer.length() == 0)
        {
            throw new IllegalArgumentException("Empty person!");
        }
        if(birthDate.isBefore(LocalDate.of(1930,1,1)))
        {
            throw new IllegalArgumentException("Too old Person!");
        }
        this.customer = customer;
        this.birthDate = birthDate;
    }
}
