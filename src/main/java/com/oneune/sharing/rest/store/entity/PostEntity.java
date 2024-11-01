package com.oneune.sharing.rest.store.entity;

import com.oneune.sharing.rest.store.entity.core.AbstractAuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(schema = "sharing", name = "post")
@SequenceGenerator(schema = "sharing", sequenceName = "post_id_seq", name = "id_seq", allocationSize = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@ToString
public class PostEntity extends AbstractAuditableEntity {

    String title;
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity seller;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<ThingEntity> things;
}

