import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;
    private static int counter;

    public String getFullName() {
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
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fullName, employee.fullName);
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

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = ++counter;
    }

    @Override
    public String toString() {
        return "ФИО сотрудника: " + getFullName() + ", отдел: " + getDepartment() + ", заработная плата: " + getSalary() + ", номер id: " + getId();
    }

    public static void printListEmployee(Employee[] employee) {          //Метод получения списка всех сотрудников и их данных
        if (employee == null || employee.length == 0) {                 //Проверка условия на пустой массив или null
            throw new IllegalArgumentException("Массив пуст или null");
        }
        for (int i = 0; i < employee.length; i++) {
            System.out.println("employee[" + i + "] = " + employee[i]);
        }
    }

    public static int countSumSalaryEmployee(Employee[] employee) {     //Метод подсчета суммы затрат на зарплаты работникам
        if (employee == null || employee.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int sumSalary=0;
        for (int i = 0; i < employee.length; i++) {
            sumSalary = sumSalary + employee[i].getSalary();
        }
        return sumSalary;
    }

    public static int findMinSalary(Employee[] employee) {      //Метод поиска минимальной зп
        if (employee == null || employee.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int minSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < minSalary) {
                minSalary = employee[i].getSalary();
            }
        }
        return minSalary;
    }

    public static String findEmployeeWithMinSalary(Employee[] employee) {   //Метод поиска работника с минимальной зп
        if (employee == null || employee.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        String a = "";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == findMinSalary(employee)) {
                a = employee[i].getFullName();
            }
        }
        return a;
    }

    public static int findMaxSalary(Employee[] employee) {      //Метод поиска максимальной зп
        if (employee == null || employee.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int maxSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > maxSalary) {
                maxSalary = employee[i].getSalary();
            }
        }
        return maxSalary;

    }

    public static String findEmployeeWithMaxSalary(Employee[] employee) {   //Метод поиска работника с максимальной зп
        if (employee == null || employee.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        String a = "";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == findMaxSalary(employee)) {
                a = employee[i].getFullName();
            }
        }
        return a;
    }

    public static int countAverageSumSalaryEmployee(Employee[] employee) {
        int average = countSumSalaryEmployee(employee) / employee.length;
        return average;
    }

    public static void printFullNameEmployee(Employee[] employee) {     //Метод печати ФИО всех работников
        if (employee == null || employee.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        for (int i = 0; i < employee.length; i++) {
            System.out.println("employee[" + i + "] = " + employee[i].getFullName());
        }
    }

}
