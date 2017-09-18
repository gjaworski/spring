package jaworskg.spring.rest.server.controllers;

import jaworskg.spring.rest.server.model.Employee;
import jaworskg.spring.rest.server.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@RequestParam(name = "id") int employeeId) {
        LOGGER.info("Retrieving employee");
        return ResponseEntity.ok(employeeService.findEmployeeById(employeeId));
    }

}
