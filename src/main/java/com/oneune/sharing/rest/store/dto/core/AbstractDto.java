package com.oneune.sharing.rest.store.dto.core;

import com.oneune.sharing.rest.store.core.Identified;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public abstract class AbstractDto implements Identified {
    @Schema(description = "ID объекта")
    @Setter(AccessLevel.PRIVATE)
    Long id;
}
