package ru.lubovflek.daysto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lubovflek.daysto.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
