package com.oneune.sharing.rest.store.dto.core;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class AbstractCreatableDto extends AbstractDto {
    @Schema(description = "Время создания объекта (проставляется автоматически)")
    Instant createdAt;
}
