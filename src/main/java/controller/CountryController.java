package controller;

import db.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CountryService;

@RestController
@RequestMapping("/api/games")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<Country> getRandomCountry() {
        Country country = countryService.getRandomCountry();
        return ResponseEntity.ok(country);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> guessCapital(@PathVariable Integer id, @RequestBody String capital) {
        return countryService.getCountryById(id)
                .map(country -> {
                    if (country.getCapital().equalsIgnoreCase(capital)) {
                        return ResponseEntity.ok("Ok");
                    } else {
                        return ResponseEntity.ok("Oups");
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
