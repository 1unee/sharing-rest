package com.oneune.sharing.rest.controller.v1;

import com.oneune.sharing.rest.config.WebConfig;
import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.service.ThingService;
import com.oneune.sharing.rest.store.dto.ThingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WebConfig.API_ROOT_URL + "v1/thing")
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ThingController implements CRUDed<ThingDto> {

    ThingService thingService;

    @Operation(summary = "Создание вещи")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = ThingDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PostMapping
    public ThingDto post(@Parameter(required = true) @RequestBody ThingDto thingDto) {
        return thingService.post(thingDto);
    }

    @Operation(summary = "Изменение вещи")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = ThingDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PutMapping("{id}")
    public ThingDto put(@Parameter(name = "id", example = "1", required = true)
                        @PathVariable(name = "id") Long thingId,
                        @Parameter(required = true)
                        @RequestBody ThingDto thingDto) {
        return thingService.put(thingId, thingDto);
    }

    @Operation(summary = "Удаление вещи")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = ThingDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @DeleteMapping("{id}")
    public ThingDto deleteById(@Parameter(name = "id", example = "1", required = true)
                               @PathVariable(name = "id") Long thingId) {
        return thingService.deleteById(thingId);
    }

    @Operation(summary = "")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = ThingDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @GetMapping("{id}")
    public ThingDto getById(@Parameter(name = "id", example = "1", required = true)
                            @PathVariable(name = "id") Long thingId) {
        return thingService.getById(thingId);
    }

    @Operation(summary = "Получение вещи")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    public List<ThingDto> getAll() {
        return thingService.getAll();
    }
}
