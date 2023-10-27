package com.mimaraslan.controllermvc;

import com.mimaraslan.repository.entity.Musteri;
import com.mimaraslan.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginMvcController {
    private final MusteriService musteriService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(String user,String password){
        return musteriService.doLogin(user,password) ? new ModelAndView("redirect:http://localhost:8080/musteri") : new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(String name, String email, String username, String password){
        musteriService.save(Musteri.builder()
                        .ad(name)
                        .email(email)
                        .username(username)
                        .password(password)
                .build());
        return new ModelAndView("login");
    }
}
