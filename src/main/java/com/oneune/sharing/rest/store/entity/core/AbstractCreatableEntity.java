package com.oneune.sharing.rest.store.entity.core;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@ToString
public class AbstractCreatableEntity extends AbstractEntity {
    @Builder.Default
    Instant createdAt = Instant.now();
}
