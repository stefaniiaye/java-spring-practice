package pjwstk.edu.pl.s27591.tpo06.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pjwstk.edu.pl.s27591.tpo06.model.FakeDataDTO;
import pjwstk.edu.pl.s27591.tpo06.model.FakeDataService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class FakeDataController {
    private final FakeDataService fakeDataService;
    private final Map<String, List<String>> headers;

    public FakeDataController(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
        this.headers = initHeaders();
    }

    @GetMapping("/generateFakeData")
    public String displayForm() {
        return "fakeDataGenerator";
    }

    @PostMapping("/generateFakeData")
    public String displayTable(HttpServletRequest request, Model model) {
        try {
            int num = Integer.parseInt(request.getParameter("num"));
            String language = request.getParameter("language");
            boolean address = request.getParameter("address") != null;
            boolean university = request.getParameter("university") != null;
            boolean country = request.getParameter("country") != null;
            boolean favColor = request.getParameter("favColor") != null;
            boolean favAnimal = request.getParameter("favAnimal") != null;
            boolean email = request.getParameter("email") != null;
            boolean job = request.getParameter("job") != null;
            boolean car = request.getParameter("car") != null;

            FakeDataDTO generatedData = fakeDataService.generateFakeData(num, new Locale(language), address, university,
                    country, favColor, favAnimal, email, job, car);
            model.addAttribute("language", language);
            model.addAttribute("address", address);
            model.addAttribute("university", university);
            model.addAttribute("country", country);
            model.addAttribute("favColor", favColor);
            model.addAttribute("favAnimal", favAnimal);
            model.addAttribute("email", email);
            model.addAttribute("job", job);
            model.addAttribute("car", car);

            model.addAttribute("headers", headers);
            model.addAttribute("generatedData", generatedData);
        }catch(Exception e){
            model.addAttribute("errorMessage", "Oops, something went wrong:(\nPlease, try again.");
        }
        return "fakeDataGenerator";
    }

    private Map<String, List<String>> initHeaders() {
        Map<String, List<String>> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("headers.txt").getInputStream(), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String language = parts[0].trim();
                List<String> headers = List.of(parts[1].split(","));
                map.put(language, headers);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
