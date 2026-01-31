package BaiTapXuatSac1;

import java.time.LocalDate;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees;
    private Status status;

    public Project() {
        this.employees = new Employee[100];
    }

    public Project(String projectId, String projectName, LocalDate startDate, LocalDate endDate, Employee[] employees, Status status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employees = new Employee[100];
        if (employees != null) {
            for (int i = 0; i < employees.length; i++) {
                this.employees[i] = employees[i];
            }
        }
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Project[] arrProject, int index) {
        projectId = inutProjectId(scanner, arrProject, index);
        projectName = inputProjectName(scanner, arrProject, index);
        startDate = inputStartDate(scanner);
        endDate = inputEndDate(scanner);
        //   employees = inputDSEmployeeJoin(scanner,arrEmp,empIndex);
        status = inputStatus(scanner);
    }

    private Status inputStatus(Scanner scanner) {
        String status;
        while (true) {
            System.out.println("Nhập trạng thái: ");
            status = scanner.nextLine().toUpperCase();
            switch (status) {
                case "PLANNING":
                    return Status.PLANNING;
                case "RUNNING":
                    return Status.RUNNING;
                case "FINISHED":
                    return Status.FINISHED;
                default:
                    System.out.println("Nhập sai trạng thái dự án");
            }
        }
    }


    public void inputDSEmployeeJoin(Scanner scanner, Employee[] arrEmp, int empIndex) {
        if (empIndex == 0) {
            System.out.println("Hệ thống chưa có nhân viên nào!");
            return;
        }
        if (this.employees == null) {
            this.employees = new Employee[100];
        }
        System.out.println("Danh sách nhân viên hiện có:");
        for (int i = 0; i < empIndex; i++) {
            System.out.printf("%d. %s - %s\n",
                    i + 1,
                    arrEmp[i].getEmployeeId(),
                    arrEmp[i].getEmployeeName());
        }

        System.out.print("Nhập số lượng nhân viên muốn thêm: ");
        int num = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < num; i++) {
            while (true) {
                System.out.print("Chọn nhân viên thứ " + (i + 1) + ": ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice < 1 || choice > empIndex) {
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
                }

                Employee e = arrEmp[choice - 1];

                boolean duplicate = false;
                for (Employee emp : employees) {
                    if (emp != null && emp.getEmployeeId().equals(e.getEmployeeId())) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("Nhân viên đã tồn tại trong dự án!");
                } else {
                    for (int j = 0; j < employees.length; j++) {
                        if (employees[j] == null) {
                            employees[j] = e;
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }


    private LocalDate inputEndDate(Scanner scanner) {
        LocalDate enddate;
        while (true) {
            try {
                System.out.println("Nhập ngày kết thúc (yyyy-MM-dd): ");
                enddate = LocalDate.parse(scanner.nextLine());
                if (!enddate.isBefore(startDate)) {
                    return enddate;
                }
                System.out.println("Ngày kết thúc phải >= ngày bắt đầu!");
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    private LocalDate inputStartDate(Scanner scanner) {
        LocalDate startdate;
        while (true) {
            try {
                System.out.println("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                startdate = LocalDate.parse(scanner.nextLine());
                return startdate;
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại!");
            }
        }

    }

    private String inputProjectName(Scanner scanner, Project[] arrProject, int index) {
        String name;
        while (true) {
            System.out.println("Nhập tên dự án: ");
            name = scanner.nextLine();
            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên dự án phải có tối thiểu 10 kí tự và tối đa 50 kí tự");
            } else if (existedProjectName(name, arrProject, index)) {
                System.out.println("Tên dự án đã tồn tại!");
            } else {
                break;
            }
        }
        return name;
    }

    private boolean existedProjectName(String name, Project[] arrProject, int index) {
        for (int i = 0; i < index; i++) {
            if (arrProject[i].getProjectName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private String inutProjectId(Scanner scanner, Project[] arrProject, int index) {
        String id;
        while (true) {
            System.out.println("Nhập vào mã dự án: ");
            id = scanner.nextLine().toUpperCase();
            if (!id.startsWith("P")) {
                System.out.println("Mã dự án phải bắt đầu bằng P");
            } else if (id.length() != 5) {
                System.out.println("Mã dự án phải nhập vào chính xác 5 kí tự");
            } else if (existedId(id, arrProject, index)) {
                System.out.println("Mã dự án " + id + " đã có");
            } else {
                break;
            }
        }
        return id;
    }

    private boolean existedId(String id, Project[] arrProject, int index) {
        for (int i = 0; i < index; i++) {
            if (arrProject[i].getProjectId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void displayData() {
        System.out.printf("| %-6s | %-24s | %-12s | %-12s | %-10s |\n",
                projectId, projectName, startDate, endDate, status);
    }

}
