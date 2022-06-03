package com.example.friendship.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "member_tb1")
public class Member {

    @Id
    @NotBlank(message = "아이디를 입력해주세요.")
    private String mid;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String mpw;

    @Email(message = "이메일 형식을 맞춰주세요.")
    private String memail;

    @CreationTimestamp
    private LocalDateTime regdate;

    @UpdateTimestamp
    private LocalDateTime updatedate;
}

