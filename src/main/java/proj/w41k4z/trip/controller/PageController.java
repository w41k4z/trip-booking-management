package proj.w41k4z.trip.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    private HashMap<String, String> pages;

    public PageController() {
        pages = new HashMap<>();
        pages.put("dashboard", "dashboard");
    }

    @GetMapping("/{page}")
    public String page(Model model, @PathVariable String page) {
        String pageName = pages.get(page);
        model.addAttribute("currentPage", pageName);
        return pageName != null ? "layout" : "pages/error/404";
    }
}
