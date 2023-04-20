package hw12.bounded;

public class Train extends Vehicle{
    private final Repaintable.Color color = Repaintable.Color.BLUE;
    private int carCount;
    public Train(String number, int carCount) {
        super(number);
        this.carCount = carCount;
    }

    public Repaintable.Color getColor() {
        return color;
    }

    public int getCarCount() {
        return carCount;
    }

    @Override
    public void repair() {
        super.repair();
        if (Math.random() < 0.5) carCount++;
    }
}
