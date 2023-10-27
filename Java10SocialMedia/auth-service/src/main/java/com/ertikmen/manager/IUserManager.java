package com.ertikmen.manager;


import com.ertikmen.dto.request.UserSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.ertikmen.constant.EndPoints.*;

@FeignClient(url="http://localhost:7072/api/v1/user",decode404 = true,name="auth-userprofile")
public interface IUserManager {

    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto);

    @PostMapping(ACTIVATE_STATUS)
    ResponseEntity<String> activateStatus(@RequestParam String token);

    @DeleteMapping(DELETE_BY_ID)
    public ResponseEntity<String> deleteById(@RequestParam Long id);



}
