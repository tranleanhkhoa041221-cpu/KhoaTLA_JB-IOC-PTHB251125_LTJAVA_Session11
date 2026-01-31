package BaiTapGioi1;

public class FullTimeEmployee extends Employee implements BonusEligible{
    private double baseSalary;
    private double bonusRate;

    public FullTimeEmployee() {
    }
    public FullTimeEmployee(int id, String name, double baseSalary, double bonusRate) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.bonusRate = bonusRate;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * bonusRate;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
    public void showInfo() {
        super.showInfo();
        System.out.println("Type: FullTime | Base Salary: " + String.format("%.2f", baseSalary) + " | Bonus Rate: " + String.format("%.2f", bonusRate));
    }
}
