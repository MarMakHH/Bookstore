package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryrepo;

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryrepo.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        categoryrepo.save(category);
        return "redirect:categorylist";
    }
}
