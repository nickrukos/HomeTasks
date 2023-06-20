package nickrukos.curs4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
             EntityManager manager = emf.createEntityManager())
        {
            manager.getTransaction().begin();

            Mountain mountain = new Mountain();
            mountain.setCountry("RU");
            mountain.setName("Elbrus");
            mountain.setCode(1);
            mountain.setHeight(5642);

            Group group = new Group();
            group.setMountain(mountain);
            group.setCode(1);
            group.setOpen_sign(true);
            group.setDate_start(LocalDate.of(2023,06,30));
            group.setTime_start(LocalTime.of(10,0));
            group.setDate_finish(LocalDate.of(2023,07,20));
            group.setTime_finish(LocalTime.of(18,0));

            mountain.addGroup(group);

            Alpinist alpinist = new Alpinist();
            alpinist.setFullName("Bob");
            alpinist.setAddress("Spb");
            alpinist.setCode(1);

            group.addAlpinist(alpinist);

            manager.persist(mountain);
            manager.persist(group);
            manager.persist(alpinist);

            manager.getTransaction().commit();
        }
    }
}