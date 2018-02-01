package jaworskg.spring.microservices.converter.controllers;

import jaworskg.spring.microservices.converter.proxies.ForexServiceProxy;
import jaworskg.spring.microservices.converter.response.CurrencyConversionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private static Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private ForexServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrency(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionResponse> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:9001/currency-exchange/from/{from}/to/{to}", CurrencyConversionResponse.class, uriVariables);
        CurrencyConversionResponse response = responseEntity.getBody();
        return new CurrencyConversionResponse(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrencyFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        CurrencyConversionResponse response = proxy.retrieveExchangeValue(from, to);
        LOGGER.info("{}", response);
        return new CurrencyConversionResponse(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

}