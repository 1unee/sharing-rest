package com.oneune.sharing.rest.store.dto;

import com.oneune.sharing.rest.store.dto.core.AbstractAuditableDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Schema(description = "DTO конкретного значения из справочника")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class DictionaryValueDto extends AbstractAuditableDto {
    @Schema(description = "Конкретное значение из справочника")
    String value;
}
