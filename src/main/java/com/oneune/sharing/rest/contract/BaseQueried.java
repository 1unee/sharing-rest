package com.oneune.sharing.rest.contract;

import com.oneune.sharing.rest.store.entity.core.AbstractEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

public interface BaseQueried<E extends AbstractEntity> {

    /**
     * Includes all possible joins.
     */
    JPAQuery<E> writeBaseQuery(Predicate... predicates);

    // JPAQuery<E> writeLightQuery(Predicate... predicates);
    // JPAQuery<E> writeHeavyQuery(Predicate... predicates);
    E getEntityById(Long entityId);
}
