package hw12.bounded;

public class Bus extends Vehicle{
    private boolean wifi;

    public Bus(String number) {
        super(number);
    }

    public boolean isWifi() {
        return wifi;
    }

    @Override
    public void repair() {
        super.repair();
        if (!wifi) wifi = true;
    }
}
