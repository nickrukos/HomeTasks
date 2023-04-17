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
    private void add(Abonement abon, Abonement [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if(i == arr.length - 1 && arr[i] != null)
            {
                throw new IllegalArgumentException("the area is full!");
            }
            if(arr[i] == null)
            {
                arr[i] = abon;
                break;
            }
        }
    }
    public void addClient(Client client)
    {
        if(client.currentDate.isBefore(client.abonement.beginDate) || client.currentDate.isAfter(client.abonement.endDate))
        {
            System.out.println(client.abonement.person.customer + " Your abonement is out of date!");
            return;
        }
        if (client.currentTime.isBefore(client.abonement.typeAbon.beginTime) || client.currentTime.isAfter(client.abonement.typeAbon.endTime))
        {
            System.out.println(client.abonement.person.customer + " It's not Your time!");
            return;
        }
        for (int i = 0;i<client.abonement.typeAbon.zone.length;i++)
        {
            if(client.wishZone.name() == client.abonement.typeAbon.zone[i].name()) break;
            if(i == client.abonement.typeAbon.zone.length-1)
            {
                System.out.println(client.abonement.person.customer + " Your wished zone isn't included in abonement!");
                return;
            }
        }
        try {
            switch (client.wishZone) {
                case POOL:
                    this.add(client.abonement,arrPool);
                    break;
                case GROUP:
                    this.add(client.abonement,arrGroup);
                    break;
                case TRAINEGER:
                    this.add(client.abonement,arrTraineger);
            }
        } catch (IllegalArgumentException e) {
            if(e.getMessage() == "the area is full!")
            {
                System.out.println(client.abonement.person.customer + " Sorry, Your wished area is full!");
                return;
            }
        }
        client.abonement.setRegTime(client.currentTime);
        System.out.println("A new client came to our Fitness!");
        System.out.println(client.abonement.person.customer + " Abonement ¹ " + client.abonement.number);
        System.out.println("Area is " + client.wishZone.title);
        System.out.println("Date is " + client.currentDate.toString());
        System.out.println("Time is " + client.currentTime.toString());
    }
    private void printInfo(Abonement[] abonements)
    {
        for (int i = 0; i < abonements.length; i++)
        {
            if (abonements[i] != null)
            {
                System.out.println();
                System.out.println( abonements[i].person.customer + " BirthDate is "
                                    + abonements[i].person.birthDate.toString()
                                    + " Abonement ¹ " +  arrTraineger[i].number);
                System.out.println("BeginDate is " + abonements[i].beginDate.toString());
                System.out.println("EndDate is " +  abonements[i].endDate.toString());
                System.out.println("BeginTime is " +  abonements[i].typeAbon.beginTime.toString());
                System.out.println("EndTime is " +  abonements[i].typeAbon.endTime.toString());
                System.out.println("Registration time is " + abonements[i].getRegTime().toString());
            }
        }
    }
    public void clientsList()
    {
        System.out.println("List of our visitors");
        System.out.println(FitnessZone.TRAINEGER.title);
        printInfo(arrTraineger);
        System.out.println();

        System.out.println(FitnessZone.POOL.title);
        printInfo(arrPool);
        System.out.println();

        System.out.println(FitnessZone.GROUP.title);
        printInfo(arrGroup);
        System.out.println();
    }
}
