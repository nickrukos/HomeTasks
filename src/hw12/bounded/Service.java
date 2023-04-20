package hw12.bounded;

// в качестве ограничения можно указать один класс и любое количество интерфейсов
// в классе у generic свойства можно вызывать методы указанных типов и их супертипов
public class Service<T extends Vehicle & Repaintable> {
    private T element;
    public Service(T element) {
        this.element = element;
    }

    public void startRepair(){
        element.changeColor(Repaintable.Color.BLUE); // можно вызвать, т.к "T .. & Repaintable"
        element.repair(); // можно вызвать, т.к "T extends Vehicle ... "
        System.out.println(element.hashCode()); // можно вызвать, т.к "T extends Vehicle ... " и Vehicle - наследник Object
    }
}
