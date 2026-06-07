package nl.jijalsproduct.controller;

import nl.jijalsproduct.model.CalculatorInput;
import nl.jijalsproduct.model.CalculatorResult;
import nl.jijalsproduct.model.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final CalculatorService calculatorService;

    public HomeController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("input", new CalculatorInput());
        model.addAttribute("result", null);
        model.addAttribute("activePage", "home");
        return "index";
    }

    @PostMapping("/bereken")
    public String bereken(@ModelAttribute CalculatorInput input, Model model) {
        CalculatorResult result = calculatorService.calculate(input);
        model.addAttribute("input", input);
        model.addAttribute("result", result);
        model.addAttribute("activePage", "home");
        return "index";
    }

    @GetMapping("/over")
    public String over(Model model) {
        model.addAttribute("activePage", "over");
        return "over";
    }

    @GetMapping("/tips")
    public String tips(Model model) {
        model.addAttribute("activePage", "tips");
        return "tips";
    }
}
