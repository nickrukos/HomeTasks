package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Client
{
    public final LocalDate currentDate;      //Дата явки посетителя
    public final LocalTime currentTime;      //Время явки посетителя
    public final FitnessZone wishZone;       //желаемая зона
    public final Abonement abonement;        //абонемент посетителя

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public FitnessZone getWishZone() {
        return wishZone;
    }

    public Abonement getAbonement() {
        return abonement;
    }

    public Client(
            String number, FitnessZone zone, TypeAbon typeAbon,
            LocalDate beginDate, LocalDate endDate, Person person,
            LocalDate currentDate, LocalTime currentTime
                 )
    {
        if(zone == null)
        {
            throw new IllegalArgumentException("There is no area");
        }
        if(typeAbon == null)
        {
            throw new IllegalArgumentException("There is no abonement type");
        }
        if(beginDate == null)
        {
            throw new IllegalArgumentException("There is no start date of abonement");
        }
        if(endDate == null)
        {
            throw new IllegalArgumentException("There is no finish date of abonement!");
        }
        if(!beginDate.isBefore(endDate))
        {
            throw new IllegalArgumentException("Finish date is less than start date");
        }
        if(currentDate == null)
        {
            throw new IllegalArgumentException("There is no current date");
        }
        if(currentTime == null)
        {
            throw new IllegalArgumentException("Нет времени прихода посетителя");
        }
        this.wishZone = zone;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.abonement = new Abonement(number, beginDate, endDate, typeAbon, person);
    }

}
