package kbsc.kbsc.domain.user.dao;

import kbsc.kbsc.domain.user.domain.Users;

public interface UserDAO {

    Users saveUser(Users userEntity);
    Users findUserByIdx(Integer userIdx);

}