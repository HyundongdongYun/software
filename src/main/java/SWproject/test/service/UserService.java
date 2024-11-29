package SWproject.test.service;

import SWproject.test.domain.User;
import SWproject.test.domain.enums.Allergy;
import SWproject.test.dto.request.RegisterRequestDto;
import SWproject.test.dto.response.RegisterResponseDto;
import SWproject.test.exception.ApiException;
import SWproject.test.exception.ErrorDefine;
import SWproject.test.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    public void updateUserAllergies(Long userId, Allergy allergy) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));
        user.setAllergy(allergy);
        userRepository.save(user);
    }
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto){
//        User user = userRepository.findById(10l)
//                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        if (userRepository.findByUserId(registerRequestDto.getUserId()).isPresent())
            throw new ApiException(ErrorDefine.USER_EXIST);
        User user = User.builder()
                .userId(registerRequestDto.getUserId())
                .password(registerRequestDto.getPassword())
                .name(registerRequestDto.getName())
                .age(registerRequestDto.getAge())
                .gender(registerRequestDto.getGender())
                .height(registerRequestDto.getHeight())
                .weight(registerRequestDto.getWeight())
                .med_history(registerRequestDto.getMed_history())
                .allergy(registerRequestDto.getAllergy()) // 다중 값 전달
                .weight_goal(registerRequestDto.getWeight_goal())
                .build();
            userRepository.save(user);

//             RegisterResponseDto registerResponseDto = RegisterResponseDto.builder()
//                    .message("회원가입이 잘 되었습니다")
//                    .build();

        return RegisterResponseDto.builder()
                    .message("회원가입이 잘 되었습니다")
                    .build();
    }
}
