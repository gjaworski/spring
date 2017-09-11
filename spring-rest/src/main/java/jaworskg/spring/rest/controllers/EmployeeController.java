package jaworskg.spring.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jaworskg.spring.rest.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final List<Employee> employees;

    public EmployeeController(List<Employee> employees) {
        this.employees = employees;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@RequestParam(name = "id") int employeeId) {
        LOGGER.info("Retrieving employee");
        return employees.stream()
                .filter(employee -> employeeId == employee.getId())
                .map(ResponseEntity::ok)
                .findAny()
                .orElseThrow(() -> new RuntimeException(String.format("Missing employee with id: %d", employeeId)));
    }

}
