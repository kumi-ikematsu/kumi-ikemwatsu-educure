public class Main4 {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        try {
            // 学生を5人追加
            manager.addStudent("アリス");
            manager.addStudent("ボブ");
            manager.addStudent("チャーリー");
            manager.addStudent(null);
            manager.addStudent("デイブ");

            // 6人目追加（エラー）
            manager.addStudent("エマ");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("学生ID 2: " + manager.getStudent(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("学生ID 3: " + manager.getStudent(3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("学生ID 10: " + manager.getStudent(10));
        } catch (Exception e) {
            System.out.println("エラー: 無効な学生IDです: 10");
        }

        try {
            manager.updateStudent(1, "ボビー");
            System.out.println("更新後の学生ID 1: " + manager.getStudent(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.updateStudent(10, "ジョン");
        } catch (Exception e) {
            System.out.println("エラー: 無効な学生IDです: 10");
        }
    }
}