package com.oneune.sharing.rest.controller.v1;

import com.oneune.sharing.rest.config.WebConfig;
import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.service.PostService;
import com.oneune.sharing.rest.store.dto.PostDto;
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
@RequestMapping(WebConfig.API_ROOT_URL + "v1/post")
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PostController implements CRUDed<PostDto> {

    PostService postService;

    @Operation(summary = "Создание объявления")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PostDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PostMapping
    public PostDto post(@Parameter(required = true) @RequestBody PostDto postDto) {
        return postService.post(postDto);
    }

    @Operation(summary = "Изменение объявления")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PostDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @PutMapping("{id}")
    public PostDto put(@Parameter(name = "id", example = "1", required = true)
                       @PathVariable(name = "id") Long postId,
                       @Parameter(required = true)
                       @RequestBody PostDto postDto) {
        return postService.put(postId, postDto);
    }

    @Operation(summary = "Удаление объявления")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PostDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @DeleteMapping("{id}")
    public PostDto deleteById(@Parameter(name = "id", example = "1", required = true)
                              @PathVariable(name = "id") Long postId) {
        return postService.deleteById(postId);
    }

    @Operation(summary = "Получение объявления")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(schema = @Schema(implementation = PostDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    @GetMapping("{id}")
    public PostDto getById(@PathVariable(name = "id") Long postId) {
        return postService.getById(postId);
    }

    @Operation(summary = "Получение всех объявлений")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Неизвестная ошибка")
    })
    @Override
    public List<PostDto> getAll() {
        return postService.getAll();
    }
}
