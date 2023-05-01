package hw15.task1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

public class Notifier {
    private HashSet<User> users;
    public void addUser(User user) {
        // ���������, ����:
        // ������������ �� null (��� null ����������� ����������) +
        // � ������������ ���� ���� �� ���� �������� ������� ��� ����������� +
        // ���� ������������ �������� �� �������������� �����������,
        // � ���� ������ ���� ���� �� ���� �������������� ������� ��� �����������
        users.add(Objects.requireNonNull(user));
    }

    public void notifyUsers(NotificationWay way){
        users.forEach(way::send);
        /*for (User user : this.users) {
            way.send(user);
        }*/
    }

}