package com.wolverineteam.onlinemarket.web;

import com.wolverineteam.onlinemarket.models.Brand;
import com.wolverineteam.onlinemarket.models.Product;
import com.wolverineteam.onlinemarket.services.base.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String strId, Model model) {
        int id = Integer.parseInt(strId);
        Brand brand = brandService.getById(id);
        model.addAttribute("brand", brand.getBrandName());
        return "brand";
    }

//    @GetMapping("/")
//    public List<Brand> getAll() {
//        return brandService.getAll();
//    }
//
//    @GetMapping("/{id}/products")
//    public List<Product> getAllBrandProducts(@PathVariable("id") String strId){
//        int id = Integer.parseInt(strId);
//        return brandService.getAllBrandProducts(id);
//    }
//
//    @PutMapping("/update/{id}")
//    public void update(@PathVariable("id") String strId, @RequestBody Brand brand) {
//        int id = Integer.parseInt(strId);
//        brandService.update(id, brand);
//    }
//
//    @PostMapping("/create")
//    public void create(@RequestBody Brand brand) {
//        brandService.create(brand);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable("id") String strId) {
//        int id = Integer.parseInt(strId);
//        brandService.delete(id);
//    }
}
