package proj.w41k4z.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.w41k4z.trip.entity.SubscriptionTier;
import proj.w41k4z.trip.repository.SubscriptionTierRepository;

@Service
public class SubscriptionTierService {

    @Autowired
    private SubscriptionTierRepository repository;

    public List<SubscriptionTier> getAllSubscriptionTiers() {
        return repository.findAll();
    }

    public SubscriptionTier getSubscriptionTierById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public SubscriptionTier createSubscriptionTier(SubscriptionTier subscriptionTier) {
        return repository.save(subscriptionTier);
    }

    public SubscriptionTier updateSubscriptionTier(Long id, SubscriptionTier updatedSubscriptionTier) {
        SubscriptionTier existingSubscriptionTier = repository.findById(id).orElse(null);

        if (existingSubscriptionTier != null) {
            existingSubscriptionTier.setName(updatedSubscriptionTier.getName());
            existingSubscriptionTier.setDescription(updatedSubscriptionTier.getDescription());

            return repository.save(existingSubscriptionTier);
        }

        throw new NullPointerException("SubscriptionTier not found");
    }

    public void deleteSubscriptionTier(Long id) {
        repository.deleteById(id);
    }
}
