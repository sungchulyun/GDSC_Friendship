package com.example.friendship.controller;

import com.example.friendship.entity.Member;
import com.example.friendship.service.memberService;
import com.example.friendship.session.SessionConstants;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller

public class memberController {

    @Autowired
    private memberService memberservice;



    @GetMapping("login")
    public String login(@ModelAttribute Member member) {

         return "/login";
    }

    @PostMapping("/loginPro")
    public String loginPro(@ModelAttribute Member member, BindingResult bindingResult, HttpServletRequest request,
                           Model model) {


        Member loginmember = memberservice.login(member, member.getMid(), member.getMpw(), bindingResult).get();

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginmember);


        return "redirect:/";

    }

    @GetMapping("/")
    public String loginHome(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if(session == null){
            return "/index";
        }
        Member loginmember2 = (Member) session.getAttribute(SessionConstants.LOGIN_MEMBER);

        if(loginmember2==null){
            return "/index";
        }

       model.addAttribute("member", loginmember2);
       return "loginhome";


    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, Model model){

        System.out.println(request.getSession());
        request.getSession(false).invalidate();
        System.out.println(request.getSession());

        return "redirect:/";

    }

    @PostMapping("/join")
    public String join(){

        return "join";
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




