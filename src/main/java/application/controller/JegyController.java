package application.controller;

import application.dao.JegyDAO;
import application.dao.MegalloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.support.NullValue;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import application.model.Jegy;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


@Controller
public class JegyController {
    @Autowired
    private JegyDAO jegyDAO;

    @Autowired
    private MegalloDAO megalloDAO;


    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/jegy_admin")
    public String jegy_admin(Model model) {
        model.addAttribute("jegy", jegyDAO.listJegy());
        model.addAttribute("megallo", megalloDAO.listMegallo());
        return "jegy_admin";
    }

    @GetMapping("/jegyeim/{user}")
    public String jegyeim(Model model, @PathVariable("user") String user) {
        model.addAttribute("jegy", jegyDAO.listJegy(user));
        model.addAttribute("megallo", megalloDAO.listMegallo());
        return "jegyeim";
    }

    @PostMapping("/jegyeim/add")
    public String addJegy2(@RequestParam("civ") String civ, @RequestParam("kezdo_megallo") String kezdo_megallo, @RequestParam("vegallomas") String vegallomas, @RequestParam("kocsiosztaly") int kocsiosztaly, @RequestParam("oda_vissza") String oda_vissza, @RequestParam("kedvezmeny") String kedvezmeny, @RequestParam("kamu_ar") int ar){
        Jegy jegy = new Jegy(civ, kezdo_megallo, vegallomas, kocsiosztaly, false, kedvezmeny, ar);
        if (Objects.equals(oda_vissza, "igen")) jegy.setOda_vissza(true);
        jegyDAO.insertJegy(jegy);
        return "redirect:/jegyeim/" + civ;
    }

    @GetMapping("/vasut")
    public String vasut() {
        return "vasut";
    }

    @PostMapping(value = "/jegy_admin/add")
    public String addJegy(@RequestParam("civ") String civ, @RequestParam("kezdo_megallo") String kezdo_megallo, @RequestParam("vegallomas") String vegallomas, @RequestParam("kocsiosztaly") int kocsiosztaly, @RequestParam("oda_vissza") String oda_vissza, @RequestParam("ar") int ar, @RequestParam("ervenyes_ettol")String ervenyes_ettol, @RequestParam("ervenyes_eddig") String ervenyes_eddig, @RequestParam("datum") String datum, @RequestParam("kedvezmeny") String kedvezmeny){
        Jegy jegy = new Jegy(civ, kezdo_megallo, vegallomas, kocsiosztaly, false, ar, ervenyes_ettol, ervenyes_eddig, datum, kedvezmeny);
        if (Objects.equals(oda_vissza, "igen")) jegy.setOda_vissza(true);
        jegyDAO.insertJegy(jegy);
        return "redirect:/jegy_admin";

    }

    @PostMapping(value = "/jegy_admin/delete/{id}")
    public String deleteJegy(@PathVariable("id") int id) {
        jegyDAO.deleteJegy(id);

        return "redirect:/jegy_admin";
    }

    @PostMapping(value = "/jegy_admin/update/{id}")
    public String updateJegy(@PathVariable("id") int id, @RequestParam("up_civ") String civ, @RequestParam("up_kezdo_megallo") String kezdo_megallo, @RequestParam("up_vegallomas") String vegallomas, @RequestParam("up_kocsiosztaly") int kocsiosztaly, @RequestParam("up_oda_vissza") String oda_vissza, @RequestParam("up_ar") int ar, @RequestParam("up_ervenyes_ettol")String ervenyes_ettol, @RequestParam("up_ervenyes_eddig") String ervenyes_eddig, @RequestParam("up_datum") String datum, @RequestParam("up_kedvezmeny") String kedvezmeny){
        Jegy jegy = new Jegy(civ, kezdo_megallo, vegallomas, kocsiosztaly, ar, ervenyes_ettol, ervenyes_eddig, datum, kedvezmeny);
        if (Objects.equals(oda_vissza, "igen")) jegy.setOda_vissza(true);
        //Jegy jegy = new Jegy("1", "1", "1", "1", 1, 1, "2022-11-1", "2022-11-1", "2022-11-1", "1");

        jegyDAO.updateJegy(id, jegy);
        return "redirect:/jegy_admin";
    }
}