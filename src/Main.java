public class Main {


    private static Employee[] employee = new Employee[10];

    public static void main(String[] args) {
        employee[0] = new Employee("Иванов Олег Артемович", 1, 85000);
        employee[1] = new Employee("Попов Арсений Борисович", 3, 100000);
        employee[2] = new Employee("Пикалов Виктор Григорьевич", 1, 68000);
        employee[3] = new Employee("Сидоров Михаил Анатольевич", 2, 110000);
        employee[4] = new Employee("Краснова Валерия Дмитреевна", 4, 80000);
        employee[5] = new Employee("Миронов Геннадий Мирославович", 1, 66000);
        employee[6] = new Employee("Андропов Владислав Егорович", 5, 77000);
        employee[7] = new Employee("Леонова Марина Викторовна", 5, 82000);
        employee[8] = new Employee("Смирнов Алексей Максимович", 2, 80000);
        employee[9] = new Employee("Новикова Елена Александровна", 4, 90000);

        Employee.printListEmployee(employee);
        System.out.println("Общая сумма затрат на зарплаты работников составляет: " + Employee.countSumSalaryEmployee(employee)); // Список всех сотрудников и их данных
        System.out.println("Минимальная зарплата работника составляет: " + Employee.findMinSalary(employee)); // Минимальная зп сотрудника
        System.out.println("Минимальная зарплата работника составляет: " + Employee.findMaxSalary(employee)); // Максимальная зп сотрудника
        System.out.println("Работник с минимальной зарплатой: " + Employee.findEmployeeWithMinSalary(employee));
        System.out.println("Работник с максимальной зарплатой: " + Employee.findEmployeeWithMaxSalary(employee));
        System.out.println("Средняя зарплата работника составляет: " + Employee.countAverageSumSalaryEmployee(employee));
        Employee.printFullNameEmployee(employee);
    }
}