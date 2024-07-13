package com.itheima._18动态代理举例2;

/**
  业务接口
 */
public interface UserService {
    String login(String loginName, String passWord);
    void deleteAll();
    void updateAll();
}
