package hw15.task1;

import java.util.function.Predicate;

@FunctionalInterface
public interface NotificationWay {
    void send(User user);
    default NotificationWay add(NotificationWay way){
        return u -> {
            send(u);
            way.send(u);
        };
    }

    default NotificationWay addIf(NotificationWay way, Predicate<User> predicate){
        return u -> {
            send(u);
            if (predicate.test(u)) {
                way.send(u);
            }
        };
    }
}
