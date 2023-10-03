package ra.run;

import ra.service.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement manager = new StudentManagement();
        while (true) {
            System.out.println("----------------StudentManagerment --------------");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Sửa học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Tìm kiếm học sinh theo studentId");
            System.out.println("5. Sắp xếp theo tên học sinh từ a-z");
            System.out.println("6. In ra danh sách học sinh");
            System.out.println("7. Sắp xếp điểm tăng dần");
            System.out.println("8. Sắp xếp điểm giảm dần");
            System.out.println("9. Thoát");
            System.out.println("Nhập vào lựa chọn của bạn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    System.out.println("Nhập studentId của học sinh bạn muốn sửa:");
                    int editId = scanner.nextInt();
                    manager.editStudent(editId);
                    break;
                case 3:
                    System.out.println("Nhập studentId của học sinh bạn muốn xóa:");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.println("Nhập studentId của học sinh bạn muốn tìm kiếm:");
                    int searchId = scanner.nextInt();
                    manager.searchStudentById(searchId);
                    break;
                case 5:
                    manager.sortByNameAZ();
                    break;
                case 6:
                    displayStudents();
                    break;
                case 7:
                    manager.diemTangDan();
                    break;
                case 8:
                    manager.diemGiamDan();
                    break;
                case 9:
                    System.out.println("Good Bye");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập 1 số từ 1 đến 9");
            }
        }
    }

    public static void displayStudents() {
        for (Student student : students) {
            student.display();
        }
    }

    public static void addStudent() {
        Student student = new Student();
        student.input();
        students.add(student);
    }

    public static void editStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.input();
                System.out.println("Thông tin học sinh đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có studentId: " + studentId);
    }

    public static void deleteStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                students.remove(student);
                System.out.println("Học sinh có studentId: " + studentId + " đã bị xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có studentId: " + studentId);
    }

    public void searchStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.display();
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có studentId: " + studentId);
    }

    public void sortByNameAZ() {
        Collections.sort(students, Comparator.comparing(Student::getStudentName));
    }

    public void diemTangDan() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMark));
    }

    public void diemGiamDan() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMark).reversed());
    }
}
