package kbsc.kbsc.domain.user.dao.impl;

import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.dao.UserDAO;
import kbsc.kbsc.domain.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl implements UserDAO {

    UserRepository userRepository;

    //의존성 주입, 싱글톤 빈으로 미리 올려둠
    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User userEntity) {
        userRepository.save(userEntity);
        return userEntity;
    }


    @Override
    public User findUserByIdx(int userIdx) {

        User userEntity= userRepository.findById(userIdx).orElseThrow(IllegalArgumentException::new);
        return userEntity;

    }
}