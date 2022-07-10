package ru.lubovflek.daysto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lubovflek.daysto.model.entity.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
