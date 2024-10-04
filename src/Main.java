public class Main {


    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Олег Артемович", 1, 85000);
        employees[1] = new Employee("Попов Арсений Борисович", 3, 100000);
        employees[2] = new Employee("Пикалов Виктор Григорьевич", 1, 68000);
        employees[3] = new Employee("Сидоров Михаил Анатольевич", 2, 110000);
        employees[4] = new Employee("Краснова Валерия Дмитреевна", 4, 80000);
        employees[5] = new Employee("Миронов Геннадий Мирославович", 1, 66000);
        employees[6] = new Employee("Андропов Владислав Егорович", 5, 77000);
        employees[7] = new Employee("Леонова Марина Викторовна", 5, 82000);
        employees[8] = new Employee("Смирнов Алексей Максимович", 2, 80000);
        employees[9] = new Employee("Новикова Елена Александровна", 4, 90000);

        printListEmployee();
        System.out.println("Общая сумма затрат на зарплаты работников составляет: " + countSumSalaryEmployees()); // Список всех сотрудников и их данных
        System.out.println("Работник с минимальной зарплатой: " + findEmployeeMinSalary().getFullName());
        System.out.println("Работник с максимальной зарплатой: " + findEmployeeMaxSalary());
        System.out.println("Средняя зарплата работников составляет: " + countAverageSumSalaryEmployees());
        printFullNameEmployees();
        indexSalary(5);
        System.out.println(employees[1]); // для демонстрации выполненого метода индексации зарплаты
        System.out.println("Работник с минимальной зарплатой из " + findMinSalaryInDepartment(2).getDepartment() + " отдела: " + findMinSalaryInDepartment(2).getFullName());
        System.out.println("Работник с максимальной зарплатой из " + findMaxSalaryInDepartment(4).getDepartment() + " отдела: " + findMaxSalaryInDepartment(4).getFullName());
        System.out.println("Общая сумма затрат на зарплаты работников в 1 отделе составляет: " +  + countSumSalaryInDepartment(1));
        System.out.println("Средняя зарплата во 2 отделе составляет: " + countAverageSumSalaryEmployeesDepartment(2));
        printEmployeesInDepartment(2);
        System.out.println("Работники с зарплатой меньше 80000");
        printEmployeesWithSalaryLess(80000);
        System.out.println("Работники с зарплатой больше или равно 105000");
        printEmployeesWithSalaryMore(105000);
    }

    public static void printListEmployee() {          //Метод получения списка всех сотрудников и их данных
        for (int i = 0; i < employees.length; i++) {
            System.out.println("employee[" + i + "] = " + employees[i]);
        }
    }

    public static int countSumSalaryEmployees() {     //Метод подсчета суммы затрат на зарплаты работникам
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            sumSalary = sumSalary + employees[i].getSalary();
        }
        return sumSalary;
    }

    public static Employee findEmployeeMinSalary() {  //Поиск работника с минимальной зарплатой
        Employee result = null;
        if (employees.length > 0) {
            int minSalary = employees[0].getSalary();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public static Employee findEmployeeMaxSalary() {  //Поиск работника с максимальной зарплатой
        Employee result = null;
        if (employees.length > 0) {
            int maxSalary = employees[0].getSalary();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public static int countAverageSumSalaryEmployees() {     //средняя зп работников
        int average = countSumSalaryEmployees() / employees.length;
        return average;
    }

    public static void printFullNameEmployees() {     //Метод печати ФИО всех работников
        for (int i = 0; i < employees.length; i++) {
            System.out.println("employee[" + i + "] = " + employees[i].getFullName());
        }
    }


    public static void indexSalary(double index) {      // метод индексации зарплат всех работников
        double percentIncrease = 1 + (index / 100);
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary((int) (employees[i].getSalary() * percentIncrease));
        }
    }

    public static Employee findMinSalaryInDepartment(int department) {        //метод поиска минимальной зп в определенном отделе
        Employee result = null;
        if (employees.length > 0) {
            int minSalary = employees[0].getSalary();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department && employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public static Employee findMaxSalaryInDepartment(int department) {        //метод поиска минимальной зп в определенном отделе
        Employee result = null;
        if (employees.length > 0) {
            int maxSalary = employees[0].getSalary();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department && employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public static int countSumSalaryInDepartment(int department) {     //Метод подсчета суммы затрат на зарплаты работникам
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sumSalary += employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    public static int countAverageSumSalaryEmployeesDepartment(int department) {     //средняя зп работников в отделе
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                count += 1;
            }
        }
        int average = countSumSalaryInDepartment(department) / count;
        return average;
    }

    public static void indexSalaryInDepartment(int department, double index) {      // метод индексации зарплат работников в отдельной отделе
        double percentIncrease = 1 + (index / 100);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary((int) (employees[i].getSalary() * percentIncrease));
            }
        }
    }

    public static void printEmployeesInDepartment(int department) {     // метод печати всех сотрудников отдела (без печати номера отдела)
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("employee[" + i + "] = ФИО: " + employees[i].getFullName() + ", заработная плата: " + employees[i].getSalary() + ", номер id: " + employees[i].getId());
            }
        }
    }

    public static void printEmployeesWithSalaryLess(int sum) {  //метод выводы работников с зп меньше определенного
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < sum) {
                System.out.println("employee[" + i + "] = " + employees[i]);
            }
        }
    }

    public static void printEmployeesWithSalaryMore(int sum) {  //метод выводы работников с зп больше или равно определенному
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= sum) {
                System.out.println("employee[" + i + "] = " + employees[i]);
            }
        }
    }
}