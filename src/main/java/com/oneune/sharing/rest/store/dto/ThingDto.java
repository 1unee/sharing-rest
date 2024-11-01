package com.oneune.sharing.rest.store.dto;

import com.oneune.sharing.rest.store.dto.core.AbstractAuditableDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @see com.oneune.sharing.rest.store.entity.ThingEntity
 */
@Schema(description = "DTO вещи для сделки")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class ThingDto extends AbstractAuditableDto {
    @Schema(description = "Имя", required = true)
    String name;
    @Schema(description = "Описание")
    String description;
    @Schema(description = "Цена (в рублях)", required = true)
    BigDecimal price;
    @Schema(description = "Объявление, куда будет прикреплена вещь", required = true)
    PostDto post;
    @Schema(description = "Тип вещи", required = true)
    DictionaryValueDto type;
}
