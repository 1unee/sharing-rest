package com.oneune.sharing.rest.reader;

import com.google.gson.reflect.TypeToken;
import com.oneune.sharing.rest.contract.BaseQueried;
import com.oneune.sharing.rest.contract.Read;
import com.oneune.sharing.rest.store.dto.ThingDto;
import com.oneune.sharing.rest.store.entity.QThingEntity;
import com.oneune.sharing.rest.store.entity.ThingEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ThingReader implements Read<ThingDto>, BaseQueried<ThingEntity> {

    public final static Type THING_LIST_TYPE = TypeToken.getParameterized(List.class, ThingDto.class).getType();
    public final static QThingEntity qThing = new QThingEntity("sharing.thing");

    JPAQueryFactory queryFactory;
    ModelMapper modelMapper;

    @Override
    public JPAQuery<ThingEntity> writeBaseQuery(Predicate... predicates) {
        return queryFactory.selectFrom(qThing)
                .where(predicates)
                .orderBy(qThing.id.asc());
    }

    @Override
    public ThingDto getById(Long thingId) {
        return modelMapper.map(getEntityById(thingId), ThingDto.class);
    }

    @Override
    public ThingEntity getEntityById(Long userId) {
        return writeBaseQuery(qThing.id.eq(userId)).fetchOne();
    }

    @Deprecated(forRemoval = true, since = "Заменить пагинацией")
    public List<ThingDto> getAll() {
        return modelMapper.map(writeBaseQuery().fetch(), THING_LIST_TYPE);
    }
}
