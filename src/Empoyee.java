import java.util.Objects;

public class Empoyee {
    private FullName fullName;
    private int department;
    private int salary;
    private int id;
    private static int counter;

    public FullName getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empoyee empoyee = (Empoyee) o;
        return department == empoyee.department && salary == empoyee.salary && id == empoyee.id && Objects.equals(fullName, empoyee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Empoyee(FullName fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = ++counter;


    }
}
