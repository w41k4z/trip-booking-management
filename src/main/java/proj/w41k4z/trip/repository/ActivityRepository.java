package proj.w41k4z.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proj.w41k4z.trip.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
