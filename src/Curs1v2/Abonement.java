package Curs1v2;

import java.time.LocalDate;

public  class Abonement
{
    private LocalDate beginDate;         //дата начала абонемента
    private LocalDate endDate;           //дата конца абонемента
    private String customer;            //ФИО посетителя
    private LocalDate birthDate;     //Дата рождения посетителя
    protected Abonement(LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate)
    {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.customer = customer;
        this.birthDate = birthDate;
    }

    protected void add(Abonement [] arr, LocalDate currentDate)
    {
        if(arr == null)
        {
            throw new IllegalArgumentException("Неверная ссылка на массив");
        }
        if(currentDate == null)
        {
            throw new IllegalArgumentException("Неверная ссылка на текущую дату");
        }
        if (!beginDate.isBefore(currentDate) || !endDate.isAfter(currentDate))
        {
            System.out.println("Абонемент просрочен");
            throw new IllegalArgumentException("Абонемент просрочен");
        }
        for (int i = 0; i < arr.length; i++)
        {
            if(i == arr.length - 1 && arr[i] != null)
            {
                throw new IllegalArgumentException("Мест нет!");
            }
            if(arr[i] == null)
            {
                arr[i] = this;
            }
        }
    }
}
