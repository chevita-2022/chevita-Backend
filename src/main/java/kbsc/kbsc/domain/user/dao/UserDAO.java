package kbsc.kbsc.domain.user.dao;

import kbsc.kbsc.domain.user.domain.User;

public interface UserDAO {

    User saveUser(User userEntity);
    User findUserByIdx(int userIdx);

}
