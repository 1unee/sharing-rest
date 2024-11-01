package com.oneune.sharing.rest.store.entity;

import com.oneune.sharing.rest.store.entity.core.AbstractCreatableEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(schema = "system", name = "exception")
@SequenceGenerator(schema = "system", sequenceName = "exception_id_seq", name = "id_seq", allocationSize = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class ExceptionEntity extends AbstractCreatableEntity {
    /**
     * Тип исключения.
     */
    String exceptionType;
    /**
     * Сообщение об исключении.
     */
    String message;
    /**
     * Причина исключения (если вызвано другим исключением).
     */
    String rootCause;
    /**
     * Имя класса, в котором произошло исключение.
     */
    String className;
    /**
     * Имя метода, в котором произошло исключение.
     */
    String methodName;
    /**
     * Стек-трейс.
     */
    String stackTrace;
    /**
     * Время возникновения ошибки.
     */
    LocalDateTime timestamp;
    /**
     * URL запроса (если есть).
     */
    @Nullable String requestUrl;
}
