package kbsc.kbsc.domain.post.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kbsc.kbsc.domain.post.entity.Post;

import javax.persistence.EntityManager;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Post> findNotDeletedByBoardId(Long boardId) {
        return Optional.empty();
    }
}
