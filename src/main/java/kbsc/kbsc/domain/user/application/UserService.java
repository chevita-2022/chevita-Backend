package kbsc.kbsc.domain.user.application;

import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.dao.impl.UserDAOImpl;
import kbsc.kbsc.domain.user.domain.Users;
import kbsc.kbsc.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

//TODO: 데이터베이스 연결을 위한 임시 코드 , 소셜 로그인 성공 후 수정해야함
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAOImpl userDAO;
    private final EntityManager em;

    @Transactional
    public Users createUser(UserDto userDto){
        Users newUser = new Users();
        newUser.setUserIdx(userDto.getUserIdx());
        newUser.setPostList(userDto.getPostList());
        newUser.setUserNickName(userDto.getUserNickName());
        newUser.setUserAddress(userDto.getUserAddress());
        newUser.setProfileImgUrl(userDto.getProfileImgUrl());
        newUser.setCreatedAt(userDto.getCreatedAt());
        newUser.setUpdatedAt(userDto.getUpdatedAt());
        newUser.setIntroduction(userDto.getIntroduction());
        newUser.setVital(userDto.getVital());
        newUser.setUserhashTag(userDto.getUserhashTag());

        return userDAO.saveUser(newUser);
    }

}
