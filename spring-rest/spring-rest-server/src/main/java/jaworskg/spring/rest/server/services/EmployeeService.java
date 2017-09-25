package jaworskg.spring.rest.server.services;

import jaworskg.spring.rest.server.providers.EmployeeProvider;
import jaworskg.spring.rest.server.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeProvider employeeProvider;

    public EmployeeService(EmployeeProvider employeeProvider) {
        this.employeeProvider = employeeProvider;
    }

    public Employee findEmployeeById(int employeeId) {
        return employeeProvider.getEmployees().stream()
                .filter(employee -> employee.getId() == employeeId)
                .findAny()
                .orElseThrow(() -> new RuntimeException(String.format("Missing employee with id: %d", employeeId)));
    }

}
