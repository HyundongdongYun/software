package SWproject.test.dto.request;


import SWproject.test.domain.enums.Allergy;
import SWproject.test.domain.enums.Gender;
import SWproject.test.domain.enums.Weight_goal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String userId;
    private String password;
    private String name;
    private Integer age;
    private Gender gender;
    private Double height;
    private Double weight;
    private String med_history;
    private Allergy allergy;
    private Weight_goal weight_goal;
}
