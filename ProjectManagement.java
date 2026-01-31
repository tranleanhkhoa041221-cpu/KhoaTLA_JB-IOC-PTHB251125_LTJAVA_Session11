package BaiTapXuatSac1;

import java.time.LocalDate;
import java.util.Scanner;

public class ProjectManagement {
  private static Employee[] employees ;
  private static Project[] projects ;
  private static int countemployees = 0;
  private static int countemployeesbyuser = 0;
  private static int countprojects = 0;
  private static int countprojectsbyuser = 0;
  private static final int MAX_SIZE = 100;
    public static void MenuMain(){
        System.out.println("============== QUẢN LÝ ==============");
        System.out.println("1. Quản Lý Nhân Viên ");
        System.out.println("2. Quản lý dự án ");
        System.out.println("3. Thoát ");
        System.out.println("====================================");
    }
    public static void MenuEmployee(){
        System.out.println("========== QUẢN LÝ NHÂN VIÊN ==========");
        System.out.println("1. Thêm nhân viên ");
        System.out.println("2. Hiển thị danh sách nhân viên ");
        System.out.println("3. Cập nhật thông tin nhân viên ");
        System.out.println("4. Xóa Nhân Viên ");
        System.out.println("5. Tìm kiếm nhân viên theo tên ");
        System.out.println("6. Sắp xếp nhân viên theo lương giảm dần và tăng dần ");
        System.out.println("7. Thống kê số nhân viên đã tạo ");
        System.out.println("8. Xóa Nhân Viên khỏi toàn bộ hệ thống ");
        System.out.println("9. Thoát ");
        System.out.println("=====================================");
    }
    public static void MenuProject(){
        System.out.println("========== QUẢN LÝ DỰ ÁN ==========");
        System.out.println("1. Thêm dự án ");
        System.out.println("2. Hiển thị danh sách dự án ");
        System.out.println("3. Cập nhật thông tin dự án ");
        System.out.println("4. Xóa dự án (Chỉ khi chưa có nhân viên tham gia) ");
        System.out.println("5. Thêm nhân viên vào dự án ");
        System.out.println("6. Tìm dự án theo tên ");
        System.out.println("7. Thống kê số lượng nhân viên theo vai trò trong từng dự án ");
        System.out.println("8. Tìm dự án đang chạy và gần kết thúc nhất ");
        System.out.println("9. Xóa nhân viên khỏi dự án ");
        System.out.println("10. Thống kê số dự án đã tạo ");
        System.out.println("11. Thoát ");
        System.out.println("=====================================");
    }

