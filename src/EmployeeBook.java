import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {

    private final Employee[] workers = new Employee[10];

    public boolean addWorker(String firstName, String lastName, String additiveName, double monthSalary, int department) {

        if (getCount() < 10) {
            for (int i = 0; i < workers.length; i++) {
                if (workers[i] == null) {
                    workers[i] = new Employee(firstName, lastName, additiveName, monthSalary, department);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteWorker(int id) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getId() == id) {
                workers[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getWorker(int id) {
        for (Employee employee : workers) {
            if (employee != null && employee.getId() == id) {
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

    public int getCount(int department) {
        int count = 0;
        for (Employee employee : workers) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }

    public int getCountDepartments() {
        int departments = 0;
        for (Employee employee : workers) {
            if (employee != null &&
                    employee.getDepartment() > departments) {
                departments = employee.getDepartment();
            }
        }
        return departments;
    }

    public void increaseSalary(int department, int percent) {
        for (int i = 0; i <= workers.length - 1; i++) {
            if (workers[i] != null && (workers[i].getDepartment() == department || department <= 0)) {
                double incMonthSalary = workers[i].getMonthSalary() * ( (double) percent / 100);
                workers[i].setMonthSalary(workers[i].getMonthSalary() +incMonthSalary);
            }
        }
    }

    public double getSalaryAverage(int department) {
        double salaryAverage = 0;
        int count = 0;
        for (Employee employee : workers) {
            if (employee != null && (employee.getDepartment() == department || department <= 0)) {
                salaryAverage += employee.getMonthSalary();
                count++;
            }
        }
        return salaryAverage / count;
    }


    public double getSalaryMax(int department) {
        double salaryMax = 0;
        for (Employee employee : workers) {
            if (employee != null && (employee.getDepartment() == department || department <= 0) &&
                    employee.getMonthSalary() > salaryMax) {
                salaryMax = employee.getMonthSalary();
            }
        }
        return salaryMax;
    }

    public Employee getWorkerWithMaxSalary(int department) {
        Employee workerSalaryMax = null;
        double salaryMax = 0;
        for (Employee employee : workers) {
            if (employee != null && (employee.getDepartment() == department || department <= 0)
                    && employee.getMonthSalary() > salaryMax) {
                salaryMax = employee.getMonthSalary();
                workerSalaryMax = employee;
            }
        }
        return workerSalaryMax;
    }

    public double getSalaryMin(int department) {
        double salaryMin = getSalaryMax(-1);
        for (Employee employee : workers) {
            if (employee != null && (employee.getDepartment() == department || department <= 0)
                    && employee.getMonthSalary() <= salaryMin) {
                salaryMin = employee.getMonthSalary();
            }
        }
        return salaryMin;
    }

    public Employee getWorkerWithMinSalary(int department) {
        Employee workerSalaryMin = null;
        double salaryMin = getSalaryMax(department);
        for (Employee employee : workers) {
            if (employee != null && (employee.getDepartment() == department || department <= 0)
                    && employee.getMonthSalary() <= salaryMin) {
                salaryMin = employee.getMonthSalary();
                workerSalaryMin = employee;
            }
        }
        return workerSalaryMin;
    }


    public double getSalarySum(int department) {
        double salarySum = 0;
        for (Employee employee : workers) {
            if (employee != null && (employee.getDepartment() == department || department <= 0)) {
                salarySum += employee.getMonthSalary();
            }
        }
        return salarySum;

    }

    @Override
    public String toString() {
        String result = "";
        for (Employee employee : workers) {
            if (employee != null) {
                result = result.concat(employee + "\r\n");
            }
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
