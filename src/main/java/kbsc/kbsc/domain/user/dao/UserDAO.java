package kbsc.kbsc.domain.user.dao;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.user.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    Users saveUser(Users userEntity);
    Users findUserByIdx(Long userIdx);
    Optional<Users> updateInfo(Long targetIdx, Users user);
    //List<Post> findNanumHistory(Long userIdx);

}