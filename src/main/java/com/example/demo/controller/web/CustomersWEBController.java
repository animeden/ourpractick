package com.example.demo.controller.web;

import com.example.demo.form.CustomersForm;
import com.example.demo.form.SearchForm;
import com.example.demo.model.Customers;
import com.example.demo.service.customers.impls.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/customers")
public class CustomersWEBController {
    @Autowired
    CustomersServiceImpl service;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", service.getall());
        return "customersList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Customers> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", list);
        return "customersList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("customers", service.getall());
        return "redirect:/web/customers/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        CustomersForm customersForm = new CustomersForm();
        model.addAttribute("customersForm", customersForm);
        return "customersAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("customersForm") CustomersForm customersForm){
        Customers customers = new Customers();

        customers.setName(customersForm.getName());

        customers.setBirth(customersForm.getBirth());

        customers.setPhoneNumber(customersForm.getPhoneNumber());

        customers.setAdress(customersForm.getAdress());

        customers.setDescriction(customersForm.getDescriction());

        service.save(customers);
        model.addAttribute("customers", service.getall());
        return "redirect:/web/customers/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Customers customers = service.get(id);
        CustomersForm customersForm = new CustomersForm();
        customersForm.setName(customers.getName());

        customersForm.setBirth(customers.getBirth());

        customersForm.setPhoneNumber(customers.getPhoneNumber());

        customersForm.setAdress(customers.getAdress());

        customersForm.setDescriction(customers.getDescriction());

        model.addAttribute("customersForm", customersForm);
        return "customersAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("customersForm") CustomersForm customersForm){
        Customers customers = new Customers();
        customers.setId(id);

        customers.setName(customersForm.getName());

        customers.setBirth(customersForm.getBirth());

        customers.setPhoneNumber(customersForm.getPhoneNumber());

        customers.setAdress(customersForm.getAdress());

        customers.setDescriction(customersForm.getDescriction());

        service.save(customers);
        model.addAttribute("customers", service.getall());
        return "redirect:/web/customers/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Customers> customers = service.getall();
        List<Customers> sorted = service.sortByName(customers);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", sorted);
        return "customersList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Customers> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", list);
        return "customersList";
    }

}
