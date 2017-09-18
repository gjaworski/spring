package jaworskg.spring.rest;

import jaworskg.spring.rest.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "Grzegorz", "Jaworski", 31),
                new Employee(2, "Adam", "Nowicki", 31),
                new Employee(3, "Maciej", "Nowak", 30));
    }

}
