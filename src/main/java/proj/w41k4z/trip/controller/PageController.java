package proj.w41k4z.trip.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.w41k4z.orm.OrmConfiguration;
import proj.w41k4z.orm.database.DatabaseConnection;
import proj.w41k4z.trip.entity.Activity;
import proj.w41k4z.trip.entity.SubscriptionTier;

@Controller
@RequestMapping("/page")
public class PageController {

    private HashMap<String, String> pages;

    public PageController() {
        pages = new HashMap<>();
        pages.put("dashboard", "dashboard");
        pages.put("activite", "activite");
        pages.put("bouquet", "bouquet");
        pages.put("bouquet-activites", "bouquet-activites");
    }

    @GetMapping("/{page}")
    public String page(Model model, @PathVariable String page) {
        String pageName = pages.get(page);
        if (pageName == null) {
            return "pages/error/404";
        }
        model.addAttribute("currentPage", pageName);
        try {
            DatabaseConnection connection = new DatabaseConnection(OrmConfiguration.getDataSource());
            switch (pageName) {
                case "activite":
                    Activity activity = new Activity();
                    model.addAttribute("activity", activity);
                    model.addAttribute("activities", activity.findAll(connection));
                    break;
                case "bouquet":
                    SubscriptionTier subscriptionTier = new SubscriptionTier();
                    model.addAttribute("subscriptionTier", subscriptionTier);
                    model.addAttribute("subscriptionTiers", subscriptionTier.findAll(connection));
                    break;
                case "bouquet-activites":
                    model.addAttribute("subscriptionTiers", new SubscriptionTier().findAll(connection));
                    break;
                default:
                    break;
            }
            connection.close();
        } catch (Exception e) {
            return "pages/error/500";
        }
        return "layout";
    }
}
