public class RegularEmployee extends Employee {

    private int baseSalary;

    public RegularEmployee(String name, int baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public String getRole() {
        return "正社員";
    }

    @Override
    public int calculateSalary() {
        return baseSalary;
    }
}