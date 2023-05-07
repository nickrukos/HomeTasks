package hw15.task5;

public interface IAction { // вместо абстрактного класса
    void execute(); // вместо abstract void execute();

    default IAction next(IAction action){ // вместо Action nextAction(Action next) + void doAction()
        return () -> {
            execute();
            action.execute(); // возможны варианты, когда метод следующего в цепочке обработчика,
            // вызывается только при определенных условиях
        };
    }
}
