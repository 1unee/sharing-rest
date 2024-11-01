package com.oneune.sharing.rest.reader;

import com.google.gson.reflect.TypeToken;
import com.oneune.sharing.rest.contract.BaseQueried;
import com.oneune.sharing.rest.contract.Read;
import com.oneune.sharing.rest.store.dto.PaymentDto;
import com.oneune.sharing.rest.store.entity.PaymentEntity;
import com.oneune.sharing.rest.store.entity.QPaymentEntity;
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
public class PaymentReader implements Read<PaymentDto>, BaseQueried<PaymentEntity> {

    public final static Type PAYMENT_LIST_TYPE = TypeToken.getParameterized(List.class, PaymentDto.class).getType();
    public final static QPaymentEntity qPayment = new QPaymentEntity("payment");

    JPAQueryFactory queryFactory;
    ModelMapper modelMapper;

    @Override
    public JPAQuery<PaymentEntity> writeBaseQuery(Predicate... predicates) {
        return queryFactory.selectFrom(qPayment)
                .where(predicates)
                .orderBy(qPayment.id.asc());
    }

    @Override
    public PaymentEntity getEntityById(Long entityId) {
        return writeBaseQuery(qPayment.id.eq(entityId)).fetchOne();
    }

    @Override
    public PaymentDto getById(Long paymentId) {
        return modelMapper.map(getEntityById(paymentId), PaymentDto.class);
    }

    @Deprecated(forRemoval = true, since = "Заменить пагинацией")
    public List<PaymentDto> getAll() {
        return modelMapper.map(writeBaseQuery().fetch(), PAYMENT_LIST_TYPE);
    }
}
