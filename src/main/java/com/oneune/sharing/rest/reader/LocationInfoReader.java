package com.oneune.sharing.rest.reader;

import com.google.gson.reflect.TypeToken;
import com.oneune.sharing.rest.contract.BaseQueried;
import com.oneune.sharing.rest.contract.Read;
import com.oneune.sharing.rest.store.dto.LocationInfoDto;
import com.oneune.sharing.rest.store.entity.LocationInfoEntity;
import com.oneune.sharing.rest.store.entity.QLocationInfoEntity;
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

import static com.oneune.sharing.rest.reader.PaymentReader.qPayment;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LocationInfoReader implements Read<LocationInfoDto>, BaseQueried<LocationInfoEntity> {

    public final static Type LOCATION_INFO_LIST_TYPE = TypeToken.getParameterized(List.class, LocationInfoDto.class).getType();
    public final static QLocationInfoEntity qLocationInfo = new QLocationInfoEntity("location_info");

    JPAQueryFactory queryFactory;
    ModelMapper modelMapper;

    @Override
    public JPAQuery<LocationInfoEntity> writeBaseQuery(Predicate... predicates) {
        return queryFactory.selectFrom(qLocationInfo)
                .where(predicates)
                .orderBy(qPayment.id.asc());
    }

    @Override
    public LocationInfoEntity getEntityById(Long locationInfoId) {
        return writeBaseQuery(qLocationInfo.id.eq(locationInfoId)).fetchOne();
    }

    @Override
    public LocationInfoDto getById(Long locationInfoId) {
        return modelMapper.map(getEntityById(locationInfoId), LocationInfoDto.class);
    }

    @Deprecated(forRemoval = true, since = "Заменить пагинацией")
    public List<LocationInfoDto> getAll() {
        return modelMapper.map(writeBaseQuery().fetch(), LOCATION_INFO_LIST_TYPE);
    }
}
