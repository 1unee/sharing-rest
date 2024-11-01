package com.oneune.sharing.rest.reader;

import com.google.gson.reflect.TypeToken;
import com.oneune.sharing.rest.contract.BaseQueried;
import com.oneune.sharing.rest.contract.Read;
import com.oneune.sharing.rest.store.dto.UserDto;
import com.oneune.sharing.rest.store.entity.QUserEntity;
import com.oneune.sharing.rest.store.entity.UserEntity;
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
import java.util.Optional;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserReader implements Read<UserDto>, BaseQueried<UserEntity> {

    public final static Type USER_LIST_TYPE = TypeToken.getParameterized(List.class, UserDto.class).getType();
    public final static QUserEntity qUser = new QUserEntity("user.user");

    JPAQueryFactory queryFactory;
    ModelMapper modelMapper;

    @Override
    public JPAQuery<UserEntity> writeBaseQuery(Predicate... predicates) {
        return queryFactory.selectFrom(qUser)
                .where(predicates)
                .orderBy(qUser.id.asc());
    }

    @Override
    public UserEntity getEntityById(Long userId) {
        return writeBaseQuery(qUser.id.eq(userId)).fetchOne();
    }

    @Override
    public UserDto getById(Long userId) {
        return modelMapper.map(getEntityById(userId), UserDto.class);
    }

    public Optional<UserDto> getByUsername(String username) {
        JPAQuery<UserEntity> query = writeBaseQuery(qUser.username.eq(username));
        List<UserDto> userDtos = modelMapper.map(query.fetch(), USER_LIST_TYPE);
        return userDtos.isEmpty() ? Optional.empty() : Optional.ofNullable(userDtos.get(0));
    }

    @Deprecated(forRemoval = true, since = "Заменить пагинацией")
    public List<UserDto> getAll() {
        return modelMapper.map(writeBaseQuery().fetch(), USER_LIST_TYPE);
    }
}
