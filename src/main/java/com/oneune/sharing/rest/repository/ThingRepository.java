package com.oneune.sharing.rest.repository;

import com.oneune.sharing.rest.store.entity.ThingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<ThingEntity, Long> {
}
