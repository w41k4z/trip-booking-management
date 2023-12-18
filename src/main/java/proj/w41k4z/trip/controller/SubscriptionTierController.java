package proj.w41k4z.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.w41k4z.trip.service.SubscriptionTierService;

@Controller
@RequestMapping("/subscription-tiers")
public class SubscriptionTierController {

    @Autowired
    private SubscriptionTierService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("subscriptionTiers", service.getAllSubscriptionTiers());
        return "subscription-tiers/index";
    }
}
