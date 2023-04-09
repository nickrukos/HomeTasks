package Curs1;

import java.time.LocalDate;
import java.time.LocalTime;

public class FullAbon extends Abonement
{
    private final LocalTime beginTime = LocalTime.of(8,0);
    private final LocalTime endTime = LocalTime.of(22,0);
    private final FitnessZone[] zone = {FitnessZone.POOL,FitnessZone.TRAINEGER,FitnessZone.GROUP};
    public FullAbon(LocalDate beginDate, LocalDate endDate, String customer, LocalDate birthDate)
    {
        super(beginDate,endDate,customer,birthDate);
    }
    public void add(FullAbon[] arr, LocalDate currentDate, LocalTime currentTime) throws IllegalArgumentException
    {
        if(currentTime.isBefore(beginTime) || currentTime.isAfter(endTime))
        {
            throw new IllegalArgumentException("Вы пришли не в свое время");
        }
        super.add(arr,currentDate);
    }
}
