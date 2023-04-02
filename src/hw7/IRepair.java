package hw7;

public interface IRepair  //интерфейс "ремонт"
{
    //основной ремонт транспортного средства
    default  public void defaultRepairing(Carrier carrier)
    {
        if (carrier == null)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        carrier.wearDegrease(10);
        if(carrier.getWear() < 0) carrier.setWear(0);
        System.out.println("Проведен основной ремонт " + carrier.getType());
    }
    //эксплуатация транспортного средства, увеличение износа
    default public void running(Carrier carrier, int yearCount)
    {
        if (carrier  == null)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        if(4*yearCount > 100)
        {
            System.out.println("Износ " + carrier.getType() + " 100%");
            carrier.setWear(100);
        }
        carrier.setWear(carrier.getWear() + 4*yearCount);
        System.out.println("Износ " + carrier.getType() + " стал " + carrier.getWear() + "%");
    }
}
