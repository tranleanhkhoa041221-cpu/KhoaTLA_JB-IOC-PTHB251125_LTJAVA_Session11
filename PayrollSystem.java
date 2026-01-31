package BaiTapGioi1;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new FullTimeEmployee(1, "An", 1000.0, 0.10),
                new PartTimeEmployee(2, "Binh", 15.0, 80),
                new FullTimeEmployee(3, "Cuong", 1500.0, 0.15),
                new PartTimeEmployee(4, "Dung", 20.0, 60)};
        for (Employee e : employees) {
            e.showInfo();
            double salary = e.calculateSalary();
            System.out.println("Salary: " + String.format("%.2f", salary));
            if (e instanceof BonusEligible) {
                BonusEligible be = (BonusEligible) e;
                double bonus = be.calculateBonus();
                System.out.println("Bonus: " + String.format("%.2f", bonus));
            }
            System.out.println("---------------------------");
        }

    }
}
