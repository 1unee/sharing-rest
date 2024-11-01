package com.oneune.sharing.rest.store.entity;

import com.oneune.sharing.rest.store.entity.core.AbstractAuditableEntity;
import com.oneune.sharing.rest.store.entity.dictionary.PaymentStatusDictionaryEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Table(schema = "sharing", name = "payment")
@SequenceGenerator(schema = "sharing", sequenceName = "payment_id_seq", name = "id_seq", allocationSize = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@ToString
public class PaymentEntity extends AbstractAuditableEntity {

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    UserEntity buyer;

    @ManyToOne
    @JoinColumn(name = "thing_id")
    ThingEntity thing;

    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    PaymentStatusDictionaryEntity status;
}
