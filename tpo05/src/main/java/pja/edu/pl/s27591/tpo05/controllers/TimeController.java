package pja.edu.pl.s27591.tpo05.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/current-time")
    @ResponseBody
    public String currentTime(@RequestParam(required = false, defaultValue = "hh:mm:ss.SSSS YYYY/MM/dd") String format,
                              @RequestParam(required = false, defaultValue = "CET")String timeZone){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date();

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        return "<h2> Current Time: </h2>\n " + simpleDateFormat.format(date);
    }

    @GetMapping("/current-year")
    @ResponseBody
    public String currentYear(){
        Calendar calendar = Calendar.getInstance();
        return "<h2> Current Year: </h2>" + "<h3>" + String.valueOf(calendar.get(Calendar.YEAR)) + "</h3>";
    }

}
