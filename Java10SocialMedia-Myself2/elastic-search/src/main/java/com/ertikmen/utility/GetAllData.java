package com.ertikmen.utility;


import com.ertikmen.dto.response.UserProfileFindAllResponseDto;
import com.ertikmen.manager.IUserManager;
import com.ertikmen.mapper.IElasticMapper;
import com.ertikmen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllData {

    private final IUserManager userManager;

    private final UserService userService;


//    @PostConstruct
    public void initData(){

        List<UserProfileFindAllResponseDto> list=userManager.findAll().getBody();

        userService.saveAll(IElasticMapper.INSTANCE.toUserProfiles(list));


    }



}
