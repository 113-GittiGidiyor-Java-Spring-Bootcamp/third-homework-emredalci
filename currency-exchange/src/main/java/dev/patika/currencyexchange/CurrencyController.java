package dev.patika.currencyexchange;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.util.Locale;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final double tl_usd = 10.0d;
    private static final Locale tl_local = new Locale("tr","TR");
    private static final Locale usd_local = new Locale("en","US");

    @GetMapping("/toTl")
    public ResponseEntity<String> convertTlToUsd(@RequestParam double quantity){
        //http://localhost:8081/currency/quantity?quantity=1000
        return ResponseEntity.ok(NumberFormat.getCurrencyInstance(tl_local).format(tl_usd*quantity));
    }



}
