package com.example.demo.controller.web;

import com.example.demo.form.PreciousStonesForm;
import com.example.demo.form.SearchForm;
import com.example.demo.model.PreciousStones;
import com.example.demo.service.preciousStones.impls.PreciousStonesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/preciousStones")
public class PreciousStonesWEBController {
    @Autowired
    PreciousStonesServiceImpl service;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("preciousStones", service.getall());
        return "preciousStonesList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<PreciousStones> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("preciousStones", list);
        return "preciousStonesList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("preciousStones", service.getall());
        return "redirect:/web/preciousStones/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        PreciousStonesForm preciousStonesForm = new PreciousStonesForm();
        model.addAttribute("preciousStonesForm", preciousStonesForm);
        return "preciousStonesAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("preciousStonesForm") PreciousStonesForm preciousStonesForm){
        PreciousStones preciousStones = new PreciousStones();

        preciousStones.setName(preciousStonesForm.getName());

        preciousStones.setMass(preciousStonesForm.getMass());

        preciousStones.setPrice(preciousStonesForm.getPrice());

        preciousStones.setDescriction(preciousStonesForm.getDescriction());

        service.save(preciousStones);
        model.addAttribute("preciousStones", service.getall());
        return "redirect:/web/preciousStones/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        PreciousStones preciousStones = service.get(id);
        PreciousStonesForm preciousStonesForm = new PreciousStonesForm();
        preciousStonesForm.setName(preciousStones.getName());

        preciousStonesForm.setMass(preciousStones.getMass());

        preciousStonesForm.setPrice(preciousStones.getPrice());

        preciousStonesForm.setDescriction(preciousStones.getDescriction());

        model.addAttribute("preciousStonesForm", preciousStonesForm);
        return "preciousStonesAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("preciousStonesForm") PreciousStonesForm preciousStonesForm){
        PreciousStones preciousStones = new PreciousStones();
        preciousStones.setId(id);

        preciousStones.setName(preciousStonesForm.getName());

        preciousStones.setMass(preciousStonesForm.getMass());

        preciousStones.setPrice(preciousStonesForm.getPrice());

        preciousStones.setDescriction(preciousStonesForm.getDescriction());

        service.save(preciousStones);
        model.addAttribute("preciousStones", service.getall());
        return "redirect:/web/preciousStones/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<PreciousStones> preciousStones = service.getall();
        List<PreciousStones> sorted = service.sortByName(preciousStones);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("preciousStones", sorted);
        return "preciousStonesList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<PreciousStones> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("preciousStones", list);
        return "preciousStonesList";
    }
}
