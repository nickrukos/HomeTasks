package hw12.bounded;

public class Lesson13Bounded {
    public static void main(String[] args) {

        Train train01 = new Train("train01", 7);

        Car car01 = new Car(Repaintable.Color.ORANGE, "car01");

        Bus bus01 = new Bus("bus01");

        MiniCar mini01 = new MiniCar(Repaintable.Color.BLUE, "mini01");

        // 1. public class Service<T extends Vehicle & Repaintable> {}
        // 2. поэтому в <> можно указать тип, который является типом Vehicle и типом Repaintable, плюс любых его наследников
        // в данном случае только Car и MiniCar отвечают данным требованиям:
        // Car extends Vehicle implements Repaintable {}
        // MiniCar extends Car {}
        // 3. в качестве generic свойства можно передать тип указанный в <> и всех его наследников

        Service<Car> service01 = new Service<>(car01); // car01 или mini01
        Service<Car> service02 = new Service<>(mini01); // car01 или mini01
        Service<MiniCar> service03 = new Service<>(mini01); // только mini01

    }

}
