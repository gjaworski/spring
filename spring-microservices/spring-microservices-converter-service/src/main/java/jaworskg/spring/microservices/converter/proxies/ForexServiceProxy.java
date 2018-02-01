package jaworskg.spring.microservices.converter.proxies;


import jaworskg.spring.microservices.converter.response.CurrencyConversionResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RibbonClient(name = "forex-service")
@FeignClient(name = "forex-service")
public interface ForexServiceProxy {

    @RequestMapping(method = GET, value = "/currency-exchange/from/{from}/to/{to}")
        //@GetMapping("/currency-exchange/from/{from}/to/{to}") - not supported
    CurrencyConversionResponse retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
