package com.oneune.sharing.rest.repository;

import com.oneune.sharing.rest.store.entity.LocationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationInfoRepository extends JpaRepository<LocationInfoEntity, Long> {
}
