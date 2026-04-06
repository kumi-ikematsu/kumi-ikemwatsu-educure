public class UserProfileForm {

    private String name;
    private int age;
    private String bio;

    public UserProfileForm() {}

    public UserProfileForm(String name, int age, String bio) {
        this.name = name;
        this.age = age;
        this.bio = bio;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
}
