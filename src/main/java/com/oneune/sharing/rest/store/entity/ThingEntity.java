package com.oneune.sharing.rest.store.entity;

import com.oneune.sharing.rest.store.entity.core.AbstractAuditableEntity;
import com.oneune.sharing.rest.store.entity.dictionary.ThingTypeDictionaryEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @see com.oneune.sharing.rest.store.dto.ThingDto
 */
@Entity
@Table(schema = "sharing", name = "thing")
@SequenceGenerator(schema = "sharing", sequenceName = "thing_id_seq", name = "id_seq", allocationSize = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@ToString
public class ThingEntity extends AbstractAuditableEntity {

    String name;
    String description;
    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "post_id")
    PostEntity post;

    @ManyToOne
    @JoinColumn(name = "thing_type_id")
    ThingTypeDictionaryEntity type;
}

