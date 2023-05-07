package hw15.task5;

public interface IAction { // ������ ������������ ������
    void execute(); // ������ abstract void execute();

    default IAction next(IAction action){ // ������ Action nextAction(Action next) + void doAction()
        return () -> {
            execute();
            action.execute(); // �������� ��������, ����� ����� ���������� � ������� �����������,
            // ���������� ������ ��� ������������ ��������
        };
    }
}
