package org.example.controller;

import org.example.store.entity.User;
import org.example.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Управление пользователями (User)")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Добавление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Пользователь добавлен"),
            @ApiResponse(responseCode = "401",
                    description = "В случае если запрос отправлен без токена или с недействительным " +
                            "токеном возвращается ошибка 401 и строка с ошибкой в теле запроса.",
                    content = @Content(schema = @Schema(implementation = String.class))
            )
    })
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
       return  ResponseEntity.ok(userService.create(user));
    }

    @Operation(summary = "Отображение пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Пользователи отображены"),
            @ApiResponse(responseCode = "404",
                    description = "Сервер не может найти запрашиваемый ресурс." +
                            " Код этого ответа, наверно, самый известный из-за частоты его появления в вебе. ",
                    content = @Content(schema = @Schema(implementation = String.class))
            )
    })
    @GetMapping
    public ResponseEntity<List<User>> read(){
        final List<User> users = userService.readAll();
        return users!=null && !users.isEmpty()
                ? new ResponseEntity<>(users,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Отображение пользователя по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Пользователь отображен"),
            @ApiResponse(responseCode = "404",
                    description = "Сервер не может найти запрашиваемый ресурс." +
                            " Код этого ответа, наверно, самый известный из-за частоты его появления в вебе. ",
                    content = @Content(schema = @Schema(implementation = String.class))
            )
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id){
        final User user = userService.read(id);
        return user!=null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Есть два типа изменений @Patch и @Put. Метод @Patch изменняет точечно, а Put, как передал
    @Operation(summary = "Обновление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Пользователь обновлен"),
            @ApiResponse(responseCode = "404",
                    description = "Сервер не может найти запрашиваемый ресурс. " +
                            "Код этого ответа, наверно, самый известный из-за частоты его появления в вебе. ",
                    content = @Content(schema = @Schema(implementation = String.class))
            )
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable(name = "id") int id, @RequestBody User user){
        return  ResponseEntity.ok(userService.update(user,id));
    }

    @Operation(summary = "Удаление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Пользователь удален"),
            @ApiResponse(responseCode = "404",
                    description = "Сервер не может найти запрашиваемый ресурс. " +
                            "Код этого ответа, наверно, самый известный из-за частоты его появления в вебе. ",
                    content = @Content(schema = @Schema(implementation = String.class))
            )
    })
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id){
        userService.delete(id);
    }
}
