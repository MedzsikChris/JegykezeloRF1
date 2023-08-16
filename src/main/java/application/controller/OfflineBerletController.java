package application.controller;


import application.dao.JegyDAO;
import application.dao.OfflineBerletDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import application.model.Jegy;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Controller
public class OfflineBerletController {
    @Autowired
    private OfflineBerletDAO offlineBerletDAO;

    @GetMapping("/offline_berlet/{user}")
    public String jegy_admin(Model model, @PathVariable("user") String user) {
        model.addAttribute("berletek", offlineBerletDAO.listBerlet(user));
        return "offline_berlet";
    }



}