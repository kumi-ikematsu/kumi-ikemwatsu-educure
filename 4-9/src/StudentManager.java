public class StudentManager {

    private String[] students = new String[5];
    private int count = 0;

    public void addStudent(String name) throws Exception {

        if (count >= students.length) {
            throw new Exception("エラー：これ以上学生を追加できません。リストがいっぱいです。");
        }

        students[count] = name;
        count++;
    }

    public String getStudent(int id) throws Exception {

        if (id < 0 || id >= students.length) {
            throw new Exception("エラー：無効な学生IDです: " + id);
        }

        if (students[id] == null) {
            throw new Exception("エラー：学生ID " + id + " にデータがありません");
        }

        return students[id];
    }

    public void updateStudent(int id, String name) throws Exception {

        if (id < 0 || id >= students.length) {
            throw new Exception("エラー：無効な学生IDです: " + id);
        }

        if (students[id] == null) {
            throw new Exception("エラー：学生ID " + id + " にデータがありません");
        }

        students[id] = name;
    }
}