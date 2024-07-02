import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {

    private final Employee[] workers = new Employee[10];

    public boolean addWorker(String firstName, String lastName, String additiveName, double monthSalary, int department) {

        if (getCount() < 10) {
            for (int i = 0; i < workers.length - 1; i++) {
                if (workers[i] == null) {
                    workers[i] = new Employee(firstName, lastName, additiveName, monthSalary, department);
                    return true;
                }
            }
        } else {
            System.out.println("Количество сотрудников превышено!");
        }
        return false;
    }

    public boolean deleteWorker(int id) {
        for (int i = 0; i < workers.length - 1; i++) {
            if (workers[i].getId() == id) {
                workers[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getWorker(int id) {
        for (Employee employee : workers) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee getWorker(String firstName, String lastName, String additiveName, double monthSalary, int department) {
        for (Employee employee : workers) {
            if (employee != null && (employee.getFirstName().equals(firstName) || firstName == null) &&
                    (employee.getLastName().equals(lastName) || lastName == null) &&
                    (employee.getAdditiveName().equals(additiveName) || additiveName == null) &&
                    (employee.getMonthSalary() == monthSalary || monthSalary == -1) &&
                    (employee.getDepartment() == department || department == -1)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        int count = 0;
        for (Employee employee : workers) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public double getSalaryAverage() {
        double salaryAverage = 0;
        int count = 0;
        for (Employee employee : workers) {
            salaryAverage += employee.getMonthSalary();
            count++;
        }
        return salaryAverage / count;
    }

    public  double getSalaryMax() {
        double salaryMax = 0;
        for (Employee employee : workers) {
            if (employee.getMonthSalary() > salaryMax) {
                salaryMax = employee.getMonthSalary();
            }
        }
        return salaryMax;
    }

    public double getSalaryMin() {
        double salaryMin = workers[0].getMonthSalary();
        for (Employee employee : workers) {
            if (employee.getMonthSalary() < salaryMin) {
                salaryMin = employee.getMonthSalary();
            }
        }
        return salaryMin;
    }

    public double getSalarySum() {
        double salarySum = 0;
        for (Employee employee : workers) {
            salarySum += employee.getMonthSalary();
        }
        return salarySum;

    }

    @Override
    public String toString() {
        String result = "";
        for (Employee employee: workers) {
           if(employee != null) result = result.concat(employee.toString() + "\r\n");
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Objects.deepEquals(workers, that.workers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(workers);
    }
}
