public class Main2 {

    public static void main(String[] args) {

        Student s1 = new Student(1, "田中");
        Student s2 = new Student(1, "佐藤");
        Student s3 = new Student(2, "山田");

        if (s1.equals(s2)) {
            System.out.println("同一の学生です");
        } else {
            System.out.println("違う学生です");
        }

        if (s1.equals(s3)) {
            System.out.println("同一の学生です");
        } else {
            System.out.println("違う学生です");
        }
    }
}