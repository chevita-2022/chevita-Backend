package kbsc.kbsc.domain.post.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//https://github.com/SoohyeonB/23ideal-Backend/blob/master/src/main/java/com/example/itaminbackend/domain/board/constant/BoardConstants.java
public class PostConstants {
    @Getter
    @RequiredArgsConstructor
    public enum EPostController{
        LOCATION_ID_PATH("/{id}"),
        GET_METHOD("get"),
        DELETE_METHOD("delete"),
        UPDATE_METHOD("update");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum EPostResponseMessage{
        CREATE_POST_SUCCESS("게시글을 작성했습니다."),
        UPDATE_POST_SUCCESS("게시글을 수정했습니다."),
        GET_DETAIL_POST_SUCCESS("게시글을 조회했습니다."),
        DELETE_POST_SUCCESS("게시글을 삭제했습니다."),
        GET_ALL_DETAIL_POSTS_SUCCESS("게시글을 작성 시간순으로 조회했습니다.");
        private final String message;
    }

    @Getter
    @RequiredArgsConstructor
    public enum EPostType{
        VEGETABLE("채소"),
        FRUIT("과일"),
        GRAIN("쌀/잡곡"),
        MEAT_EGGS("정육/계란"),
        BAKERY("베이커리"),
        DAIRY("유제품"),
        SAUCE("소스"),
        KIMCHI_SIDEDISH("김치/반찬"),
        PROCESSED_FROZEN("가공/냉동"),
        OTHERS("기타");

        private final String value;
    }


}
