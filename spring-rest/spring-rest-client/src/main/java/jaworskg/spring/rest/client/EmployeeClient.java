package jaworskg.spring.rest.client;

import jaworskg.spring.rest.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;

@Component
public class EmployeeClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeClient.class);
    private static final String SERVER = "http://localhost:9001";

    @PostConstruct
    public void fetchEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        URI targetUrl = UriComponentsBuilder.fromUriString(SERVER)
                .path("/employees")
                .queryParam("id", 1)
                .build()
                .toUri();
        Employee employee = restTemplate.getForObject(targetUrl, Employee.class);
        LOGGER.info(employee.toString());
    }

}
