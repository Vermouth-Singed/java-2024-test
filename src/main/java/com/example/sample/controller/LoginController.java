package com.example.sample.controller;

import com.example.sample.dto.request.LoginRequestDTO;
import com.example.sample.dto.response.LoginResponseDTO;
import com.example.sample.enums.LoginEnum;
import com.example.sample.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@Tag(name = "로그인", description = "로그인 API")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping()
    @Operation(summary = "로그인 상태조회", description = "로그인 상태조회")
    public LoginResponseDTO loginCheck(HttpSession httpSession) {
        return loginService.loginCheck(httpSession.getAttribute(LoginEnum.LOGIN_INFO.code()));
    }

    @PostMapping
    @Operation(summary = "로그인", description = "로그인")
    public LoginResponseDTO login(HttpSession httpSession, @RequestBody LoginRequestDTO loginRequestDTO) {
        return loginService.login(httpSession, loginRequestDTO);
    }

    @DeleteMapping()
    @Operation(summary = "로그아웃", description = "로그아웃")
    public LoginResponseDTO logout(HttpSession httpSession) {
        return loginService.logout(httpSession);
    }
}
