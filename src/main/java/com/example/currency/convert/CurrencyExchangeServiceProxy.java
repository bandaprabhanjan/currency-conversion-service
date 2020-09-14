package com.example.currency.convert;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currencyExchange",url="localhost:8086")
//@FeignClient(name = "currencyExchange")
@FeignClient(name = "netflix-zuul-api-gateway")
@RibbonClient(name = "currencyExchange")
public interface CurrencyExchangeServiceProxy {
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currencyexchange/currency-exchange/from/{from}/to/{to}")
	public CurrencyConvertBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}

//zuul uses the application name in the url to talk to Eureka and find the URL of the service.
//In above example "currencyexchange" is the application name and here we are intercepting a request after c
//whenever we are calling the currency converter service through feign the request is being routed through API gateway
//then that api gateway is executing the logging filter and invoking the currecy exchange service
//means the service call is not directly going thorugh currency exchange service
