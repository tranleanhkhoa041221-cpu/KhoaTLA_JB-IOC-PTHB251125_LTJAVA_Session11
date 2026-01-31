package BaiTapGioi2;

public class DeviceManager {
    public static void main(String[] args) {
        Device[] devices = new Device[] {
                new SmartPhone(1, "Galaxy S",true),
                new Laptop(2, "ThinkPad X1", false),
                new Television(3, "Sony Bravia",true),
                new SmartPhone(4, "iPhone 14",false)
        };
        for (Device d : devices) {
            d.showInfo();
            if (d instanceof Laptop && !((Laptop) d).isOn()) {
                d.turnOn();
            } else if (d instanceof SmartPhone && !((SmartPhone) d).isOn()) {
                d.turnOn();
            } else if (d instanceof Television && !((Television) d).isOn()) {
                d.turnOn();
            }

            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            }

            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            }
            d.turnOff();

            System.out.println("---------------------------");
        }
    }
}
