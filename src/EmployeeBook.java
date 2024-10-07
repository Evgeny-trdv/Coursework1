public class EmployeeBook {

    private final Employee[] employees = new Employee[10];
    private int size;


    public void printListEmployee() {          //Метод получения списка всех сотрудников и их данных
        for (int i = 0; i < employees.length; i++) {
            System.out.println("employee[" + i + "] = " + employees[i]);
        }
    }

    public int countSumSalaryEmployees() {     //Метод подсчета суммы затрат на зарплаты работникам
        int sumSalary = 0;
        for (int i = 0; i < (size); i++) {
            sumSalary = sumSalary + employees[i].getSalary();
        }
        return sumSalary;
    }

    public Employee findEmployeeMinSalary() {  //Поиск работника с минимальной зарплатой
        Employee result = null;
        if (size > 0) {
            int minSalary = employees[0].getSalary();
            for (int i = 0; i < (size); i++) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public Employee findEmployeeMaxSalary() {  //Поиск работника с максимальной зарплатой
        Employee result = null;
        if (size > 0) {
            int maxSalary = employees[0].getSalary();
            for (int i = 0; i < (size); i++) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public int countAverageSumSalaryEmployees() {     //средняя зп работников
        int average = countSumSalaryEmployees() / (size);
        return average;
    }

    public void printFullNameEmployees() {     //Метод печати ФИО всех работников
        for (int i = 0; i < (size); i++) {
            System.out.println("employee[" + i + "] = " + employees[i].getFullName());
        }
    }


    public void indexSalary(double index) {      // метод индексации зарплат всех работников
        double percentIncrease = 1 + (index / 100);
        for (int i = 0; i < (size); i++) {
            employees[i].setSalary((int) (employees[i].getSalary() * percentIncrease));
        }
    }

    public Employee findMinSalaryInDepartment(int department) {        //метод поиска минимальной зп в определенном отделе
        Employee result = null;
        if (size > 0) {
            int minSalary = employees[0].getSalary();
            for (int i = 0; i < (size); i++) {
                if (employees[i].getDepartment() == department && employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public Employee findMaxSalaryInDepartment(int department) {        //метод поиска минимальной зп в определенном отделе
        Employee result = null;
        if (size > 0) {
            int maxSalary = employees[0].getSalary();
            for (int i = 0; i < (size); i++) {
                if (employees[i].getDepartment() == department && employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public int countSumSalaryInDepartment(int department) {     //Метод подсчета суммы затрат на зарплаты работникам
        int sumSalary = 0;
        for (int i = 0; i < (size); i++) {
            if (employees[i].getDepartment() == department) {
                sumSalary += employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    public int findAverageSumSalaryEmployeesDepartment(int department) {     //средняя зп работников в отделе
        int count = 0;
        for (int i = 0; i < (size); i++) {
            if (employees[i].getDepartment() == department) {
                count += 1;
            }
        }
        int average = countSumSalaryInDepartment(department) / count;
        return average;
    }

    public void indexSalaryInDepartment(int department, double index) {      // метод индексации зарплат работников в отдельной отделе
        double percentIncrease = 1 + (index / 100);
        for (int i = 0; i < (size); i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary((int) (employees[i].getSalary() * percentIncrease));
            }
        }
    }

    public void printEmployeesInDepartment(int department) {     // метод печати всех сотрудников отдела (без печати номера отдела)
        for (int i = 0; i < (size); i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("employee[" + i + "] = ФИО: " + employees[i].getFullName() + ", заработная плата: " + employees[i].getSalary() + ", номер id: " + employees[i].getId());
            }
        }
    }

    public void printEmployeesWithSalaryLess(int sum) {  //метод выводы работников с зп меньше определенного
        for (int i = 0; i < (size); i++) {
            if (employees[i].getSalary() < sum) {
                System.out.println("employee[" + i + "] = " + employees[i]);
            }
        }
    }

    public void printEmployeesWithSalaryMore(int sum) {  //метод выводы работников с зп больше или равно определенному
        for (int i = 0; i < (size); i++) {
            if (employees[i].getSalary() >= sum) {
                System.out.println("employee[" + i + "] = " + employees[i]);
            }
        }
    }

    public boolean addEmployee(String fullName, int department, int salary) {  //метод добавления нового работника
        boolean result = false;
        if (size >= employees.length) {
            System.out.println("Места нет " + size);
        } else {
            Employee employee = new Employee(fullName, department, salary);
            employees[size++] = employee;
            System.out.println("В массиве есть место");
            result = true;
        }
        return result;
    }

    public boolean removeEmployee(int id) {    // метод удаления работника из массива
        boolean result = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                System.out.println(employees[i] + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return result = true;
            }
            if (id <= 0) {
                return result;
            }
        }
        return result;
    }

    public Employee getEmployeeById(int id) {
        Employee result = null;
        for (int i = 0; i < (size); i++) {
            if (employees[i].getId() == id) {
                result = employees[i];
                return result;
            }
        }
        return result;
    }

}

