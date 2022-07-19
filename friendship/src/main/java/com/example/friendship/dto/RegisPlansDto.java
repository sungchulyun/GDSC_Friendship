package com.example.friendship.dto;

import com.example.friendship.entity.Plans;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisPlansDto {

    @NotBlank(message = "제목을 입력하세요.")
    private String plan_title;

    @NotBlank(message = "일정을 소개하세요.")
    private String plan_info;

    @NotBlank(message = "날짜를 선택하세요.")
    private String plan_date;

    @NotBlank(message = "이미지를 골라주세요.")
    private String plan_img;

    public Plans toEntity(){
        Plans build = Plans.builder()
                .plan_title(plan_title)
                .plan_info((plan_info))
                .plan_date((plan_date))
                .plan_img((plan_img))
                .build();

        return build;
    }
}
