package com.dev.shopserver.controller;


import com.dev.shopserver.common.exception.ShopServerException;
import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.service.impl.UserServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;


//RestController
/**
 * Controller와 ResponseBody가 결합된 어노테이션. 컨트롤러 클래스에 쓰임
 * 컨트롤러 클래스 하위 메서드에 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있다.
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserDTO getUserInfo(@RequestBody String userId){
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

    public void login(){

    }

    public void logout(){

    }

    @PatchMapping("/updatepassword")
    public UserDTO updatePassword(@RequestBody UpdateUserPasswordRequest updateUserPasswordRequest){
        String userId = updateUserPasswordRequest.getUserId();
        String beforePassword = updateUserPasswordRequest.getBeforePassword();
        String afterPassword = updateUserPasswordRequest.getAfterPassword();
        return userService.updatePassword(userId, beforePassword, afterPassword);
    }

    @DeleteMapping("")
    public String deleteUser(@RequestBody String userId) throws ShopServerException {
        if(userId == null || userId.length() == 0){
            throw new NullPointerException("값을 입력해주세요.");
        }
        userService.deleteUser(userId);
        return userId;
    }

    /**
     * 아래 클래스는 password update할 때 말고는 쓰지 않기 때문에
     * Controller 클래스의 InnerCLass로 사용
     */
    @Getter
    @Setter
    private static class UpdateUserPasswordRequest{
        private String userId;
        private String beforePassword;
        private String afterPassword;
    }
}

