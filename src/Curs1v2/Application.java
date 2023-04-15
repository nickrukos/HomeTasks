package Curs1v2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Application
{
    public static void main(String[] args)
    {
        Client client01 = new Client("2023-1", FitnessZone.POOL, TypeAbon.DAILY,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                "John Small", LocalDate.of(1976, 2, 12),
                LocalDate.of(2023, 04, 14),
                LocalTime.of(17, 30));

        Client client02 = new Client("2023-2", FitnessZone.GROUP, TypeAbon.SHOT,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                "Micle Douglass", LocalDate.of(1965, 3, 24),
                LocalDate.of(2023, 03, 14),
                LocalTime.of(17, 30));

        Client client03 = new Client("2023-3", FitnessZone.TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                "Dick Stuloff", LocalDate.of(1971, 1, 1),
                LocalDate.of(2023, 04, 14),
                LocalTime.of(07, 30));

        Client client04 = new Client("2023-4", FitnessZone.TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                "Abraham Nashwill", LocalDate.of(1983, 6, 12),
                LocalDate.of(2023, 04, 14),
                LocalTime.of(12, 30));

        Client client05 = new Client("2023-5", FitnessZone.TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                "Ivan Ivanoff", LocalDate.of(1957, 4, 11),
                LocalDate.of(2023, 04, 14),
                LocalTime.of(12, 30));

        Client client06 = new Client("2023-6", FitnessZone.TRAINEGER, TypeAbon.FULL,
                LocalDate.of(2023, 04, 01),
                LocalDate.of(2023, 04, 30),
                "Andrew Rock", LocalDate.of(1962, 9, 19),
                LocalDate.of(2023, 04, 14),
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
