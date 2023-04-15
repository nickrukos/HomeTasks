package Curs1v2;

public class FitnessClub
{
    private final int AREA_SIZE = 20;
    private Abonement[] arrPool;
    private Abonement[] arrTraineger;
    private Abonement[] arrGroup;
    public FitnessClub()
    {
        this.arrGroup = new Abonement[AREA_SIZE];
        this.arrPool = new Abonement[AREA_SIZE];
        this.arrTraineger = new Abonement[AREA_SIZE];
    }
    public void addClient(Client client)
    {
        if(client.currentDate.isBefore(client.abonement.beginDate) || client.currentDate.isAfter(client.abonement.endDate))
        {
            System.out.println(client.abonement.customer + " Your abonement is out of date!");
            return;
        }
        if (client.currentTime.isBefore(client.abonement.typeAbon.beginTime) || client.currentTime.isAfter(client.abonement.typeAbon.endTime))
        {
            System.out.println(client.abonement.customer + " It's not Your time!");
            return;
        }
        for (int i = 0;i<client.abonement.typeAbon.zone.length;i++)
        {
            if(client.wishZone.name() == client.abonement.typeAbon.zone[i].name()) break;
            if(i == client.abonement.typeAbon.zone.length-1)
            {
                System.out.println(client.abonement.customer + " Your wished zone isn't included in abonement!");
                return;
            }
        }
        try {
            switch (client.wishZone) {
                case POOL:
                    client.abonement.add(arrPool);
                    break;
                case GROUP:
                    client.abonement.add(arrGroup);
                    break;
                case TRAINEGER:
                    client.abonement.add(arrTraineger);
            }
        } catch (IllegalArgumentException e) {
            if(e.getMessage() == "Wrong point to array")
            {
                System.out.println(client.abonement.customer +" You haven't abonement");
                return;
            }
            if(e.getMessage() == "the area is full!")
            {
                System.out.println(client.abonement.customer + " Sorry, Your wished area is full!");
                return;
            }
        }
        client.abonement.setRegTime(client.currentTime);
        System.out.println("A new client came to our Fitness!");
        System.out.println(client.abonement.customer + " Abonement ¹ " + client.abonement.number);
        System.out.println("Area is " + client.wishZone.title);
        System.out.println("Date is " + client.currentDate.toString());
        System.out.println("Time is " + client.currentTime.toString());
    }
    public void clientsList()
    {
        System.out.println("List of our visitors");

        System.out.println(FitnessZone.TRAINEGER.title);
        for (int i = 0; i < arrTraineger.length; i++)
        {
            if (arrTraineger[i] != null)
            {
                System.out.println( arrTraineger[i].customer + " Abonement ¹ " +  arrTraineger[i].number);
                System.out.println("BeginDate is " +  arrTraineger[i].beginDate.toString());
                System.out.println("EndDate is " +  arrTraineger[i].endDate.toString());
                System.out.println("BeginTime is " +  arrTraineger[i].typeAbon.beginTime.toString());
                System.out.println("EndTime is " +  arrTraineger[i].typeAbon.endTime.toString());
                System.out.println("Registration time is " + arrTraineger[i].getRegTime().toString());
                System.out.println();
            }

        }

        System.out.println(FitnessZone.POOL.title);
        for (int i = 0; i < arrPool.length; i++)
        {
            if(arrPool[i] != null)
            {
                System.out.println( arrPool[i].customer + "Abonement ¹ " +  arrPool[i].number);
                System.out.println("BeginDate is " +  arrPool[i].beginDate.toString());
                System.out.println("EndDate is " +  arrPool[i].endDate.toString());
                System.out.println("BeginTime is " +  arrPool[i].typeAbon.beginTime.toString());
                System.out.println("EndTime is " +  arrPool[i].typeAbon.endTime.toString());
                System.out.println();
            }

        }

        System.out.println(FitnessZone.GROUP.title);
        for (int i = 0; i < arrGroup.length; i++)
        {
            if(arrGroup[i] != null)
            {
                System.out.println( arrGroup[i].customer + "Abonement ¹ " +  arrGroup[i].number);
                System.out.println("BeginDate is " +  arrGroup[i].beginDate.toString());
                System.out.println("EndDate is " +  arrGroup[i].endDate.toString());
                System.out.println("BeginTime is " +  arrGroup[i].typeAbon.beginTime.toString());
                System.out.println("EndTime is " +  arrGroup[i].typeAbon.endTime.toString());
                System.out.println();
            }

        }
    }
}
