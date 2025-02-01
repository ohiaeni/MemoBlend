package com.memoblend.web.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.memoblend.applicationcore.applicationservice.UserApplicationService;
import com.memoblend.applicationcore.user.User;
import com.memoblend.applicationcore.user.UserNotFoundException;
import com.memoblend.web.controller.dto.user.GetUserResponse;
import com.memoblend.web.controller.dto.user.GetUsersResponse;
import com.memoblend.web.controller.dto.user.PostUserRequest;
import com.memoblend.web.controller.mapper.user.GetUserReponseMapper;
import com.memoblend.web.controller.mapper.user.GetUsersResponseMapper;
import com.memoblend.web.controller.mapper.user.PostUserRequestMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

/**
 * ユーザー情報の操作を行うコントローラークラスです。
 */
@RestController
@RequestMapping("api/user")
@Tag(name = "User", description = "ユーザーの情報にアクセスするAPI")
@AllArgsConstructor
public class UserController {
  @Autowired
  UserApplicationService userApplicationService;

  /**
   * ユーザーを全件取得します。
   * 
   * @return ユーザー情報。
   */
  @GetMapping("")
  public ResponseEntity<GetUsersResponse> getUsers() {
    List<User> users = userApplicationService.getUsers();
    GetUsersResponse response = GetUsersResponseMapper.convert(users);
    return ResponseEntity.ok().body(response);
  }

  /**
   * ユーザー情報を取得します。
   * 
   * @param id ユーザーID
   * @return ユーザー情報
   */
  @GetMapping("{id}")
  public ResponseEntity<GetUserResponse> getUser(@PathVariable("id") long id) {
    User user = null;
    try {
      user = userApplicationService.getUser(id);
    } catch (UserNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
    GetUserResponse response = GetUserReponseMapper.convert(user);
    return ResponseEntity.ok().body(response);
  }

  /**
   * ユーザー情報を登録します。
   * 
   * @param request ユーザー情報
   * @return 登録結果
   */
  @PostMapping
  public ResponseEntity<?> postUser(@RequestBody PostUserRequest request) {
    User user = PostUserRequestMapper.convert(request);
    User addedUser = userApplicationService.addUser(user);
    return ResponseEntity.created(URI.create("/api/user/" + addedUser.getId())).build();
  }
}
