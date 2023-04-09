package Curs1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Client
{
    private FitnessZone zone;        //желаема€ зона
    private Abonement abonement;     //абонемент клиента
    public Client(
                    FitnessZone zone, TypeAbon typeAbon,
                    LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate,
                    LocalDate currentDate, LocalTime currentTime
                 )
    {
        if(zone == null)
        {
            throw new IllegalArgumentException("«оны абонемента не существует");
        }
        if(typeAbon == null)
        {
            throw new IllegalArgumentException("“ипа абонемента не существует");
        }
        if(beginDate == null)
        {
            throw new IllegalArgumentException("Ќесуществующее значение даты начала абонемента!");
        }
        if(endDate == null)
        {
            throw new IllegalArgumentException("Ќесуществующее значение даты окончани€ абонемента!");
        }
        if(birthDate == null)
        {
            throw new IllegalArgumentException("Ќесуществующее значение даты рождени€ посетител€!");
        }
        if(!beginDate.isBefore(endDate))
        {
            throw new IllegalArgumentException("ƒата окончани€ абонемента меньше даты начала!");
        }
        if(currentDate == null)
        {
            throw new IllegalArgumentException("Ќет даты прихода посетител€");
        }
        if(currentTime == null)
        {
            throw new IllegalArgumentException("Ќет времени прихода посетител€");
        }
        this.zone = zone;
        switch (typeAbon)
        {
            case DAILY:
                abonement = new DailyAbon(beginDate,endDate,customer,birthDate);
                break;
            case FULL:
                abonement = new FullAbon(beginDate,endDate,customer,birthDate);
                break;
            case SHOT:
                abonement = new ShotAbon(beginDate,endDate,customer,birthDate);
                break;
        }
    }
}
