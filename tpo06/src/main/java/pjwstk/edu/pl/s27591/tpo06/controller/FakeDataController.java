package pjwstk.edu.pl.s27591.tpo06.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pjwstk.edu.pl.s27591.tpo06.model.FakeDataDTO;
import pjwstk.edu.pl.s27591.tpo06.model.FakeDataService;

import java.util.Locale;

@Controller
public class FakeDataController {
    private final FakeDataService fakeDataService;

    public FakeDataController(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
    }

    @GetMapping("/generateFakeData")
    public String displayForm(Model model) {
        return "fakeDataGenerator";
    }

    @PostMapping("/generateFakeData")
    public String displayTable(HttpServletRequest request, Model model) {
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
        model.addAttribute("address", address);
        model.addAttribute("university", university);
        model.addAttribute("country", country);
        model.addAttribute("favColor", favColor);
        model.addAttribute("favAnimal", favAnimal);
        model.addAttribute("email", email);
        model.addAttribute("job", job);
        model.addAttribute("car", car);
        model.addAttribute("generatedData", generatedData);
        return "fakeDataGenerator";
    }

}
