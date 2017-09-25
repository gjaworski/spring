package jaworskg.spring.rest.server;

import jaworskg.spring.rest.server.model.Address;
import jaworskg.spring.rest.server.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "Grzegorz", "Jaworski", 31, new Address("Gdańsk", "Grunwaldzka", 607, "80-337")),
                new Employee(2, "Adam", "Nowicki", 31, new Address("Gdańsk", "Bulońska", 607, "83-111")),
                new Employee(3, "Maciej", "Nowak", 30, new Address("Bydgoszcz", "Fordońska", 500, "85-666")));
    }

}
