import com.google.gson.Gson;
import java.io.FileReader;

public class Main4 {
    public static void main(String[] args) {

        try {
            Gson gson = new Gson();

            FileReader reader = new FileReader("exercise.json");

            Employee emp = gson.fromJson(reader, Employee.class);

            System.out.println("名前: " + emp.getName());
            System.out.println("年齢: " + emp.getAge());
            System.out.println("給与: " + emp.getSalary());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}