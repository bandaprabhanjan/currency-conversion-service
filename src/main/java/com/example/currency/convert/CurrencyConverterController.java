package com.example.currency.convert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConverterController {
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	@RequestMapping(path = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public CurrencyConvertBean convertcurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConvertBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8084/currency-exchange/from/{from}/to/{to}", CurrencyConvertBean.class, uriVariables);

		CurrencyConvertBean response = responseEntity.getBody();
		System.out.println("Content Type:" + responseEntity.getHeaders().getContentType());
		CurrencyConvertBean CurrencyConvertBean = new CurrencyConvertBean(response.getId(), from, to,
				response.getconvertMultiple(), quantity, quantity.multiply(response.getconvertMultiple()),
				response.getPort());

		if (CurrencyConvertBean.getconvertMultiple() == null)
			throw new ConvertMultipleExcception("ConvertMultiple");

		return CurrencyConvertBean;

	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertBean convertcurrencyfeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConvertBean response = proxy.retrieveExchangeValue(from, to);
		CurrencyConvertBean CurrencyConvertBean = new CurrencyConvertBean(response.getId(), from, to,
				response.getconvertMultiple(), quantity, quantity.multiply(response.getconvertMultiple()),
				response.getPort());

		return CurrencyConvertBean;
	}

	@PostMapping("/currency-converter-feign")
	public CurrencyConvertBean postMapTest(@Valid @RequestBody CurrencyConvertBean ccb) {
		return ccb;

	}
}
