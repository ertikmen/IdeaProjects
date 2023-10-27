package com.mimaraslan.controllermvc;

import com.mimaraslan.models.MusteriModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProjeMvcController {

    @GetMapping("/musteri")
    public ModelAndView musteriList(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("musteri");
        List<String> musteriler= Arrays.asList("D","C","A","E","B");
        modelAndView.addObject("baslik","Muşteri Listesi TH");
        modelAndView.addObject("musteriliste",musteriler);

        MusteriModel model= MusteriModel.builder()
                .baslik("Müşteri İşlemleri")
                .adres("İstanbul")
                .menuListesi(Arrays.asList("Müşteri","Urun","Satış"))
                .musteriListesi(musteriler)
                .build();
        modelAndView.addObject("modelkey",model);
        return modelAndView;
    }
}
