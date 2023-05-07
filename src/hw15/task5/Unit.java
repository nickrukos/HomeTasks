package hw15.task5;

public class Unit { // использует цепочки обработчиков
    public void move(IAction action) { // реализованные через функциональный интерфейс
        action.execute();
    }
}
