package com.iticbcn.MyWebApp.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.iticbcn.MyWebApp.Model.Llibre;
import com.iticbcn.MyWebApp.Model.Usuaris;
import com.iticbcn.MyWebApp.Repositories.RepoLlibre;
@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired
    RepoLlibre repoll;

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute("users") Usuaris users, Model model) {

        model.addAttribute("users", users);

        if (users.getUsuari().equals("toni") 
        && users.getPassword().equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }

        @GetMapping("/index")
    public String index(@ModelAttribute("users") Usuaris users, Model model) {

            return "index";
        
    }

    @GetMapping("/consulta") 
    public String consulta(@ModelAttribute("users") Usuaris users,Model model) {

        List<Llibre> llibres = repoll.findAll();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(@ModelAttribute("users") Usuaris users,Model model) {
        
        return "inserir";
    }
    
        @GetMapping("/cercaid")
    public String inputCerca(@ModelAttribute("users") Usuaris users, Model model) {

        Llibre llibre = new Llibre();
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }

    @PostMapping("/inserir")
    public String inserir(@ModelAttribute("users") Usuaris users, 
                          @RequestParam(name = "idLlibre") String idLlibre,
                          @RequestParam(name = "titol") String titol,  
                          @RequestParam(name = "autor") String autor,
                          @RequestParam(name = "editorial") String editorial,  
                          @RequestParam(name = "datapublicacio") LocalDate datapublicacio,
                          @RequestParam(name = "tematica") String tematica,
                          @RequestParam(name = "ISBN") String ISBN,
                          Model model) {

        String message = "";
        boolean llibreErr = false;

        if (idLlibre == null || !idLlibre.matches("\\d+")) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        } else {
            int idL = Integer.parseInt(idLlibre);
            Llibre llibre = new Llibre(idL,titol,autor,editorial,datapublicacio,tematica, ISBN);
            repoll.save(llibre);
            List<Llibre> llibres = repoll.findAll();
            model.addAttribute("llibres", llibres);
            return "consulta";            
        }

    }

    @PostMapping("/cercaid")
    public String cercaId(@ModelAttribute("users") Usuaris users,
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        
        Long idLlib = null;
        String message = "";
        boolean llibreErr = false;

        try {
            idLlib = Long.parseLong(idLlibre);
            Optional<Llibre> llibre = repoll.findById(idLlib);
            if(llibre !=null) {
                model.addAttribute("llibre", llibre);
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);

        return "cercaid";

    }

    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }


    @ModelAttribute("users")
    public Usuaris getDefaultUser() {
        return new Usuaris(); 
    }




}
