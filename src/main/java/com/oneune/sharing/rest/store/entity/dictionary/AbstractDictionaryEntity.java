package com.oneune.sharing.rest.store.entity.dictionary;

import com.oneune.sharing.rest.store.entity.core.AbstractAuditableEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@ToString
public abstract class AbstractDictionaryEntity extends AbstractAuditableEntity {
    String value;
}