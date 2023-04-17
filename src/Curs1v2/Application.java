package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

import static Curs1v2.FitnessZone.*;

public class Application
{
    public static void main(String[] args)
    {
        TypeAbon.DAILY.zone[0] = GROUP;
        TypeAbon.DAILY.zone[1] = TRAINEGER;
        TypeAbon.FULL.zone[0] = GROUP;
        TypeAbon.FULL.zone[1] = TRAINEGER;
        TypeAbon.FULL.zone[2] = POOL;
        TypeAbon.SHOT.zone[0] = POOL;
        TypeAbon.SHOT.zone[1] = TRAINEGER;

        Person person01 = new Person("John Small", LocalDate.of(1976, 2, 12));
        Person person02 = new Person("Micle Douglass", LocalDate.of(1965, 3, 24));
        Person person03 = new Person("Dick Hack", LocalDate.of(1971, 1, 1));
        Person person04 = new Person("Abraham Nashweell", LocalDate.of(1983, 6, 12));
        Person person05 = new Person("Bill Smith", LocalDate.of(1957, 4, 11));
        Person person06 = new Person("Andrew Rock", LocalDate.of(1962, 9, 19));



        Client client01 = new Client("2023-1", FitnessZone.POOL, TypeAbon.DAILY,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                person01, LocalDate.of(2023, 04, 14),
                LocalTime.of(17, 30));

        Client client02 = new Client("2023-2", GROUP, TypeAbon.SHOT,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                person02, LocalDate.of(2023, 03, 14),
                LocalTime.of(17, 30));

        Client client03 = new Client("2023-3", TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                person03, LocalDate.of(2023, 04, 14),
                LocalTime.of(07, 30));

        Client client04 = new Client("2023-4", TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                person04, LocalDate.of(2023, 04, 14),
                LocalTime.of(12, 30));

        Client client05 = new Client("2023-5", TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                person05, LocalDate.of(2023, 04, 14),
                LocalTime.of(12, 30));

        Client client06 = new Client("2023-6", TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                person06, LocalDate.of(2023, 04, 14),
                LocalTime.of(12, 30));

        FitnessClub club = new FitnessClub();
        club.addClient(client01);
        club.addClient(client02);
        club.addClient(client03);
        club.addClient(client04);
        club.addClient(client05);
        club.addClient(client06);
        club.clientsList();
    }
}
