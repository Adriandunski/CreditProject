package pl.dunski.springbootcredit.controllers;

import org.springframework.web.bind.annotation.*;
import pl.dunski.springbootcredit.models.CreditFulInfo;
import pl.dunski.springbootcredit.models.DataComing;
import pl.dunski.springbootcredit.models.modelsDB.CreditDB;
import pl.dunski.springbootcredit.services.CreditService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CreditController {

    private CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    // Mały test działania Api
    @GetMapping("/hello")
    private String testHello() {
        return "Hello from Credit Api";
    }

    // Pobiera wszystkie Kredyty z bazy danych
    @GetMapping("/get")
    private List<CreditDB> get() {
        return creditService.get();
    }

    // Przekazane parametry do kredytu rodziela do poszczegolnych modolow ktore juz same zapisauje swoje informacje w odpowienid miejca
    @RequestMapping(value = "/creatCreditApi", method = RequestMethod.POST)
    @ResponseBody
    public String creatCredit(@Valid @RequestBody DataComing dataComing) {
        return "Numer kredytu to: " + creditService.creatCredit(dataComing);
    }

    // Metoda która zbiera wszystkie iformacje w jedno miejsce. (z 3 baz danych)
    @GetMapping("/getCreditsApi")
    public List<CreditFulInfo> getCredits() {
        return creditService.getCreditsFull();
    }

}
