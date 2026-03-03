public class Main3 {
    public static void main(String[] args) {

        Employee emp1 = new RegularEmployee("山田", 350000);
        Employee emp2 = new PartTimeEmployee("鈴木", 1000, 120);

        System.out.println(emp1.getRole() + "（" + emp1.getName() + "）の給与: " + emp1.calculateSalary() + "円");
        System.out.println(emp2.getRole() + "（" + emp2.getName() + "）の給与: " + emp2.calculateSalary() + "円");
    }
}