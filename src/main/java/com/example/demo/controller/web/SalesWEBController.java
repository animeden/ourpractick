package com.example.demo.controller.web;

import com.example.demo.form.ProductsForm;
import com.example.demo.form.SalesForm;
import com.example.demo.form.SearchForm;
import com.example.demo.model.*;
import com.example.demo.service.customers.impls.CustomersServiceImpl;
import com.example.demo.service.materials.impls.MaterialsServiceImpl;
import com.example.demo.service.preciousStones.impls.PreciousStonesServiceImpl;
import com.example.demo.service.products.impls.ProductServiceImpl;
import com.example.demo.service.sales.impls.SalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/sales")
public class SalesWEBController {
    @Autowired
    SalesServiceImpl service;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CustomersServiceImpl customersService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sales", service.getall());
        return "salesList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Sales> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sales", list);
        return "salesList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("sales", service.getall());
        return "redirect:/web/sales/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        SalesForm salesForm = new SalesForm();
        Map<String, String> mavs1 = productService.getall().stream()
                .collect(Collectors.toMap(Products::getId, Products::getId));
        model.addAttribute("mavs1", mavs1);
        Map<String, String> mavs2 = customersService.getall().stream()
                .collect(Collectors.toMap(Customers::getId, Customers::getName));
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("salesForm", salesForm);
        return "salesAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("salesForm") SalesForm salesForm){
        Sales sales = new Sales();
        Products products = productService.get(salesForm.getProductId());
        Customers customers = customersService.get(salesForm.getFullName());

        sales.setProductId(products);

        sales.setDate(salesForm.getDate());

        sales.setFullName(customers);

        sales.setDescriction(salesForm.getDescriction());

        service.save(sales);
        model.addAttribute("sales", service.getall());
        return "redirect:/web/sales/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Sales sales = service.get(id);
        SalesForm salesForm = new SalesForm();
        Map<String, String> mavs1 = productService.getall().stream()
                .collect(Collectors.toMap(Products::getId, Products::getId));
        model.addAttribute("mavs1", mavs1);
        Map<String, String> mavs2 = customersService.getall().stream()
                .collect(Collectors.toMap(Customers::getId, Customers::getName));

        salesForm.setProductId(sales.getProductId().getId());

        salesForm.setDate(sales.getDate());

        salesForm.setFullName(sales.getFullName().getName());

        salesForm.setDescriction(sales.getDescriction());

        model.addAttribute("salesForm", salesForm);
        return "salesAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("salesForm") SalesForm salesForm){
        Sales sales = new Sales();
        Products products = productService.get(salesForm.getProductId());
        Customers customers = customersService.get(salesForm.getFullName());
        sales.setId(id);

        sales.setProductId(products);

        sales.setDate(salesForm.getDate());

        sales.setFullName(customers);

        sales.setDescriction(salesForm.getDescriction());

        service.save(sales);
        model.addAttribute("sales", service.getall());
        return "redirect:/web/sales/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Sales> sales = service.getall();
        List<Sales> sorted = service.sortByName(sales);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sales", sorted);
        return "salesList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Sales> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sales", list);
        return "salesList";
    }
}
