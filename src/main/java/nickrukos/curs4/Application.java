package nickrukos.curs4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Application
{

    public static void transaction(
                                     String country, String nameMountain, int codeMountain, int heightMountain,
                                     int groupCode, boolean openSign, LocalDate startDate, LocalTime startTime,
                                     LocalDate finishDate, LocalTime finishTime,
                                     int alpinistCode, String alpinistFullName, String alpinistAdrress
                                  )
     {
         try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
              EntityManager manager = emf.createEntityManager()) {
             manager.getTransaction().begin();

             Mountain mountain = new Mountain();
             mountain.setCountry(country);
             mountain.setName(nameMountain);
             mountain.setCode(codeMountain);
             mountain.setHeight(heightMountain);

             Group group = new Group();
             group.setMountain(mountain);
             group.setCode(groupCode);
             group.setOpen_sign(openSign);
             group.setDate_start(startDate);
             group.setTime_start(startTime);
             group.setDate_finish(finishDate);
             group.setTime_finish(finishTime);

             mountain.addGroup(group);

             Alpinist alpinist = new Alpinist();
             alpinist.setFullName(alpinistFullName);
             alpinist.setAddress(alpinistAdrress);
             alpinist.setCode(alpinistCode);

             group.addAlpinist(alpinist);

             manager.persist(mountain);
             manager.persist(group);
             manager.persist(alpinist);

             manager.getTransaction().commit();
         }
     }

     public static void firstRequest()
     {
         try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
              EntityManager manager = emf.createEntityManager())
         {
             //select mnt.name
             //from itmo.tb_mountain mnt
             //inner join itmo.tb_group grp
             //on grp.mountain_id = mnt.code
             //where grp.date_finish < now()

             CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
             CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
             Root<Mountain> root = criteriaQuery.from(Mountain.class);
             Join<Mountain,Group> mountainGroupJoin = root.join("groups", JoinType.INNER);
             Predicate predicate = criteriaBuilder.lessThan(mountainGroupJoin.get("date_finish"),LocalDate.now());
             Path<String> mountName = root.get("name");
             criteriaQuery.multiselect(mountName).where(predicate);
             List<String> listMountNames = manager.createQuery(criteriaQuery).getResultList();
             for (int i = 0; i < listMountNames.size(); i++)
             {
                 System.out.println(listMountNames.get(i));
             }
         }
     }

    public static void main(String[] args)
    {
        /*
        transaction(
                    "RU","Pamir",3,7649,
                    3, true, LocalDate.of(2023,7,7), LocalTime.of(10,0),
                     LocalDate.of(2023,7,16),LocalTime.of(18,0),
                     3,"Ben","Riga"
                   );

        transaction(
                    "RU","RomanCosh",4,1545,
                    4, true, LocalDate.of(2023,7,26), LocalTime.of(10,0),
                    LocalDate.of(2023,8,4),LocalTime.of(18,0),
                    4,"Nick","SPB"
                   );
        */
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
             EntityManager manager = emf.createEntityManager())
        {
            /*
            select mnt.name
            from itmo.tb_mountain mnt
            where not exists
            (
                select 1 from itmo.tb_group grp
                where grp.mountain_id = mnt.code
                and grp.date_finish < now()
            )
            */
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
            Root<Mountain> root = query.from(Mountain.class);
            Path<String> mountName = root.get("name");
            query.multiselect(mountName);
            Subquery<Group> subquery = query.subquery(Group.class);
            Root<Group> subRootEntity = subquery.from(Group.class);
            subquery.select(subRootEntity).where(criteriaBuilder.equal(subRootEntity.get("mountain"),root));
            Predicate predicate = criteriaBuilder.not(criteriaBuilder.exists(subquery
                                   .where(criteriaBuilder.lessThan(subRootEntity.get("date_finish"),LocalDate.now()))));

            List<String> listMountNames = manager.createQuery(query.where(predicate)).getResultList();
            for (int i = 0; i < listMountNames.size(); i++)
            {
                System.out.println(listMountNames.get(i));
            }
        }
    }

}