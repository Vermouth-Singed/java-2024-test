package com.example.sample.service;

import com.example.sample.dto.request.LoginRequestDTO;
import com.example.sample.dto.response.LoginResponseDTO;
import com.example.sample.entity.LoginEntity;
import com.example.sample.enums.LoginEnum;
import com.example.sample.repository.LoginJPA;
import com.example.sample.repository.LoginQuerydsl;
import com.example.sample.vo.LoginVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginJPA loginJPA;
    private final LoginQuerydsl loginQuerydsl;

    public LoginService(LoginJPA loginJPA, LoginQuerydsl loginQuerydsl) {
        this.loginJPA = loginJPA;
        this.loginQuerydsl = loginQuerydsl;
    }

    public LoginResponseDTO loginCheck(Object loginVO) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

        if (loginVO instanceof LoginVO) {
            loginResponseDTO.setEmail(((LoginVO) loginVO).getEmail());
            loginResponseDTO.setSuccess(true);
        }

        return loginResponseDTO;
    }

    public LoginResponseDTO login(HttpSession httpSession, LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

//        Optional<LoginEntity> loginEntityOptional = loginJPA.findById(loginRequestDTO.getEmail());
        Optional<LoginEntity> loginEntityOptional = loginQuerydsl.findById(loginRequestDTO.getEmail());

        loginEntityOptional.ifPresentOrElse(loginEntity -> {
                String email = loginEntity.getEmail();

                LoginVO loginVO = LoginVO
                    .builder()
                    .email(email)
                    .build();

                httpSession.setAttribute(LoginEnum.LOGIN_INFO.code(), loginVO);

                loginResponseDTO.setEmail(email);
                loginResponseDTO.setSuccess(true);
            }, httpSession::invalidate);

        return loginResponseDTO;
    }

    public LoginResponseDTO logout(HttpSession httpSession) {
        httpSession.invalidate();

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setSuccess(true);

        return loginResponseDTO;
    }
}
