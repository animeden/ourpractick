package com.example.demo.controller.web;

import com.example.demo.form.MaterialsForm;
import com.example.demo.form.SearchForm;
import com.example.demo.model.Materials;
import com.example.demo.service.materials.impls.MaterialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/materials")
public class MaterialsWEBController {
    @Autowired
    MaterialsServiceImpl service;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", service.getall());
        return "materialsList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Materials> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", list);
        return "materialsList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("materials", service.getall());
        return "redirect:/web/materials/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        MaterialsForm materialsForm = new MaterialsForm();
        model.addAttribute("materialsForm", materialsForm);
        return "materialsAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("materialsForm") MaterialsForm materialsForm){
        Materials materials = new Materials();

        materials.setCode(materialsForm.getCode());

        materials.setName(materialsForm.getName());

        materials.setPrice(materialsForm.getPrice());

        materials.setDescriction(materialsForm.getDescriction());

        service.save(materials);
        model.addAttribute("materials", service.getall());
        return "redirect:/web/materials/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Materials materials = service.get(id);
        MaterialsForm materialsForm = new MaterialsForm();
        materialsForm.setCode(materials.getCode());

        materialsForm.setName(materials.getName());

        materialsForm.setPrice(materials.getPrice());

        materialsForm.setDescriction(materials.getDescriction());
        model.addAttribute("materialsForm", materialsForm);
        return "materialsAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("materialsForm") MaterialsForm materialsForm){
        Materials materials = new Materials();
        materials.setId(id);

        materials.setCode(materialsForm.getCode());

        materials.setName(materialsForm.getName());

        materials.setPrice(materialsForm.getPrice());

        materials.setDescriction(materialsForm.getDescriction());

        service.save(materials);
        model.addAttribute("materials", service.getall());
        return "redirect:/web/materials/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Materials> materials = service.getall();
        List<Materials> sorted = service.sortByName(materials);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", sorted);
        return "materialsList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Materials> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("materials", list);
        return "materialsList";
    }
}
