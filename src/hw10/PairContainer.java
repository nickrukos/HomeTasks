package hw10;

public class PairContainer <T, V>
{
    private T key;
    private V value;
    public PairContainer(T key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
