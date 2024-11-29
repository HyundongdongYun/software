package SWproject.test.controller;

import SWproject.test.dto.request.RegisterRequestDto;
import SWproject.test.dto.response.RegisterResponseDto;
import SWproject.test.dto.response.ResponseDto;
import SWproject.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseDto<RegisterResponseDto> register(
            @RequestBody RegisterRequestDto registerRequestDto
            ) {
        return new ResponseDto<>(userService.register(registerRequestDto));
    }


}
