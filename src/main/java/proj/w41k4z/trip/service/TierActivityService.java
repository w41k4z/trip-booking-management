package proj.w41k4z.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.w41k4z.trip.entity.TierActivity;
import proj.w41k4z.trip.repository.TierActivityRepository;

@Service
public class TierActivityService {

    @Autowired
    private TierActivityRepository repository;

    public List<TierActivity> getAllTierActivities() {
        return repository.findAll();
    }

    public TierActivity getTierActivityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public TierActivity createTierActivity(TierActivity tierActivity) {
        return repository.save(tierActivity);
    }

    public void deleteTierActivity(Long id) {
        repository.deleteById(id);
    }
}
