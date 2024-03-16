package uz.ilmnajot.adminpanel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ilmnajot.adminpanel.model.common.ApiResponse;
import uz.ilmnajot.adminpanel.model.dto.LoginDto;
import uz.ilmnajot.adminpanel.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public HttpEntity<ApiResponse> login(@RequestBody LoginDto dto){
        ApiResponse login = authService.login(dto);
        return login != null
                ? ResponseEntity.status(HttpStatus.OK).body(login)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
