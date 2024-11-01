package com.oneune.sharing.rest.controller.v1;

import com.oneune.sharing.rest.config.WebConfig;
import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.service.PaymentService;
import com.oneune.sharing.rest.store.dto.PaymentDto;
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
@RequestMapping(WebConfig.API_ROOT_URL + "v1/payment")
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PaymentController implements CRUDed<PaymentDto> {

    PaymentService paymentService;

    @Operation(summary = "Создании платежа")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PaymentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PostMapping
    public PaymentDto post(@Parameter(required = true) @RequestBody PaymentDto paymentDto) {
        return paymentService.post(paymentDto);
    }

    @Operation(summary = "Изменение платежа")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PaymentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PutMapping("{id}")
    public PaymentDto put(@Parameter(name = "id", example = "1", required = true)
                          @PathVariable(name = "id") Long paymentId,
                          @Parameter(required = true)
                          @RequestBody PaymentDto paymentDto) {
        return paymentService.put(paymentId, paymentDto);
    }

    @Operation(summary = "Удаление платежа")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PaymentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @DeleteMapping("{id}")
    public PaymentDto deleteById(@Parameter(name = "id", example = "1", required = true)
                                 @PathVariable(name = "id") Long paymentId) {
        return paymentService.deleteById(paymentId);
    }

    @Operation(summary = "Получение платежа")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PaymentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @GetMapping("{id}")
    public PaymentDto getById(@Parameter(name = "id", example = "1", required = true)
                              @PathVariable(name = "id") Long paymentId) {
        return paymentService.getById(paymentId);
    }

    @Operation(summary = "Получение всех платежей")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    public List<PaymentDto> getAll() {
        return paymentService.getAll();
    }
}
