package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

public  class Abonement
{
    public final String  number;
    public final LocalDate beginDate;         //дата начала абонемента
    public final LocalDate endDate;           //дата конца абонемента
    public final String customer;             //ФИО посетителя
    public final LocalDate birthDate;         //Дата рождения посетителя
    public final TypeAbon typeAbon;           //Тип абонемента
    private LocalTime regTime;                //Время регистрации абонемента

    public Abonement(String number,LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate, TypeAbon typeAbon)
    {
        this.number = number;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.customer = customer;
        this.birthDate = birthDate;
        this.typeAbon = typeAbon;
    }

    public void setRegTime(LocalTime regTime) {
        this.regTime = regTime;
    }

    public LocalTime getRegTime() {
        return regTime;
    }

    public void add(Abonement [] arr)
    {
        if(arr == null)
        {
            throw new IllegalArgumentException("Wrong point to array");
        }
        for (int i = 0; i < arr.length; i++)
        {
            if(i == arr.length - 1 && arr[i] != null)
            {
                throw new IllegalArgumentException("the area is full!");
            }
            if(arr[i] == null)
            {
                arr[i] = this;
                break;
            }
        }
    }
}
