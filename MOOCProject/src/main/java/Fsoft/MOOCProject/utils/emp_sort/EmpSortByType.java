package Fsoft.MOOCProject.services.employee_services.emp_sort;

import Fsoft.MOOCProject.entities.model.Employee;

import java.util.Comparator;

public class EmpSortByType implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
