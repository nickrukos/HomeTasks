package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

//Тип абонемента
public enum TypeAbon
{
    DAILY(new FitnessZone[2],LocalTime.of(8,0),LocalTime.of(16,0)),
    FULL(new FitnessZone[3],LocalTime.of(8,0),LocalTime.of(22,0)),
    SHOT(new FitnessZone[2],LocalTime.of(8,0),LocalTime.of(22,0));
    public final LocalTime beginTime;
    public final LocalTime endTime;
    public final FitnessZone [] zone;
    TypeAbon(FitnessZone[] zone, LocalTime beginTime, LocalTime endTime)
    {
        this.zone = zone;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
/*
    TypeAbon()
    {
        if(this.name() == "DAILY")
        {
            this.zone = new FitnessZone[2];
            this.zone[0] = FitnessZone.GROUP;
            this.zone[1] = FitnessZone.TRAINEGER;
            this.beginTime = LocalTime.of(8,0);
            this.endTime = LocalTime.of(16,0);

        }
        else if(this.name() == "FULL")
        {
            this.zone = new FitnessZone[3];
            this.zone[0] = FitnessZone.GROUP;
            this.zone[1] = FitnessZone.TRAINEGER;
            this.zone[2] = FitnessZone.POOL;
            this.beginTime = LocalTime.of(8,0);
            this.endTime = LocalTime.of(22,0);
        }
        else
        {
            //SHOT
            this.zone = new FitnessZone[2];
            this.zone[0] = FitnessZone.POOL;
            this.zone[1] = FitnessZone.TRAINEGER;
            this.beginTime = LocalTime.of(8,0);
            this.endTime = LocalTime.of(22,0);
        }
    }

 */
}
