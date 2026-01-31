package BaiTapXuatSac1;

import java.util.Locale;
import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Role role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee { " +
                " employeeId = '" + employeeId + '\'' +
                ", employeeName = '" + employeeName + '\'' +
                ", role = " + role +
                ", salary = " + salary +
                '}';
    }

    public void inputData(Scanner scanner, Employee[] arrEmp, int index){
        employeeId = inputEmployeeID(scanner, arrEmp, index);
        employeeName = inputEmployeeName(scanner, arrEmp, index);
        role = inputRole(scanner);
        salary = inputSalary(scanner);

    }

    private double inputSalary(Scanner scanner) {
        double salary = 0;
        while (true) {
            System.out.println("Nhập lương nhân viên: ");
            salary = Double.parseDouble(scanner.nextLine());
            if (salary <= 0) {
                System.out.println("Lương nhân viên phải >0");
            } else {
                break;
            }
        }
        return salary;
    }

    private Role inputRole(Scanner scanner) {
        String role;
        while (true) {
            System.out.println("Nhập vai trò nhân viên: ");
            role = scanner.nextLine().toUpperCase();
            switch (role) {
                case "DEV":
                    return Role.DEV;
                case "TESTER":
                    return Role.TESTER;
                case "PM":
                    return Role.PM;
                case "BA":
                    return Role.BA;
                default:
                    System.out.println("Nhập sai vai trò nhân viên");
            }
        }
    }

    private String inputEmployeeName(Scanner scanner, Employee[] arrEmp, int index) {
        String name;
        while (true) {
        System.out.println("Nhập tên nhân viên: ");
        name = scanner.nextLine();
        if (name.length() < 6 || name.length() > 30) {
            System.out.println("Tên nhân viên phải có tối thiểu 6 kí tự và tối đa 30 kí tự");
        } else if (existedEmployeetName(name, arrEmp, index)) {
            System.out.println("Tên nhân viên đã tồn tại!");
        } else {
            break;
        }
    }
        return name;
    }

    private boolean existedEmployeetName(String name, Employee[] arrEmp, int index) {
        for (int i = 0; i < index; i++) {
            if (arrEmp[i].getEmployeeName().equals(name)) {
                return true;
            }
        }
        return false;

    }

    private String inputEmployeeID(Scanner scanner, Employee[] arrEmp, int index) {
        String id;
        while (true) {
            System.out.println("Nhập vào mã nhân viên: ");
            id = scanner.nextLine().toUpperCase();
            if (!id.startsWith("E")) {
                System.out.println("Mã nhân viên phải bắt đầu bằng E");
            } else if (id.length() != 5) {
                System.out.println("Mã nhân viên phải nhập vào chính xác 5 kí tự");
            } else if (existedId(id, arrEmp, index)) {
                System.out.println("Mã nhân viên " + id + " đã có");
            } else {
                break;
            }
        }
        return id;
    }

    private boolean existedId(String id, Employee[] arrEmp, int index) {
        for (int i = 0; i < index; i++) {
            if (arrEmp[i].getEmployeeId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public void displayData() {
        System.out.printf("| %-6s | %-24s | %-10s | %-24.2f |\n",
                employeeId, employeeName, role, salary);
}

}
