package pl.edu.pja.s27591.tpo07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.pja.s27591.tpo07.model.CodeDTO;
import pl.edu.pja.s27591.tpo07.model.FormattingServiceInterface;

@Controller
public class FormattingController {
    private final FormattingServiceInterface formattingServiceInterface;
    public FormattingController(FormattingServiceInterface formattingServiceInterface) {
        this.formattingServiceInterface = formattingServiceInterface;
    }

    @GetMapping("/formatJavaCode")
    public String showForm(Model model) {
    model.addAttribute("codeForm", new CodeDTO());
        return "formatted-code";
    }

    @PostMapping("/formatJavaCode")
    public String formatCode(CodeDTO dto, Model model) {
        String formattedCode;
        try {
            formattedCode = formattingServiceInterface.formatSourceCode(dto.getCode());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Formatting failed: " + e.getMessage());
            return "error";
        }
        model.addAttribute("originalCode", dto.getCode());
        model.addAttribute("formattedCode", formattedCode);
        model.addAttribute("textId", dto.getTextId());
        model.addAttribute("duration", dto.getDuration());
        return "formatted-code";
    }
}
