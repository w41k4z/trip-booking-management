package proj.w41k4z.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.w41k4z.orm.OrmConfiguration;
import proj.w41k4z.orm.database.DatabaseConnection;
import proj.w41k4z.trip.entity.SubscriptionTier;

@Controller
@RequestMapping("/subscription-tiers")
public class SubscriptionTierController {

    @PostMapping
    public String create(@ModelAttribute("subscriptionTier") SubscriptionTier subscriptionTier) throws Exception {
        DatabaseConnection connection = new DatabaseConnection(OrmConfiguration.getDataSource());
        subscriptionTier.create(connection);
        connection.commit();
        connection.close();
        return "redirect:/page/bouquet";
    }
}
