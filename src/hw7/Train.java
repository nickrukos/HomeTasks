package hw7;
//класс - поезд
public class Train extends Carrier implements IRepair {
    private int countCarriage;

    public Train(int countCarriage, String number, String color) {
        super(number, color, "Поезд",false);
        this.countCarriage = countCarriage;
    }
    @Override
    public void repair() //ремонт без добавления вагона
    {
        defaultRepairing((Carrier)this);
        System.out.println("Износ " + this.getType() + " равен " + this.getWear());
        if (Math.random() < 0.5) {
            this.countCarriage++;
            System.out.println("К поезду добавили вагон");
        }
        System.out.println(super.getType() + " отремонтирован");
    }
}
