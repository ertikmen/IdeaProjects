package com.ertikmen.manager;


import com.ertikmen.dto.request.AuthUpdateRequestDto;
import com.ertikmen.dto.request.UserSaveRequestDto;
import com.ertikmen.dto.response.UserProfileFindAllResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ertikmen.constant.EndPoints.*;

@FeignClient(url="http://localhost:7072/api/v1/user",decode404 = true,name="elastic-userprofile")
public interface IUserManager {

    @GetMapping(FIND_ALL)
    ResponseEntity<List<UserProfileFindAllResponseDto>> findAll();
    


}
