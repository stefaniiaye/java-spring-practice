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
            int decimal = Integer.parseInt(String.valueOf(num), currBase);

            String result = Integer.toString(decimal, base);

            String binRes = Integer.toBinaryString(decimal);
            String octRes = Integer.toOctalString(decimal);
            String hexRes = Integer.toHexString(decimal);

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
}
