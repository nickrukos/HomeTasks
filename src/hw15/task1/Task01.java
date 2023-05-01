package hw15.task1;

import java.util.Comparator;
import java.util.function.Predicate;

public class Task01 {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();

        notifier.addUser(new User(true));
        notifier.addUser(new User(false));
        notifier.addUser(new User(true));
        notifier.addUser(new User(true));
        notifier.addUser(new User(false));
        notifier.addUser(new User(true));
        notifier.addUser(new User(false));

        // way01, way02, way03 - ссылки на способы рассылки уведомлений (например, почта, смс и т.п.)
        // void send(User user);
        NotificationWay way01 = a -> {
            System.out.println("1 способ");
        };
        NotificationWay way02 = user -> {
            System.out.println("2 способ");
        };
        NotificationWay way03 = user -> {
            System.out.println("3 способ");
        };


        notifier.notifyUsers(way01.add(way02).addIf(way03, user -> user.isAgreeWithAdditional()));
        // add принимает на вход способ рассылки уведомлений
        // addIf принимает на вход способ рассылки уведомлений и Predicate

        // boolean test(T t)
        Predicate<Integer> isPos = integer -> integer > 0;
        Predicate<Integer> isNeg = integer -> integer < 0;

        Predicate<Integer> predicate = isPos.or(isNeg);
        predicate.test(23);

    }
}
