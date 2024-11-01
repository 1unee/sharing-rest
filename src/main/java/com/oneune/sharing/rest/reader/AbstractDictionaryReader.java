package com.oneune.sharing.rest.reader;

import com.oneune.sharing.rest.contract.BaseQueried;
import com.oneune.sharing.rest.contract.Read;
import com.oneune.sharing.rest.store.dto.DictionaryValueDto;
import com.oneune.sharing.rest.store.entity.dictionary.AbstractDictionaryEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public abstract class AbstractDictionaryReader<DE extends AbstractDictionaryEntity,
                                               DD extends DictionaryValueDto> implements Read<DD>, BaseQueried<DE> {

//    public final static Type DTO_LIST_TYPE = TypeToken.getParameterized(List.class, DictionaryValueDto.class).getType(); // Можно изменить на нужный тип DTO

    JPAQueryFactory queryFactory; // Для создания запросов
    ModelMapper modelMapper;

    // Метод для записи базового запроса с учетом предикатов
    @Override
    public JPAQuery<DE> writeBaseQuery(Predicate... predicates) {
        // Переопределите этот метод в дочернем классе, чтобы указать, с какой сущностью вы работаете
        return null;
    }

    // Получение сущности по ID
    public DE getEntityById(Long id) {
        return writeBaseQuery().where(getEntityIdPredicate(id)).fetchOne();
    }

    // Предикат для поиска по ID
    protected abstract Predicate getEntityIdPredicate(Long id);

    // Реализация метода для получения DTO по ID
    @Override
    public DD getById(Long id) {
        DE entity = getEntityById(id);
        return entity != null ? modelMapper.map(entity, getDtoClass()) : null;
    }

    // Метод для получения класса DTO
    protected abstract Class<DD> getDtoClass();

    // Метод для поиска всех записей
//    public List<DD> getAll() {
//        return modelMapper.map(writeBaseQuery().fetch(), DTO_LIST_TYPE);
//    }
}