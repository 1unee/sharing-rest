package com.oneune.sharing.rest.store.dto;

import com.oneune.sharing.rest.store.dto.core.AbstractAuditableDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * @see com.oneune.sharing.rest.store.entity.UserEntity
 */
@Schema(description = "DTO пользователя")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class UserDto extends AbstractAuditableDto {
    @Schema(description = "Имя пользователя (из телеграмма)", required = true)
    String username;
    @Schema(description = "ID пользователя в телеграмме", required = true)
    Long telegramId;
    @Schema(description = "ID чата, в котором пользователь использует бота", required = true)
    Long telegramChatId;
    @Schema(description = "Рейтинг пользователя")
    Float rating;
}
