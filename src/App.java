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
        System.out.println(bookWorkers);

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
