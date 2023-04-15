package hw11.task02;

import java.util.*;

public class Task02 {

    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        if(messageList.size() == 0)
        {
            System.out.println(0);
            return;
        }
        int[] countPriority = new int[Message.MessagePriority.values().length];
        for (Message message : messageList)
        {
            for (int i=0;i<Message.MessagePriority.values().length;i++)
            {
               if(message.getPriority().equals(Message.MessagePriority.getPriority(i)))
               {
                   countPriority[i] ++;
               }
            }
        }
        for (int i = 0; i < Message.MessagePriority.values().length; i++)
        {
            System.out.println("Priority is " + Message.MessagePriority.values()[i].name()
                               + " Message count is " + countPriority[i]);
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        ArrayList <Integer> arrCode = new ArrayList<Integer>();
        ArrayList <Integer>arrCount = new ArrayList<Integer>();
        for (Message message : messageList)
        {
            int index = arrCode.indexOf(message.getCode());
            if(index != -1)
            {
                arrCount.set(index,arrCount.get(index)+1);
                continue;
            }
            arrCode.add(message.getCode());
            arrCount.add(1);
        }
        for (int i = 0; i < arrCount.size(); i++)
        {
            System.out.println("Code is " + arrCode.get(i) + " Count is " + arrCount.get(i));
        }

    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        ArrayList <Message> uniqueMes = new ArrayList<>();
        for (Message message : messageList)
        {
            if(uniqueMes.indexOf(message) == -1) uniqueMes.add(message);
        }
        System.out.println("Count of unique messages is " + uniqueMes.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        if(messageList == null) return Collections.emptyList();
        ArrayList <Message> uniqueMes = new ArrayList<>();
        for(int i=0;i<messageList.size();i++)
        {
            if(uniqueMes.indexOf(messageList.get(i)) == -1)
            {
                uniqueMes.add(messageList.get(i));
            }
        }
        return (List)uniqueMes;
    }

    public static void removeEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        if(messageList == null) return;
        ListIterator <Message> iteratorMes = messageList.listIterator();
        System.out.println("Deleting with  Priority");
        System.out.println("Before deleting");
        for (Message message : messageList)
        {
            System.out.println(message.toString());
        }
        while (iteratorMes.hasNext())
        {
            if(iteratorMes.next().getPriority().equals(priority))
                iteratorMes.remove();
        }
        System.out.println("After deleting");
        for (Message message : messageList)
        {
            System.out.println(message.toString());
        }
    }

    public static void removeOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        if(messageList == null) return;
        ListIterator <Message> iteratorMes = messageList.listIterator();
        System.out.println("Deleting with  no Priority");
        System.out.println("Before deleting");
        for (Message message : messageList)
        {
            System.out.println(message.toString());
        }
        while (iteratorMes.hasNext())
        {
            if(!iteratorMes.next().getPriority().equals(priority))
                iteratorMes.remove();
        }
        System.out.println("After deleting");
        for (Message message : messageList)
        {
            System.out.println(message.toString());
        }
    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, Message.MessagePriority.HIGH);
        removeOther(messages, Message.MessagePriority.LOW);
    }
}
