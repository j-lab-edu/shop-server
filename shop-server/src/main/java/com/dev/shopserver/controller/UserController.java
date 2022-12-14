package com.dev.shopserver.controller;


import com.dev.shopserver.aop.LoginCheck;
import com.dev.shopserver.common.exception.ShopServerException;
import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.service.impl.UserServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


//RestController
/**
 * Controller와 ResponseBody가 결합된 어노테이션. 컨트롤러 클래스에 쓰임
 * 컨트롤러 클래스 하위 메서드에 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있다.
 *
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @LoginCheck(checkLevel = LoginCheck.UserLevel.USER)
    @GetMapping("/user")
    public UserDTO getUserInfo(@RequestParam String userId){
        if(userId == null || userId.length() == 0){
            throw new NullPointerException("값을 입력해주세요.");
        }
        return userService.getUserInfo(userId);
    }

    @PostMapping("/signup")
    public UserDTO signUp(@RequestBody UserDTO userDTO) throws ShopServerException {
        if (UserDTO.hasNullDataForSignUp(userDTO)){
            throw new NullPointerException("필수 데이터를 입력 바랍니다.");
        }
        userService.register(userDTO);
        return userDTO;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequest loginRequest, HttpServletRequest req){

        HttpSession session = req.getSession();
        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        UserDTO userInfo = userService.login(userId, password);

        if(userInfo == null){
            log.error("login ERROR! Check userId & password.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            String userStatus = userInfo.getStatus();
            session.setAttribute("LOGIN_USER_ID", userId);
            session.setAttribute("LOGIN_USER_STATUS", userStatus);
        }

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }
    @PutMapping("/logout")
    public void logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.invalidate();
    }

    @PatchMapping("/updatepassword")
    public UserDTO updatePassword(@RequestBody UpdateUserPasswordRequest updateUserPasswordRequest)
            throws ShopServerException {
        String userId = updateUserPasswordRequest.getUserId();
        String beforePassword = updateUserPasswordRequest.getBeforePassword();
        String afterPassword = updateUserPasswordRequest.getAfterPassword();
        return userService.updatePassword(userId, beforePassword, afterPassword);
    }

    @LoginCheck(checkLevel = LoginCheck.UserLevel.USER)
    @DeleteMapping("")
    public String deleteUser(@RequestParam String userId) throws ShopServerException {
        if(userId == null || userId.length() == 0){
            throw new NullPointerException("값을 입력해주세요.");
        }
        userService.deleteUser(userId);
        return userId;
    }

    /**
     * password update할 때 말고는 쓰지 않기 때문에
     * Controller 클래스의 InnerClass로 사용
     */
    @Getter
    @Setter
    private static class UpdateUserPasswordRequest{
        private String userId;
        private String beforePassword;
        private String afterPassword;
    }

    @Getter
    @Setter
    private static class LoginRequest {
        private String userId;
        private String password;
    }

}

