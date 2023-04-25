package hw13;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application <T,V>   // ÄÇ ï. 4
{
    public Function<T,V> task4(Predicate<T> condition, Function<T,V> ifTrue, Function<T,V> ifFalse)
    {
        if(condition == null || ifTrue == null || ifFalse == null) throw new IllegalArgumentException("Null objects");
        Function<T,V> function = t -> {
            if(condition.test(t)) return ifTrue.apply(t);
            else  return  ifFalse.apply(t);
        };
        return function;
    }
    public static void main(String[] args) {

    }
}
