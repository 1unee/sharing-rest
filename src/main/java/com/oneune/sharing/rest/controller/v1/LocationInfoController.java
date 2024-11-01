package com.oneune.sharing.rest.controller.v1;

import com.oneune.sharing.rest.config.WebConfig;
import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.service.LocationInfoService;
import com.oneune.sharing.rest.store.dto.LocationInfoDto;
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
@RequestMapping(WebConfig.API_ROOT_URL + "v1/location-info")
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LocationInfoController implements CRUDed<LocationInfoDto> {

    LocationInfoService locationInfoService;

    @Operation(summary = "Создание подробной информации о местоположении пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = LocationInfoDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PostMapping
    public LocationInfoDto post(@Parameter(required = true) @RequestBody LocationInfoDto locationInfoDto) {
        return locationInfoService.post(locationInfoDto);
    }

    @Operation(summary = "Изменение подробной информации о местоположении пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = LocationInfoDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PutMapping("{id}")
    public LocationInfoDto put(@Parameter(name = "id", example = "1", required = true)
                               @PathVariable(name = "id") Long locationInfoId,
                               @Parameter(required = true)
                               @RequestBody LocationInfoDto locationInfoDto) {
        return locationInfoService.put(locationInfoId, locationInfoDto);
    }

    @Operation(summary = "Удаление подробной информации о местоположении пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = LocationInfoDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @DeleteMapping("{id}")
    public LocationInfoDto deleteById(@Parameter(name = "id", example = "1", required = true)
                                      @PathVariable(name = "id") Long locationInfoId) {
        return locationInfoService.deleteById(locationInfoId);
    }

    @Operation(summary = "Получение подробной информации о местоположении пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = LocationInfoDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @GetMapping("{id}")
    public LocationInfoDto getById(@Parameter(name = "id", example = "1", required = true)
                                   @PathVariable(name = "id") Long locationInfoId) {
        return locationInfoService.getById(locationInfoId);
    }

    @Operation(summary = "Получение всех подробной информации о местоположении всех пользователей")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    public List<LocationInfoDto> getAll() {
        return locationInfoService.getAll();
    }
}
