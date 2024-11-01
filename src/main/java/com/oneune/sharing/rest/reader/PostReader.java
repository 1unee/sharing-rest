package com.oneune.sharing.rest.reader;

import com.google.gson.reflect.TypeToken;
import com.oneune.sharing.rest.contract.BaseQueried;
import com.oneune.sharing.rest.contract.Read;
import com.oneune.sharing.rest.store.dto.PostDto;
import com.oneune.sharing.rest.store.entity.PostEntity;
import com.oneune.sharing.rest.store.entity.QPostEntity;
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
public class PostReader implements Read<PostDto>, BaseQueried<PostEntity> {

    public final static Type POST_LIST_TYPE = TypeToken.getParameterized(List.class, PostDto.class).getType();
    public final static QPostEntity qPost = new QPostEntity("post");

    JPAQueryFactory queryFactory;
    ModelMapper modelMapper;

    @Override
    public JPAQuery<PostEntity> writeBaseQuery(Predicate... predicates) {
        return queryFactory.selectFrom(qPost)
                .where(predicates)
                .orderBy(qPost.id.asc());
    }

    @Override
    public PostEntity getEntityById(Long entityId) {
        return writeBaseQuery(qPost.id.eq(entityId)).fetchOne();
    }

    @Override
    public PostDto getById(Long postId) {
        return modelMapper.map(getEntityById(postId), PostDto.class);
    }

    @Deprecated(forRemoval = true, since = "Заменить пагинацией")
    public List<PostDto> getAll() {
        return modelMapper.map(writeBaseQuery().fetch(), POST_LIST_TYPE);
    }
}
