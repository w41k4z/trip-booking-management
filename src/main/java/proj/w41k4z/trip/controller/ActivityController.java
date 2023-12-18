package proj.w41k4z.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.w41k4z.orm.OrmConfiguration;
import proj.w41k4z.orm.database.DatabaseConnection;
import proj.w41k4z.trip.entity.Activity;

@Controller
@RequestMapping("/activites")
public class ActivityController {

    @PostMapping
    public String create(@ModelAttribute("activity") Activity activity) throws Exception {
        DatabaseConnection connection = new DatabaseConnection(OrmConfiguration.getDataSource());
        activity.create(connection);
        connection.commit();
        connection.close();
        return "redirect:/page/activite";
    }
}
