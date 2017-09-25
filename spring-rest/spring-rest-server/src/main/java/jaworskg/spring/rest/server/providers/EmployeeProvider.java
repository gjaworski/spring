package jaworskg.spring.rest.server.providers;

import jaworskg.spring.rest.server.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeProvider {

    private final List<Employee> employees;

    public EmployeeProvider(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
