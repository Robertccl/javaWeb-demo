package com.ccl.reponse;

import java.util.ArrayList;
import java.util.List;

import com.ccl.entity.Users;

public class UsersListResponse extends BaseResponse {
    private List<Users> userList;

    public UsersListResponse(Integer code, List<Users> userList) {
        super(code);
        setUsersList(userList);
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUsersList(List<Users> userList) {
        this.userList = new ArrayList<>();
        
        for (Users user : userList) {
            Users tempUser = new Users();
            tempUser.setPassWord("******");
            tempUser.setUserName(user.getUserName());
            tempUser.setBirthDate(user.getBirthDate());
            tempUser.setSex(user.getSex());
            tempUser.setLevel(user.getLevel());
            this.userList.add(tempUser);
        }
        
    }
    
}

