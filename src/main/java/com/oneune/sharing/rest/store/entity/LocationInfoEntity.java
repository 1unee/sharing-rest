package com.oneune.sharing.rest.store.entity;

import com.oneune.sharing.rest.store.entity.core.AbstractAuditableEntity;
import com.oneune.sharing.rest.store.entity.dictionary.LocationDictionaryEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Table(schema = "\"user\"", name = "location_info")
@SequenceGenerator(schema = "\"user\"", sequenceName = "location_info_id_seq", name = "id_seq", allocationSize = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@ToString
public class LocationInfoEntity extends AbstractAuditableEntity {

    String porch;
    String porchCode;
    String floor;
    String flat;
    String description;

    @ManyToOne
    @JoinColumn(name = "location_id")
    LocationDictionaryEntity location;
}

