package hw15.task5;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        // ������� ������������ ��������� ���������� ������� (��������) ��������������� �� ������� ������������
        // 1. � ���� �������� ������ ���� ����� ��� ������ (����������� �����) - Action / IAction
        // 2. � ����������� ������ �������������� ������� ������������ ������
        // (��� ���������� ����������� �������) - void execute();
        // 3. ���������� (������-�����������) ������������ ������ ������ ����������� ����������� ������
        // � ������������ � ������� ���������� - �����, ����, �����
        // 4. � ����������� ������ ������ ���� ����������� ���������� ������ �� ��������� �������� -
        // �������� Action nextAction � ����� void nextAction(Action nextAction) � ������ Action
        // 5. � ����������� ������ ������ ���� �����, ������� ��������� ������� ���������� �� ��������� - void doAction() � ������ Action
        // 4. �����, ������� ��������� ������� ���������� �� ���������, ������������ ��������, ���������� � �������� -
        // - ����� move(Action action) � ������ Unit

		
		//� ������� ����������
		IAction action1 = new Run();
		IAction action2 = new Stop();
		IAction action3 = new Walk();

        Unit unit01 = new Unit();
        unit01.move(action1);
        unit01.move(action2);
        unit01.move(action3);

        unit01.move(action1.next(action2).next(action3));

        // ���� ��������� ����� � ������ ��������� ���������,
        // ����������� ����� ����� �������� �� �������������� ���������,
        // � ���������� ���������� ������� ����� ������ ���������
        IAction runLambda = () -> System.out.println("Run Lambda");
        IAction stopLambda = () -> System.out.println("Stop Lambda");
        IAction walkLambda = () -> System.out.println("Walk Lambda");

        Unit unit02 = new Unit();
        unit02.move(runLambda.next(stopLambda).next(walkLambda));
    }
}
