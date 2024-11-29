package SWproject.test.domain;

import SWproject.test.domain.enums.Allergy;
import SWproject.test.domain.enums.Gender;
import SWproject.test.domain.enums.Weight_goal;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false,updatable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column
    private Integer age;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Column
    private String med_history;

    @Column
    private Allergy allergy;

    @Column
    @Enumerated(EnumType.STRING)
    private Weight_goal weight_goal;

    @Builder
    public User(String userId, String name, String password, Integer age,
                Gender gender, Double height, Double weight, String med_history, Allergy allergy, Weight_goal weight_goal) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.med_history = med_history;
        this.allergy = allergy;
        this.weight_goal = weight_goal;
    }

}
