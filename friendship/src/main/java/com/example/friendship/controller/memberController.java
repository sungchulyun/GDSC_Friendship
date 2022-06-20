package com.example.friendship.controller;

import com.example.friendship.entity.Member;
import com.example.friendship.service.loginService;
import com.example.friendship.session.SessionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller

public class memberController {

    @Autowired
    private loginService memberservice;


    @GetMapping("login")
    public String login(@ModelAttribute Member member) {

         return "/login";
    }

    @PostMapping("/loginPro")
    public String loginPro(@ModelAttribute Member member, @Valid Member Member, BindingResult bindingResult,
                           HttpServletRequest request, Model model) {

        if (bindingResult.hasErrors()) {
            return "/login";
        }


        Member loginmember = memberservice.login(member.getMid(), member.getMpw());

        if (loginmember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginmember);

        return "/loginhome";

    }

    @GetMapping("/")
    public String loginHome(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false)Member loginmember, Model model){

        if(loginmember == null){

            return "/home";
        }
        model.addAttribute("member", loginmember);

       return "loginhome";


    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, Model model){


        HttpSession session=  request.getSession(false);
        session.invalidate();


        return "redirect:/";

    }

    @GetMapping("/join")
    public String join(@ModelAttribute Member member){

        return "/join";
    }

    @PostMapping("/joinPro")
    public String joinPro(@ModelAttribute Member member, @Valid Member Member, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "/join";
        }

        memberservice.signIn(member);

        return "/home";
    }



    /*@GetMapping("testing")
    public void test(){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://apis.openapi.sk.com/tmap/routes/routeOptimization10")
                .post(null)
                .addHeader("Accept", "application/json")
                .addHeader("appKey", "l7xxfdc75c1509a74ecdba02bf5e024ee9d5")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e){
            System.out.println (e.toString());
        }

     */

    }




