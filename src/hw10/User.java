package hw10;

public class User<T> {
    private T id;
    private String login;

    public User(T id, String str)
    {
        this.id = id;
        this.login = str;
    }

    public void setId(T id) {
        this.id = id;
    }
    public T getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
}
