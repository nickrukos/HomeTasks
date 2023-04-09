package Curs1;

import java.time.LocalDate;
import java.time.LocalTime;

public class DailyAbon extends Abonement
{
    private final LocalTime beginTime = LocalTime.of(8,0);
    private final LocalTime endTime = LocalTime.of(16,0);
    private final FitnessZone[] zone = {FitnessZone.TRAINEGER,FitnessZone.GROUP};
    public DailyAbon(LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate)
    {
        super(beginDate,endDate,customer,birthDate);
    }
    public void add(DailyAbon [] arr, LocalDate currentDate, LocalTime currentTime) throws IllegalArgumentException
    {
        if(currentTime.isBefore(beginTime) || currentTime.isAfter(endTime))
        {
            throw new IllegalArgumentException("Вы пришли не в свое время");
        }
        super.add(arr,currentDate);
    }
}
