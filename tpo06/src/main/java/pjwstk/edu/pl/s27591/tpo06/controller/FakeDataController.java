package pjwstk.edu.pl.s27591.tpo06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pjwstk.edu.pl.s27591.tpo06.model.FakeDataService;
import pjwstk.edu.pl.s27591.tpo06.model.Person;

import java.util.List;
import java.util.Locale;

@Controller
public class FakeDataController {
    private final FakeDataService fakeDataService;

    public FakeDataController(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
    }

    @GetMapping("/generateData")
    public String showForm(Model model) {
        return "form";
    }

    @PostMapping("/generateData")
    public String generateData(@RequestParam int quantity,
                               @RequestParam String language,
                               @RequestParam(defaultValue = "false") boolean includeAddress,
                               @RequestParam(defaultValue = "false") boolean includeUniversity,
                               @RequestParam(defaultValue = "false") boolean includeCountry,
                               @RequestParam(defaultValue = "false") boolean includeCustomFields,
                               Model model) {
        List<Person> generatedData = fakeDataService.generateFakeData(
                quantity,
                new Locale(language),
                includeAddress,
                includeUniversity,
                includeCountry,
                includeCustomFields
        );
        model.addAttribute("generatedData", generatedData);
        return "result";
    }
}
