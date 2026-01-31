package BaiTapGioi2;

public class SmartPhone extends Device implements Connectable, Chargeable{
    private boolean isOn;

    public SmartPhone() {
    }

    public SmartPhone(int id, String name, boolean isOn) {
        super(id, name);
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void charge() {
        System.out.println(getName() + " is charging (SmartPhone).");

    }

    @Override
    public void connectWifi() {
        if (isOn) {
            System.out.println(getName() + " connected to WiFi.");
        } else {
            System.out.println(getName() + " cannot connect to WiFi because it is OFF."); }

    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(getName() + " (SmartPhone) is turned ON.");

    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(getName() + " (SmartPhone) is turned OFF.");

    }
    public void showInfo() {
        super.showInfo();
        System.out.println("Type: SmartPhone");
    }
}
