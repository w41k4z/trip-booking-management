package proj.w41k4z.trip.entity;

import proj.w41k4z.orm.annotation.Column;
import proj.w41k4z.orm.annotation.Entity;
import proj.w41k4z.orm.annotation.Generated;
import proj.w41k4z.orm.annotation.Id;
import proj.w41k4z.orm.annotation.relationship.ManyToOne;
import proj.w41k4z.orm.database.Repository;

@Entity(table = "tier_activity")
public class TierActivity extends Repository<TierActivity, Long> {

    @Id
    @Generated
    private Long id;

    @ManyToOne
    @Column(name = "subscription_tier_id")
    private SubscriptionTier subscriptionTier;

    @ManyToOne
    @Column(name = "activity_id")
    private Activity activity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubscriptionTier getSubscriptionTier() {
        return subscriptionTier;
    }

    public void setSubscriptionTier(SubscriptionTier subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
