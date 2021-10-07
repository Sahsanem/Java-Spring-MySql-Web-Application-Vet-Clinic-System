package com.works.bulutvet.controller;

import com.works.bulutvet.entities.CategoryGroup;
import com.works.bulutvet.repositories.CategoryGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class CategoryDescriptionController {


    final CategoryGroupRepository categoryGroupRepository;

    public CategoryDescriptionController(CategoryGroupRepository categoryGroupRepository) {
        this.categoryGroupRepository = categoryGroupRepository;
    }

    @GetMapping("/CategoryDescription")
    public String CategoryDescription(Model model){

        return "CategoryDescription";
    }

    @ResponseBody
    @PostMapping("/categoryDescription/add")
    public CategoryGroup addCategory(@RequestBody CategoryGroup categoryGroup){

        CategoryGroup cg = categoryGroupRepository.save(categoryGroup);
        return cg;

    }

    @ResponseBody
    @GetMapping("/categoryDescription/list")
    public List<CategoryGroup> listCategory(){

        return categoryGroupRepository.findAll();

    }

    @ResponseBody
    @DeleteMapping("/categoryDescription/delete/{stCgid}")
    public String delete(@PathVariable String stCgid){
        String status = "0";
        System.out.println("stCgid: " + stCgid);
        try {
            int cg_id = Integer.parseInt(stCgid);
            categoryGroupRepository.deleteById(cg_id);
            status = "1";
        } catch (Exception e) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!" + e);
        }
        return status;
    }
}
