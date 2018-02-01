package jaworskg.spring.microservices.converter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("jaworskg.spring.microservices.converter.proxies")
@EnableDiscoveryClient
public class ConverterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConverterServiceApplication.class, args);
    }

}