package com.oneune.sharing.rest.store.dto;

import com.oneune.sharing.rest.store.dto.core.AbstractAuditableDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Schema(description = "DTO платежа")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class PaymentDto extends AbstractAuditableDto {
    @Schema(description = "Покупатель", required = true)
    UserDto buyer;
    @Schema(description = "Покупаемая вещь", required = true)
    ThingDto thing;
    @Schema(description = "Статус платежа", required = true)
    DictionaryValueDto status;
}
