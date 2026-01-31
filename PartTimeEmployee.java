package BaiTapGioi1;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int workingHour;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int id, String name, double hourlyRate, int workingHour) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.workingHour = workingHour;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workingHour;
    }
    public void showInfo() {
        super.showInfo();
        System.out.println("Type: PartTime | Hourly Rate: " + String.format("%.2f", hourlyRate) + " | Hours: " + workingHour);
    }
}
