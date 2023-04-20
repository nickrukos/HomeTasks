package hw12.bounded;

public class Car extends Vehicle implements Repaintable{
    private Color color;
    public Car(Color color, String number) {
        super(number);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public void changeColor(Color newColor) {
        color = newColor;
        System.out.println("Машина №" + number + " перекрашена в " + newColor.getName());
    }
}
