package hw6.Task1;

public class Mountain
{
    private String name;
    private String country;
    private int height;

     public Mountain(String name, String country, int height)
     {
        if(height > 100)
        {
            this.height = height;
        }
        else throw new IllegalArgumentException("Высота более 100 метров");
        if (country != null && country.length() > 3) {
            this.country = country;
        }
        else throw new IllegalArgumentException("Название страны не менее 4-х символов");
        if (name != null && name.length() > 3) {
            this.name = name;
        }
        else throw new IllegalArgumentException("Название горы не менее 4-х символов");
    }
}
