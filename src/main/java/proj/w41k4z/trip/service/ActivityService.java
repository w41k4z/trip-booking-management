package proj.w41k4z.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.w41k4z.trip.entity.Activity;
import proj.w41k4z.trip.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    public Activity getActivityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Activity createActivity(Activity activity) {
        return repository.save(activity);
    }

    public Activity updateActivity(Long id, Activity updatedActivity) {
        Activity existingActivity = repository.findById(id).orElse(null);

        if (existingActivity != null) {
            existingActivity.setName(updatedActivity.getName());
            existingActivity.setDescription(updatedActivity.getDescription());

            return repository.save(existingActivity);
        }

        throw new NullPointerException("Activity not found");
    }

    public void deleteActivity(Long id) {
        repository.deleteById(id);
    }
}
