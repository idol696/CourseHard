public class App {
    public static void main(String[] args) {

        EmployeeBook bookWorkers = new EmployeeBook();
        initBook(bookWorkers);
        System.out.println(bookWorkers);
        // Далее идет проверка условий задачи - пытаемся вставить работника но не выходит, поэтому
        // ищем первого работника с фамилией "Познер", получаем его айди,
        // удаляем его и вставляем вместо него другого работника и проверяем рузультат
        // далее проверяем метод, попытавшись удалить по неправильному Id
        if (!addBookRecord(bookWorkers, "Вильгельмов", "Телль", "Уильямович", 15_000, 2)) {
            // обращаю внимание наставника что сотрудника можно получить и непосредственно Id, но в данном примере мы расширяем возможности
            // применяя фильтр и получаем по Ид сотрудника при удалении
            Employee searchResult = bookWorkers.getWorker("Познер", null, null, -1, -1);
            deleteBookRecord(bookWorkers,searchResult.getId());
            addBookRecord(bookWorkers, "Вильгельмов", "Телль", "Уильямович", 15_000, 2);
        }
        // удалим сотрудника по id 9 для теста ошибки null
        //bookWorkers.deleteWorker(9);
        System.out.println(bookWorkers);
        // зарплата по отделам увеличена на 10 процентов
        bookWorkers.increaseSalary(-1,10);
        // затем увеличим отделу 1 еще на 5%
        bookWorkers.increaseSalary(1,5);
        System.out.println(bookWorkers);
        printReportSalary(bookWorkers);
        printReportSalaryDepartment(bookWorkers);
    }

    public static void initBook(EmployeeBook bookWorkers) {
        bookWorkers.addWorker("Бабушкин", "Илья", "Андреевич", 10_000, 1);
        bookWorkers.addWorker("Мусинькин", "Игорь", "Петрович", 20_000, 2);
        bookWorkers.addWorker("Хазбулатов", "Виталий", "Насреддинов", 30_000, 3);
        bookWorkers.addWorker("Познер", "Иван", "Иванович", 40_000, 4);
        bookWorkers.addWorker("Волондемортов", "Исаакий", "Лепреконович", 50_000, 5);
        bookWorkers.addWorker("Дудина", "Ирина", "Игорьевна", 60_000, 2);
        bookWorkers.addWorker("Смактуновский", "Иннокентий", "Павлович", 70_000, 3);
        bookWorkers.addWorker("Бузинова", "Наталья", "Натальевна", 80_000, 2);
        bookWorkers.addWorker("Навеяло", "Навелий", "Навельевич", 90_000, 5);
        bookWorkers.addWorker("Прошкина", "Прасковья", "Пелевьевна", 100_000, 4);
    }

    public static void printReportSalaryDepartment(EmployeeBook bookWorkers) {

        for (int i = 1;i <=bookWorkers.getCountDepartments();i++) {
            if (bookWorkers.getCount(i) >0) {
                System.out.println("------Отдел № " + i);
                System.out.println("Сумма всех зарплат = " + bookWorkers.getSalarySum(i));
                System.out.println("Среднее всех зарплат = " + bookWorkers.getSalaryAverage(i));
                System.out.println("Минимальная из всех зарплат = " + bookWorkers.getSalaryMin(i));
                System.out.println("Максимальная из всех зарплат = " + bookWorkers.getSalaryMax(i));
                System.out.println("Сотрудник с максимальной зарплатой = " + bookWorkers.getWorkerWithMaxSalary(i));
                System.out.println("Сотрудник с минимальной зарплатой = " + bookWorkers.getWorkerWithMinSalary(i));
            }
        }
    }

    public static void printReportSalary(EmployeeBook bookWorkers) {
        System.out.println("Отчет по всей организации");
        System.out.println("Сумма всех зарплат = " + bookWorkers.getSalarySum(-1));
        System.out.println("Среднее всех зарплат = " + bookWorkers.getSalaryAverage(-1));
        System.out.println("Минимальная из всех зарплат = " + bookWorkers.getSalaryMin(-1));
        System.out.println("Максимальная из всех зарплат = " + bookWorkers.getSalaryMax(-1));
        System.out.println("Сотрудник с максимальной зарплатой = " + bookWorkers.getWorkerWithMaxSalary(-1));
        System.out.println("Сотрудник с минимальной зарплатой = " + bookWorkers.getWorkerWithMinSalary(-1));
    }

    public static boolean addBookRecord(EmployeeBook bookWorkers, String firstName, String lastName, String additiveName, double monthSalary, int department) {
        boolean result = bookWorkers.addWorker(firstName, lastName, additiveName, monthSalary, department);
        if (!result) {
            System.out.println("Количество сотрудников превышено!");
        }
        return result;
    }

    public static boolean deleteBookRecord(EmployeeBook bookWorkers, int id) {
        boolean result = bookWorkers.deleteWorker(id);
        if (!result) {
            System.out.println("Нечего удалять!");
        }
        return result;
    }

}
