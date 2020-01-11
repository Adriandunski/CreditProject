package pl.dunski.springbootcredit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.dunski.springbootcredit.models.DataComing;
import pl.dunski.springbootcredit.services.CreditService;

import javax.validation.Valid;

@Controller
public class HomeCotroller {

    private CreditService creditService;

    public HomeCotroller(CreditService creditService) {
        this.creditService = creditService;
    }

    // Przekieruje nas na strone głowna
    @GetMapping("/getCredits")
    public String homePage(Model model) {
        model.addAttribute("credits", creditService.getCreditsFull());
        return "homePage";
    }

    // Za pomocą tej strony możemy dodać kredyt
    @GetMapping("/creatCredit")
    public String addCredit(@RequestParam(value = "credit", required = false) String credit, Model model, DataComing dataComing) {

        if (credit != null) {
            model.addAttribute("credit", credit);
        }

        return "add-credit";
    }

    // Ta metoda przyjmie wartości wpisane do dodania kredytu
    @PostMapping("/creatCredit")
    public String addPlanet(@Valid DataComing dataComing, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        // Jeśli wystąpi błąd...
        if (bindingResult.hasErrors()) {
            return "add-credit";
        }

        String credit = "Twój nowy numer kredytu to: " + creditService.creatCredit(dataComing);
        redirectAttributes.addAttribute("credit", credit);
        return "redirect:/creatCredit";
    }
}
