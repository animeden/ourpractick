package com.example.demo.controller.web;

import com.example.demo.form.CustomersForm;
import com.example.demo.form.ProductsForm;
import com.example.demo.form.SearchForm;
import com.example.demo.model.Customers;
import com.example.demo.model.Materials;
import com.example.demo.model.PreciousStones;
import com.example.demo.model.Products;
import com.example.demo.service.customers.impls.CustomersServiceImpl;
import com.example.demo.service.materials.impls.MaterialsServiceImpl;
import com.example.demo.service.preciousStones.impls.PreciousStonesServiceImpl;
import com.example.demo.service.products.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/products")
public class ProductsWEBController {
    @Autowired
    ProductServiceImpl service;

    @Autowired
    MaterialsServiceImpl materialsService;

    @Autowired
    PreciousStonesServiceImpl preciousStonesService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("products", service.getall());
        return "productsList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Products> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("products", list);
        return "productsList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("products", service.getall());
        return "redirect:/web/products/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        ProductsForm productsForm = new ProductsForm();
        Map<String, String> mavs1 = materialsService.getall().stream()
                .collect(Collectors.toMap(Materials::getId, Materials::getCode));
        model.addAttribute("mavs1", mavs1);
        Map<String, String> mavs2 = preciousStonesService.getall().stream()
                .collect(Collectors.toMap(PreciousStones::getId, PreciousStones::getName));
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("productsForm", productsForm);
        return "productsAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("productsForm") ProductsForm productsForm){
        Products products = new Products();
        Materials materials = materialsService.get(productsForm.getMaterialCode());
        PreciousStones preciousStones = preciousStonesService.get(productsForm.getPreciousStoneName());

        products.setName(productsForm.getName());

        products.setMaterialCode(materials);

        products.setPreciousStoneName(preciousStones);

        products.setMass(productsForm.getMass());

        products.setPrice(productsForm.getPrice());

        products.setDescriction(productsForm.getDescriction());

        service.save(products);
        model.addAttribute("products", service.getall());
        return "redirect:/web/products/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Products products = service.get(id);
        ProductsForm productsForm = new ProductsForm();
        Map<String, String> mavs1 = materialsService.getall().stream()
                .collect(Collectors.toMap(Materials::getId, Materials::getCode));
        model.addAttribute("mavs1", mavs1);
        Map<String, String> mavs2 = preciousStonesService.getall().stream()
                .collect(Collectors.toMap(PreciousStones::getId, PreciousStones::getName));

        productsForm.setName(products.getName());

        productsForm.setMaterialCode(products.getMaterialCode().getCode());

        productsForm.setPreciousStoneName(products.getPreciousStoneName().getName());

        productsForm.setMass(products.getMass());

        productsForm.setPrice(products.getPrice());

        productsForm.setDescriction(products.getDescriction());

        model.addAttribute("productsForm", productsForm);
        return "productsAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("productsForm") ProductsForm productsForm){
        Products products = new Products();
        Materials materials = materialsService.get(productsForm.getMaterialCode());
        PreciousStones preciousStones = preciousStonesService.get(productsForm.getPreciousStoneName());
        products.setId(id);

        products.setName(productsForm.getName());

        products.setMaterialCode(materials);

        products.setPreciousStoneName(preciousStones);

        products.setMass(productsForm.getMass());

        products.setPrice(productsForm.getPrice());

        products.setDescriction(productsForm.getDescriction());

        service.save(products);
        model.addAttribute("products", service.getall());
        return "redirect:/web/products/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Products> products = service.getall();
        List<Products> sorted = service.sortByName(products);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("products", sorted);
        return "productsList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Products> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("products", list);
        return "productsList";
    }
}
