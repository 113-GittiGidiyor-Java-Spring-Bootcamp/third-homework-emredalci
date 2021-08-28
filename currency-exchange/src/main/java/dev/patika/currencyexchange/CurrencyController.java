package dev.patika.currencyexchange;

import com.sun.org.apache.xpath.internal.operations.Number;
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

    private static final double tl_usd = 8.36d;
    private static final double usd_tl = 0.12d;
    private static final Locale tl_local = new Locale("tr","TR");
    private static final Locale usd_local = new Locale("en","US");

    @GetMapping("/toTl")
    public ResponseEntity<String> convertTlToUsd(@RequestParam double quantity){
        //http://localhost:8081/currency/toTL?quantity=
        return ResponseEntity.ok(NumberFormat.getCurrencyInstance(tl_local).format(tl_usd*quantity));
    }

    @GetMapping("/toUSD")
    public ResponseEntity<String> convertUsdToTl(@RequestParam double quantity){
        return ResponseEntity.ok(NumberFormat.getCurrencyInstance(usd_local).format(usd_tl*quantity));
    }



}
