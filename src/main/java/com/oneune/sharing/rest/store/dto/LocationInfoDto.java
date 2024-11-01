package com.oneune.sharing.rest.store.dto;

import com.oneune.sharing.rest.store.dto.core.AbstractAuditableDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Schema(description = "DTO подробная информации о местоположении пользователя")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class LocationInfoDto extends AbstractAuditableDto {
    @Schema(description = "Подъезд", required = true)
    String porch;
    @Schema(description = "Код от домофона подъезда", required = true)
    String porchCode;
    @Schema(description = "Этаж", required = true)
    String floor;
    @Schema(description = "Квартира", required = true)
    String flat;
    @Schema(description = "Дополнительная информация")
    String description;
    @Schema(description = "Здание местоположения", required = true)
    DictionaryValueDto location;
}
