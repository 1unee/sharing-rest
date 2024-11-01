package com.oneune.sharing.rest.store.dto;

import com.oneune.sharing.rest.store.dto.core.AbstractAuditableDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Schema(description = "DTO объявления, который должен содержать хотя бы одну вещь для сделки")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class PostDto extends AbstractAuditableDto {
    @Schema(description = "Заголовок объявления", required = true)
    String title;
    @Schema(description = "Описание объявления")
    String description;
    @Schema(description = "Продавец", required = true)
    UserDto seller;
    @Schema(description = "Вещи для сделки", required = true)
    List<ThingDto> things;
}