    static {
        employees = new Employee[MAX_SIZE];
        Employee e1 = new Employee("E0001", "Trần Khoa", Role.DEV, 20000);
        employees[0] = e1;
        countemployees = 1;


        projects = new Project[MAX_SIZE];
        Employee[] team = new Employee[MAX_SIZE];
        team[0] = e1;
        Project p1 = new Project("P0001", "Quản lý bán hàng", LocalDate.parse("2026-01-01"), LocalDate.parse("2026-06-30"),team, Status.RUNNING);
        projects[0] = p1;
        countprojects = 1;
    }
    public static int getTotalEmployees() {
        return countemployees;
    }
    public static int getTotalEmployeeCreatedByUser() {
        return countemployeesbyuser;
  }
    public static int getTotalProjects() {
    return countprojects ;
  }
   public static int getTotalProejectCreatedByUser() {
    return countprojectsbyuser;
  }
    public static void showListProjectWithEmployees() {
        if (countprojects == 0) {
            System.out.println("Chưa có dự án nào trong danh sách");
            return;
        }

        System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(14), "-".repeat(14), "-".repeat(12));
        System.out.printf("| %-6s | %-24s | %-12s | %-12s | %-10s |\n", "ID", "Tên Dự Án", "Ngày BĐ", "Ngày KT", "Trạng Thái");
        System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(14), "-".repeat(14), "-".repeat(12));
        for (int i = 0; i < countprojects; i++) {
            projects[i].displayData();
        System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(14), "-".repeat(14), "-".repeat(12));

            System.out.println(">> Danh sách nhân viên tham gia:");
            if (projects[i].getEmployees() != null && projects[i].getEmployees().length > 0) {
                System.out.printf("+%s+%s+%s+%s+\n",
                        "-".repeat(8), "-".repeat(26), "-".repeat(12), "-".repeat(26));
                System.out.printf("| %-6s | %-24s | %-10s | %-24s |\n",
                        "ID", "Tên Nhân Viên", "Vai Trò", "Lương");
                System.out.printf("+%s+%s+%s+%s+\n",
                        "-".repeat(8), "-".repeat(26), "-".repeat(12), "-".repeat(26));
                for (Employee emp : projects[i].getEmployees()) {
                    if (emp != null) {
                        emp.displayData();
                    }
                }
                System.out.printf("+%s+%s+%s+%s+\n",
                        "-".repeat(8), "-".repeat(26), "-".repeat(12), "-".repeat(26));
            } else {
                System.out.println("Chưa có nhân viên tham gia.");
            }

            System.out.println();
        }
    }
    public static void removeEmployeeFromProject(Project project, String empId) {
        Employee[] list = project.getEmployees();
        if (list == null) {
            System.out.println("Dự án chưa có nhân viên!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getEmployeeId().equalsIgnoreCase(empId)) {
                list[i] = null;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Nhân viên có ID " + empId + " không có trong dự án này!");
            return;
        }
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == null && list[i + 1] != null) {
                list[i] = list[i + 1];
                list[i + 1] = null;
            }
        }

        System.out.println("Đã xóa nhân viên [" + empId + "] khỏi dự án thành công!");
    }
    public static void removeEmployeeFromAllProjects(String empId) {
        for (int i = 0; i < countprojects; i++) {
            Employee[] list = projects[i].getEmployees();
            if (list == null)
                continue;

            boolean foundInThisProject = false;
            for (int j = 0; j < list.length; j++) {
                if (list[j] != null && list[j].getEmployeeId().equalsIgnoreCase(empId)) {
                    list[j] = null;
                    foundInThisProject = true;
                    break;

                }
            }

            if (foundInThisProject) {
                for (int j = 0; j < list.length - 1; j++) {
                    if (list[j] == null && list[j + 1] != null) {
                        list[j] = list[j + 1];
                        list[j + 1] = null;
                    }
                }
            }
            System.out.println("Đã xóa nhân viên [" + empId + "] khỏi toàn bộ hệ thống!");
        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            MenuMain();
            System.out.println("Lựa chọn của bạn: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1: {
                    int choice;
                   do {
                       MenuEmployee();
                       System.out.println("Lựa chọn của bạn: ");
                       choice = Integer.parseInt(scanner.nextLine());
                       switch (choice) {
                           case 1:
                               System.out.println("Thêm nhân viên mới");
                               int n ;
                               System.out.println("Nhập số lượng nhân viên muốn thêm: ");
                               n = Integer.parseInt(scanner.nextLine());
                               for (int i = 0; i < n; i++) {
                                   System.out.printf("--- Nhập thông tin nhân viên thứ %d ---\n", i + 1);
                                   Employee newemployee = new Employee();
                                   newemployee.inputData(scanner,employees,countemployees);
                                   employees[countemployees] = newemployee;
                                   countemployeesbyuser++;
                                   countemployees++;
                               }
                               System.out.printf("Đã thêm %d nhân viên thành công!\n", n);
                               break;
                           case 2:
                               System.out.println("Hiển thị danh sách nhân viên");
                               if (countemployees == 0) {
                                   System.out.println("Chưa có nhân viên nào.");
                                   break;
                               } else {
                                   System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(12), "-".repeat(26));
                                   System.out.printf("| %-6s | %-24s | %-10s | %-24s |\n", "ID", "Tên Nhân Viên", "Vai Trò", "Lương");
                                   System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(12), "-".repeat(26));
                                   for (int i = 0; i < countemployees; i++) {
                                       employees[i].displayData();
                                   }
                                   System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(12), "-".repeat(26));
                               }
                               break;
                           case 3:
                               System.out.print("Nhập mã nhân viên cần cập nhật: ");
                               String updateId = scanner.nextLine().toUpperCase();
                               boolean foundUpdate = false;
                               for (int i = 0; i < countemployees; i++) {
                                   if (employees[i].getEmployeeId().equals(updateId)) {
                                       employees[i].inputData(scanner, employees, countemployees);
                                       employees[i].setEmployeeId(updateId);
                                       System.out.println("Đã cập nhật thành công cho nhân viên có Id: " + updateId);
                                       employees[i].displayData();
                                       foundUpdate = true;
                                       break;
                                   }
                               }
                               if (!foundUpdate) {
                                   System.out.println("Không tìm thấy nhân viên với Id" + updateId);
                               }
                               break;
                           case 4:
                               System.out.print("Nhập ID nhân viên cần xóa: ");
                               String id = scanner.nextLine().toUpperCase();
                               boolean found = false;
                               for (int i = 0; i < countemployees; i++) {
                                   if (employees[i].getEmployeeId().equalsIgnoreCase(id)) {
                                       for (int j = i; j < countemployees - 1; j++) {
                                           employees[j] = employees[j + 1];
                                       }
                                       employees[countemployees - 1] = null;
                                       countemployees--;
                                       System.out.println("Xóa thành công nhân viên có ID: " + id);
                                       found = true;
                                       break;
                                   }
                               }
                               if (!found) {
                                   System.out.println("Không tìm thấy nhân viên với ID: " + id);
                               }

                                   break;
                           case 5:
                               System.out.print("Nhập tên nhân viên cần tìm: ");
                               String keyword = scanner.nextLine().toLowerCase();

                               boolean found2 = false;
                               for (int i = 0; i < countemployees; i++) {
                                   if (employees[i] == null) continue;
                                   if (employees[i].getEmployeeName().toLowerCase().contains(keyword.toLowerCase())) {
                                       System.out.println(employees[i]);
                                       found2 = true;
                                   }
                               }

                               if (!found2) {
                                   System.out.println("Không tìm thấy nhân viên nào khớp với: " + keyword);
                               }

                           break;
                           case 6:
                               int chose;
                               System.out.println("Chọn cách sắp xếp:\n1. Tăng dần\n2. Giảm dần");
                               chose = Integer.parseInt(scanner.nextLine());
                               if (chose == 1) {
                                   for (int i = 0; i < countemployees - 1; i++) {
                                       for (int j = 0; j < countemployees - i - 1; j++) {
                                           if (employees[j].getSalary() > employees[j + 1].getSalary()) {
                                               Employee temp = employees[j];
                                               employees[j] = employees[j + 1];
                                               employees[j + 1] = temp;
                                           }
                                       }
                                   }
                                   System.out.println("Lương sau khi sắp xếp tăng dần:");
                                   for (int i = 0; i < countemployees; i++) {
                                       employees[i].displayData();
                                   }
                                   System.out.println();
                                   System.out.println("Đã sắp xếp tăng dần");

                               } else if (chose == 2) {
                                   for (int i = 0; i < countemployees - 1; i++) {
                                       for (int j = 0; j < countemployees - i - 1; j++) {
                                           if (employees[j].getSalary() < employees[j + 1].getSalary()) {
                                               Employee temp = employees[j];
                                               employees[j] = employees[j + 1];
                                               employees[j + 1] = temp;
                                           }
                                       }
                                   }
                                   System.out.println("Lương sau khi sắp xếp giảm dần:");
                                   for (int i = 0; i < countemployees; i++) {
                                       employees[i].displayData();
                                   }
                                   System.out.println();
                                   System.out.println("Đã sắp xếp giảm dần");
                               }
                               break;
                           case 7:
                               System.out.println("Thống kê số nhân viên đã tạo");
                               System.out.println("Tổng số nhân viên (bao gồm có sẵn và do user tạo): " + getTotalEmployees());
                               System.out.println("Tổng số nhân viên do người dùng tạo: " + getTotalEmployeeCreatedByUser());
                               break;
                           case 8:
                               System.out.print("Nhập ID nhân viên cần xóa: ");
                               String id1 = scanner.nextLine().toUpperCase();
                               boolean found1 = false;
                               for (int i = 0; i < countemployees; i++) {
                                   if (employees[i].getEmployeeId().equalsIgnoreCase(id1)) {
                                       for (int j = i; j < countemployees - 1; j++) {
                                           employees[j] = employees[j + 1];
                                       }
                                       removeEmployeeFromAllProjects(id1);
                                       employees[countemployees - 1] = null;
                                       countemployees--;
                                       System.out.println("Đã Xóa thành công nhân viên có ID:" + id1 + "khỏi toàn bộ system" );
                                       found1 = true;
                                       break;
                                   }

                                   }
                               if (!found1) {
                                   System.out.println("Không tìm thấy nhân viên với ID: " + id1);
                               }
                               break;
                           case 9:
                               System.out.println("Thoát chương trình");
                               break;
                           default:
                               System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                       }
                   }  while (choice != 9);
                   break;
                    }
                    case 2: {
                        int choice;
                        do {
                            MenuProject();
                            System.out.println("Lựa chọn của bạn: ");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    System.out.println("Thêm dự án mới");
                                    int n ;
                                    System.out.println("Nhập số lượng dự án muốn thêm: ");
                                    n = Integer.parseInt(scanner.nextLine());
                                    for (int i = 0; i < n; i++) {
                                        System.out.printf("--- Nhập thông tin dự án thứ %d ---\n", i + 1);
                                        Project newproject = new Project();
                                        newproject.inputData(scanner,projects,countprojects);
                                        projects[countprojects] = newproject;
                                        countprojectsbyuser++;
                                        countprojects++;
                                        if (countemployees == 0) {
                                            System.out.println("Không có nhân viên trong hệ thống. Vui lòng thêm nhân viên (Menu Nhân Viên) trước khi thêm vào dự án.");
                                        } else {
                                            System.out.print("Bạn có muốn thêm nhân viên vào dự án ngay bây giờ? (y/n): ");
                                            String ans = scanner.nextLine().toUpperCase();
                                            if (ans.equalsIgnoreCase("y")) {
                                                newproject.inputDSEmployeeJoin(scanner, employees, countemployees);
                                            }
                                        }

                                    }
                                    System.out.printf("Đã thêm %d dự án thành công!\n", n);
                                    break;
                                case 2:
                                    System.out.println("Hiển thị danh sách dự án");
                                    if (countprojects == 0) {
                                        System.out.println("Chưa có dự án nào.");
                                        return;
                                    } else {
                                        System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(14), "-".repeat(14), "-".repeat(12));
                                        System.out.printf("| %-6s | %-24s | %-12s | %-12s | %-10s |\n", "ID", "Tên Dự Án", "Ngày BĐ", "Ngày KT", "Trạng Thái");
                                        System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(14), "-".repeat(14), "-".repeat(12));
                                        for (int i = 0; i < countprojects; i++) {
                                            projects[i].displayData();
                                        }
                                        System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(8), "-".repeat(26), "-".repeat(14), "-".repeat(14), "-".repeat(12));
                                    }
                                    break;
                                case 3:
                                    System.out.print("Nhập mã dự án cần cập nhật: ");
                                    String updatePId = scanner.nextLine().toUpperCase();
                                    boolean foundUpdate = false;
                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i].getProjectId().equals(updatePId)) {
                                            projects[i].inputData(scanner, projects, countprojects);
                                            projects[i].setProjectId(updatePId);
                                            System.out.println("Đã cập nhật thành công cho dự án có Id: " + updatePId);
                                            showListProjectWithEmployees();
                                            foundUpdate = true;
                                            break;
                                        }
                                    }
                                    if (!foundUpdate) {
                                        System.out.println("Không tìm thấy dự án với Id" + updatePId);
                                    }
                                    break;
                                case 4:
                                    System.out.print("Nhập mã dự án cần xóa: ");
                                    String projectId = scanner.nextLine().toUpperCase();
                                    int idx = -1;
                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i] != null && projects[i].getProjectId().equalsIgnoreCase(projectId)) {
                                            idx = i;
                                            break;
                                        }
                                    }

                                    if (idx == -1) {
                                        System.out.println("Không tìm thấy dự án: " + projectId);
                                    } else {
                                        Employee[] list = projects[idx].getEmployees();
                                        int empCount = (list == null) ? 0 : list.length;

                                        System.out.println("Dự án " + projects[idx].getProjectId() + " có " + empCount + " nhân viên.");
                                        if (empCount > 0) {
                                            System.out.println("Không thể xóa. Dự án "+ projects[idx].getProjectId() + " đang có " + empCount + " nhân viên tham gia.");
                                        } else {
                                            System.out.print("Bạn có chắc muốn xóa dự án này không? (y/n): ");
                                            String ans = scanner.nextLine().toUpperCase();
                                            if (ans.equalsIgnoreCase("y")) {
                                                for (int j = idx; j < countprojects - 1; j++) {
                                                    projects[j] = projects[j + 1];
                                                }
                                                projects[countprojects - 1] = null;
                                                countprojects--;
                                                System.out.println("Xóa dự án thành công: " + projectId);
                                            } else {
                                                System.out.println("Hủy xóa.");
                                            }
                                        }
                                    }


                                    break;
                                case 5:
                                    System.out.println("Nhập mã dự án cần thêm nhân viên: ");
                                    String projId = scanner.nextLine().toUpperCase();
                                    boolean foundAdd = false;

                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i] != null && projects[i].getProjectId().equals(projId)) {
                                            projects[i].inputDSEmployeeJoin(scanner, employees, countemployees);
                                            System.out.println("Đã thêm nhân viên vào dự án thành công : " );
                                            showListProjectWithEmployees();
                                            foundAdd = true;
                                            break;
                                        }
                                    }

                                    if (!foundAdd) {
                                        System.out.println("Không tìm thấy dự án!");
                                    }
                                break;
                                case 6:
                                    System.out.print("Nhập tên dự án cần tìm: ");
                                    String keyword1 = scanner.nextLine().toLowerCase();
                                    boolean found4 = false;
                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i] == null) continue;
                                        if (projects[i].getProjectName().toLowerCase().contains(keyword1.toLowerCase())) {
                                            System.out.println(projects[i]);
                                            found4 = true;
                                        }
                                    }

                                    if (!found4) {
                                        System.out.println("Không tìm thấy dự án nào khớp với: " + keyword1);
                                    }
                                    break;
                                case 7:
                                    System.out.print("Nhập mã dự án: ");
                                    String inputId = scanner.nextLine().toUpperCase();
                                    boolean foundProj = false;

                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i].getProjectId().equalsIgnoreCase(inputId)) {
                                            foundProj = true;
                                            System.out.println("Dự án: " + projects[i].getProjectName());

                                            for (Role r : Role.values()) {
                                                int count = 0;
                                                Employee[] listEmp = projects[i].getEmployees();
                                                if (listEmp != null) {
                                                    for (int j = 0; j < listEmp.length; j++) {
                                                        if (listEmp[j] != null && listEmp[j].getRole() == r) {
                                                            count++;
                                                        }
                                                    }
                                                }
                                                System.out.println("Vai trò " + r + ": " + count + " nhân viên");
                                            }
                                                break;
                                                }
                                            } if (!foundProj) {
                                        System.out.println("Không tìm thấy dự án với Id: " + inputId);
                                           }
                                            break;
                                case 8:
                                    if (countprojects == 0) {
                                        System.out.println("Chưa có dự án nào.");
                                        break;
                                    }
                                    Project nearest = null;

                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i] != null && projects[i].getStatus() == Status.RUNNING && projects[i].getEndDate() != null) {
                                            if (nearest == null || projects[i].getEndDate().isBefore(nearest.getEndDate())) {
                                                nearest = projects[i];
                                            }
                                        }
                                    }

                                    if (nearest == null) {
                                        System.out.println("Không có dự án đang chạy hoặc không có dự án nào gần kết thúc.");
                                    } else {
                                        System.out.println("Dự án đang chạy và gần kết thúc nhất:");
                                        nearest.displayData();
                                        System.out.println("Ngày kết thúc: " + nearest.getEndDate());
                                    }
                                    break;
                                case 9:
                                    System.out.print("Nhập mã dự án: ");
                                    String pId = scanner.nextLine();

                                    Project foundProject = null;
                                    for (int i = 0; i < countprojects; i++) {
                                        if (projects[i].getProjectId().equalsIgnoreCase(pId)) {
                                            foundProject = projects[i];
                                            break;
                                        }
                                    }

                                    if (foundProject == null) {
                                        System.out.println("Không tìm thấy dự án!");
                                        break;
                                    }

                                    System.out.print("Nhập mã nhân viên cần xóa khỏi dự án: ");
                                    String empId = scanner.nextLine();

                                    removeEmployeeFromProject(foundProject, empId);
                                break;
                                case 10:
                                    System.out.println("Thống kê số dự án đã tạo");
                                    System.out.println("Tổng số dự án (bao gồm có sẵn và do user tạo): " + getTotalProjects());
                                    System.out.println("Tổng số dự án do người dùng tạo: " + getTotalProejectCreatedByUser());
                                    break;
                                case 11:
                                    System.out.println("Thoát chương trình");
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                            }
                        }  while (choice != 11);
                        break;
                    }
                    case 3: {
                        System.out.println("Thoát chương trình");
                        System.exit(0);
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choose != 3);

    }
}
