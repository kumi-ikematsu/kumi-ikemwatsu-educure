import java.util.Objects;

public class Student {

    private int id;       // 学籍番号
    private String name;  // 氏名

    // コンストラクタ
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // equalsのオーバーライド
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Student student = (Student) obj;

        return id == student.id;
    }
}