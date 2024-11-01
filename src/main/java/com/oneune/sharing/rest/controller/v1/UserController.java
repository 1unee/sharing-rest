package com.oneune.sharing.rest.controller.v1;

import com.oneune.sharing.rest.config.WebConfig;
import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.service.UserService;
import com.oneune.sharing.rest.store.dto.UserDto;
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
@RequestMapping(WebConfig.API_ROOT_URL + "v1/user")
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController implements CRUDed<UserDto> {

    UserService userService;

    @Operation(summary = "Создание пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = UserDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @PostMapping
    @Override
    public UserDto post(@Parameter(required = true) @RequestBody UserDto user) {
        return userService.post(user);
    }

    @Operation(summary = "Изменение пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = UserDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @PutMapping("{id}")
    @Override
    public UserDto put(@Parameter(name = "id", example = "1", required = true)
                       @PathVariable(name = "id") Long userId,
                       @Parameter(required = true)
                       @RequestBody UserDto user) {
        return userService.put(userId, user);
    }

    @Operation(summary = "Удаление пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = UserDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @DeleteMapping("{id}")
    @Override
    public UserDto deleteById(@Parameter(name = "id", example = "1", required = true)
                              @PathVariable(name = "id") Long userId) {
        return userService.deleteById(userId);
    }

    @Operation(summary = "Получение пользователя")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = UserDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @GetMapping("{id}")
    @Override
    public UserDto getById(@Parameter(name = "id", example = "1", required = true)
                           @PathVariable(name = "id") Long userId) {
        return userService.getById(userId);
    }

    @Operation(summary = "Получение всех пользователей")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = UserDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    public List<UserDto> getAll() {
        return userService.getAll();
    }
}
