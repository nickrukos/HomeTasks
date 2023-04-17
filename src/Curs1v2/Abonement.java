package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

public  class Abonement
{
    public final String  number;
    public final LocalDate beginDate;         //дата начала абонемента
    public final LocalDate endDate;           //дата конца абонемента
    public final Person person;                //ƒанные посетител€
    public final TypeAbon typeAbon;           //“ип абонемента
    private LocalTime regTime;                //¬рем€ регистрации абонемента

    public Abonement(String number,LocalDate beginDate, LocalDate endDate, TypeAbon typeAbon, Person person)
    {
        this.number = number;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.typeAbon = typeAbon;
        this.person = person;
    }

    public void setRegTime(LocalTime regTime) {
        this.regTime = regTime;
    }

    public LocalTime getRegTime() {
        return regTime;
    }


}
