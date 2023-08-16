package application.controller;

import application.dao.BerletDAO;
import application.model.Berlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BerletController {

    @Autowired
    private BerletDAO berletDAO;

    @GetMapping("/berlet_admin")
    public String listBerlet(Model model) {
        model.addAttribute("berlet", berletDAO.listBerlet());
        return "berlet_admin";
    }

    @PostMapping(value = "/berlet/add")
    public String addBerlet(@RequestParam("berlet_id") String berlet_id, @RequestParam("felhasznalo_id") String felhasznalo_id, @RequestParam("tulaj") String tulaj, @RequestParam("ervenyesseg_kezdet") String ervenyesseg_kezdet, @RequestParam("ervenyesseg_veg") String ervenyesseg_veg, @RequestParam("honnan") String honnan, @RequestParam("hova") String hova, @RequestParam("tipus") String tipus, @RequestParam("kedvezmeny") String kedvezmeny){
        Berlet berlet = new Berlet(berlet_id, felhasznalo_id, tulaj, ervenyesseg_kezdet, ervenyesseg_veg, honnan, hova, tipus, kedvezmeny);
        berletDAO.insertBerlet(berlet);
        return "redirect:/berlet_admin";
    }
    @PostMapping(value = "/berlet/delete/{berlet_id}")
    public String deleteBerlet(@PathVariable("berlet_id") String id) {
        berletDAO.deleteBerlet(id);

        return "redirect:/berlet_admin";
    }
}
