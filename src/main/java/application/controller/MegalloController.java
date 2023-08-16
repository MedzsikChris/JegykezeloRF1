package application.controller;

import application.dao.MegalloDAO;
import application.model.Jegy;
import application.model.Megallo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class MegalloController {

    @Autowired
    private MegalloDAO megalloDAO;

    @GetMapping(value = "/megallo")
    public String listMegallo(Model model){
        model.addAttribute("megallo", megalloDAO.listMegallo());
        return "megallo";
    }

    @PostMapping("/megallo/add")
    public String addMegallo(@RequestParam("nev") String nev, @RequestParam("cim") String cim){
        Megallo megallo = new Megallo(nev, cim);
        megalloDAO.insertMegallo(megallo);
        return "redirect:/megallo";
    }

    @PostMapping(value = "/delete/{megallo_id}")
    public String deleteDog(@PathVariable("megallo_id") int megallo_id) {
        megalloDAO.deleteMegallo(megallo_id);

        return "redirect:/";
    }

    @PostMapping(value = "/update/{megallo_id}")
    public String updateDog(@PathVariable("megallo_id") int megallo_id, @RequestParam("nev") String nev, @RequestParam("cim") String cim) {
        megalloDAO.updateMegallo(megallo_id, nev, cim);

        return "redirect:/";
    }
}
