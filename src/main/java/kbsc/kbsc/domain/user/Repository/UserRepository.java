package kbsc.kbsc.domain.user.Repository;

import kbsc.kbsc.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Repository가 사용할 Entity, Entity에서 사용되는 PK>
public interface UserRepository extends JpaRepository<User, Integer> {
}