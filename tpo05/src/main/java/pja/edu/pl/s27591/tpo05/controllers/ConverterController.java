package pja.edu.pl.s27591.tpo05.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    @PostMapping("/converter")
    @ResponseBody
    public String convertNumber(
            @RequestParam int num,
            @RequestParam int currBase,
            @RequestParam int base
    )
    {
        try {
            int decimal = toDec(num, currBase);

            String result = fromDec(decimal, base);

            String binRes = fromDec(decimal, 2);
            String octRes = fromDec(decimal, 8);
            String hexRes = Integer.toHexString(decimal).toUpperCase();

            String output = "<h2>Result: " + result + "</h2>" +
                    "<h3>Additionally:</h3>" +
                    "<p>DEC: " + decimal + "</p>" +
                    "<p>BIN: " + binRes + "</p>" +
                    "<p>OCT: " + octRes + "</p>" +
                    "<p>HEX: " + hexRes + "</p>";

            return output;
        }catch (Exception e){
            e.printStackTrace();
            return "<h2>Oops, something went wrong:(\nPlease, try again.</h2>";
        }
    }

    private int toDec(int num, int base) {
        int decimal = 0;
        int power = 0;
        while (num > 0) {
            decimal += (int) ((num % 10) * Math.pow(base, power));
            num /= 10;
            power++;
        }
        return decimal;
    }

    private String fromDec(int decimal, int base) {
        if (decimal == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            result.insert(0, (decimal % base));
            decimal /= base;
        }
        return result.toString();
    }
}
