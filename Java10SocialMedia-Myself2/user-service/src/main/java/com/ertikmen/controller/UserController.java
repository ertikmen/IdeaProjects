package com.ertikmen.controller;


import com.ertikmen.dto.request.UserProfileUpdateRequestDto;
import com.ertikmen.dto.request.UserSaveRequestDto;
import com.ertikmen.dto.response.UserProfileFindAllResponseDto;
import com.ertikmen.dto.response.UserProfileUpdateResponseDto;
import com.ertikmen.repository.entity.UserProfile;
import com.ertikmen.repository.enums.EStatus;
import com.ertikmen.service.UserService;
import com.ertikmen.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.ertikmen.constant.EndPoints.*;


@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtTokenManager jwtTokenManager;


    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto){

        return ResponseEntity.ok(userService.createNewUser(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<String> activateStatus(@RequestParam String token){

        return ResponseEntity.ok(userService.activateStatus(token));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<String> updateUserProfile(@Valid @RequestBody UserProfileUpdateResponseDto dto){


        return ResponseEntity.ok((userService.updateUserProfile2(dto)));

    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<UserProfileFindAllResponseDto>> findAll(){

        return ResponseEntity.ok(userService.findAllUserProfile());
    }

    @GetMapping("/find_by_username/{username}")
    public ResponseEntity<UserProfile> findByUsername(@PathVariable String username){

        return ResponseEntity.ok(userService.findByUsername(username));

    }

    @GetMapping("find_by_status/{status}")
    public ResponseEntity<List<UserProfile>> findByStatus(@PathVariable EStatus status){
        return ResponseEntity.ok(userService.findByStatus(status));
    }

    @GetMapping("find_by_status2/{status}")
    public ResponseEntity<List<UserProfile>> findByStatus2(@PathVariable String status){
        return ResponseEntity.ok(userService.findByStatus2(status));
    }

    @DeleteMapping(DELETE_BY_ID)
    public ResponseEntity<String> deleteById(@RequestParam Long id){

        return ResponseEntity.ok(userService.deleteUserProfile(id));
    }

}
