package com.oneune.sharing.rest.store.entity.dictionary;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Table(schema = "dictionary", name = "payment_status")
@SequenceGenerator(schema = "dictionary", sequenceName = "payment_status_id_seq", name = "id_seq", allocationSize = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@SuperBuilder
@Data
public class PaymentStatusDictionaryEntity extends AbstractDictionaryEntity {
}