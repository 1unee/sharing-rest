package com.oneune.sharing.rest.reader;

import com.oneune.sharing.rest.store.dto.DictionaryValueDto;
import com.oneune.sharing.rest.store.entity.dictionary.AbstractDictionaryEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public final class DictionaryReaderFactory {

    JPAQueryFactory queryFactory;
    ModelMapper modelMapper;

    public <DE extends AbstractDictionaryEntity,
            DD extends DictionaryValueDto> AbstractDictionaryReader<DE, DD> create(Class<DE> dictionaryEntityClass) {

        String readerClassName = dictionaryEntityClass.getSimpleName().replace("Entity", "") + "Reader";

//        try {
//            Class<AbstractDictionaryReader<DE, DD>> readerClass = new ByteBuddy()
//                    .subclass(AbstractDictionaryReader.class)
//                    .name("com.oneune.mater.rest.main.reader." + readerClassName)
//                    .method(ElementMatchers.named("getAll"))
//                    .intercept(MethodDelegation.to(new GetAllMethodHandler<DE, DD>(dictionaryEntityClass, queryFactory, modelMapper)))
//                    .method(ElementMatchers.named("getById"))
//                    .intercept(MethodDelegation.to(new GetByIdMethodHandler<DE, DD>(dictionaryEntityClass, queryFactory, modelMapper)))
//                    .make()
//                    .load(DictionaryReaderFactory.class.getClassLoader())
//                    .getLoaded();
//
//            return readerClass.getDeclaredConstructor().newInstance();
//        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            throw new RuntimeException("Failed to create reader for " + dictionaryEntityClass.getName(), e);
//        }

        throw new IllegalStateException("Not implemented yet!");
    }
}
