package hw7;

public class Application
{
    public static void main(String[] args)
    {
        String [] arrColor = {"серый", "синий", "металлик", "черный", "циан", "красный", "вишневый"};
        Train train01 = new Train(8,"ЭР-7845","окрас РЖД");
        Car car01 = new Car("А924ЧК 178", "Желтый");
        Car car02 = new Car("В724ЕС 178","черный");
        Bus bus01 = new Bus(false,"О345ОО 178","бирюзовый");
        Bus bus02 = new Bus(true,"O467OO 178","бирюзовый");

        //эксплуатация транспортных средств
        System.out.println();
        System.out.println("Эксплуатация транспортных средств");
        car01.running(car01,6);
        car02.running(car02,12);
        train01.running(train01,13);
        bus01.running(bus01,20);
        bus02.running(bus02,18);

        //ремонт транспортных средств
        System.out.println();
        System.out.println("Ремонт транспортных средств");
        repairFactory factory = new repairFactory(arrColor);
        factory.add((Carrier) car01);
        factory.add((Carrier) car02);
        factory.add((Carrier) train01);
        factory.add((Carrier) bus01);
        factory.add((Carrier) bus02);
        System.out.println();
        factory.repairAll();
    }
}
