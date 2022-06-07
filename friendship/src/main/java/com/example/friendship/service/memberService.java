package com.example.friendship.service;

import com.example.friendship.entity.Member;
import com.example.friendship.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class memberService {

    @Autowired
    private MemberRepository memberRepository;

    public void signIn(Member member) {

        memberRepository.save(member);

    }

    public Optional<Member> login(Member member, String mid, String mpw, BindingResult bindingResult) {


        Optional<Member> lgmember = memberRepository.findById(mid);


        if (member.getMid().equals(lgmember.get().getMid())) {

            if (member.getMpw().equals(lgmember.get().getMpw())) {
                System.out.println(member.getMpw());
                System.out.println("로그인 성공");
                return lgmember;
            }
        }
        return null;
    }
}
