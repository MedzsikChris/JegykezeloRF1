package application.controller;

import application.dao.FelhasznaloDAO;
import application.model.Felhasznalo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;

@Controller
public class FelhasznaloController {
    @Autowired
    private FelhasznaloDAO felhasznaloDAO;


    @GetMapping("/regisztracio")
    public String regisztracio() {
        return "regisztracio";
    }

    @GetMapping("/login")
    public String bejelentkezes() {
        return "login";
    }


    @PostMapping(value = "/felhasznaloRegisztralas")
    public String felhasznaloRegistralas(@RequestParam("nev") String nev,
                                         @RequestParam("email") String email,
                                         @RequestParam("jelszo") String jelszo) {
        Felhasznalo felhasznalo = new Felhasznalo(nev, email, jelszo);
        felhasznaloDAO.beszurFelhasznalot(felhasznalo);
        return "redirect:/";
    }

}

