package com.oneune.sharing.rest.controller.v1;

import com.oneune.sharing.rest.config.WebConfig;
import com.oneune.sharing.rest.store.dto.DictionaryDto;
import com.oneune.sharing.rest.store.dto.DictionaryValueDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WebConfig.API_ROOT_URL + "v1/dictionary")
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DictionaryController {

    @Operation(
            summary = "Получение всего справочника",
            description = "Получение всех значений справочника по его названию"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = DictionaryDto.class), mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "500",
                    description = "Неизвестная ошибка"
            )
    })
    @GetMapping("{name}")
    public List<DictionaryValueDto> getDictionary(@Parameter(name = "name", examples = {
                                                        @ExampleObject(value = "location"),
                                                        @ExampleObject(value = "payment-status"),
                                                        @ExampleObject(value = "post-status"),
                                                        @ExampleObject(value = "thing-typ")
                                                  })
                                                  @PathVariable(name = "name") String dictionaryName) {
        return null; // todo: implement
    }
}
