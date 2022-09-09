package kbsc.kbsc.domain.post.dto;
import io.swagger.annotations.Api;
import kbsc.kbsc.domain.post.constant.PostConstants;
import kbsc.kbsc.domain.post.entity.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.querydsl.core.annotations.QueryProjection;


import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

//@Builder 패턴 적용

public abstract class PostDto {
    //등록
    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description = "게시글 등록을 위한 요청 객체")
    public static class CreateRequest{
        @NotBlank(message = "게시글 제목을 입력해주세요.")
        @ApiModelProperty(notes = "게시글 제목을 입력해주세요.")
        private String title;

        @NotBlank(message = "식품 종류를 선택해주세요.")
        @ApiModelProperty(notes = "식품 종류를 선택해주세요.")
        private String category;

        @NotBlank(message = "구매일자를 입력해주세요.")
        @ApiModelProperty(notes = "구매일자를 입력해주세요.")
        private LocalDateTime purchaseDate;
        private String purchaseAt; //식품 구매처

        @NotBlank(message = "개봉일자를 입력해주세요.")
        @ApiModelProperty(notes = "개봉일자를 입력해주세요.")
        private LocalDateTime openedDate;
        private LocalDateTime  shelfLife;

        @NotBlank(message = "소비기한을 입력해주세요.")
        @ApiModelProperty(notes = "소비기한을 입력해주세요.")
        private int expirationDate =15;
        
        @NotBlank(message = "보관방식을 입력해주세요.")
        @ApiModelProperty(notes = "보관방식을 입력해주세요.")
        private String storageMethod;

        @NotBlank(message = "식품 해시태그를 입력해주세요.")
        @ApiModelProperty(notes = "식품 해시태그를 입력해주세요.")
        private String tagName;

        @NotBlank(message = "사진을 등록해주세요.")
        @ApiModelProperty(notes = "사진을 등록해주세요.")
        private String imgUrl;


        @NotBlank(message = "나눔소개글을 작성해주세요.")
        @ApiModelProperty(notes = "나눔소개글을 작성해주세요.")
        private String contents;

        @NotBlank(message = "나눔 시간대를 선택해주세요.")
        @ApiModelProperty(notes = "나눔 시간대를 선택해주세요.")
        private LocalDateTime sharingTimeZone;
        
        //TODO:지도에서 받아오는거 설정
        private int sharingPlace_x;
        private int sharingPlace_y;

        @NotBlank(message = "나눔 상세위치를 입력해주세요.")
        @ApiModelProperty(notes = "나눔 상세위치를 입력해주세요.")
        private String detailedLocation;

    }
    @Getter
    @AllArgsConstructor
    @ApiModel(description = "게시글 등록을 위한 응답 객체")
    @Builder
    public static class CreateResponse{
        private Long postId;
    }
    @Getter
    @AllArgsConstructor
    @ApiModel(description = "게시글 등록을 위한 수정 객체") //TODO: 필요하면 수정하기
    @Builder
    public static class UpdateRequest{
        @NotBlank(message = "게시글 id를 입력해 주세요.")
        @ApiModelProperty(notes = "게시글 id를 입력해 주세요.")
        private String postId;

        @NotBlank(message = "게시글 제목을 입력해 주세요.")
        @ApiModelProperty(notes = "게시글 제목을 입력해 주세요.")
        private String title;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @ApiModel(description = "게시판 수정을 위한 응답 객체")
    public static class UpdateResponse {
        private Long postId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @ApiModel(description = "특정 게시글 조회를 위한 응답 객체")
    public static class GetDetailResponse { //TODO: detail 부분 채우기
        private Long postId;
        private String title;
        private String category;
        private LocalDateTime purchaseDate;
        private String purchasedAt;
        private LocalDateTime  openedDate;
        private LocalDateTime  shelfLife;
        private int expirationDate;
        private String storageMethod;
        private String contents;
        private int sharingPlace_x;
        private int sharingPlace_y;
        private String detailedLocation;
        private LocalDateTime  createdAt;
        private LocalDateTime  updatedAt;
        private String receiptImgUrl;
        private String imgUrl;
        private int seenNumber;
        private int totalHearts; //찜개수


        private String tagName; //해시태그

    }


    //게시판 전체
    @Getter
    @Builder
    @AllArgsConstructor
    @ApiModel(description = "게시글 목록 조회를 위한 요청 객체")
    public static class GetAllRequest{
        //딱히 요청 객체가 필요할까...?
//        private String category; //boardType
    }

    @Getter
    @Builder
    @ApiModel(description = "게시글 목록 조회를 위한 응답 객체")
    public static class GetAllResponse{ //나누미 미니
        private Long postId;
        private String title;
        //위치
        private int sharingPlace_x;
        private int sharingPlace_y;
        private String detailedLocation;
        //등록시간
        private LocalDateTime  createdAt;
        //해시태그
        private String tagName;
        //식품사진
        private String imgUrl;
        //hearted
        private boolean isHearted;
        //소비기한 디데이
        private int expirationDday; //deadline

        @QueryProjection //생성자를 통해 DTO를 조회하는 방법
        public GetAllResponse(Long postId, String title, int sharingPlace_x, int sharingPlace_y,
                              String detailedLocation, LocalDateTime createdAt,
                              String tagName, String imgUrl, boolean isHearted,
                              int expirationDday){
            this.postId = postId;
            this.title = title;
            this.sharingPlace_x = sharingPlace_x;
            this.sharingPlace_y = sharingPlace_y;
            this.detailedLocation = detailedLocation;
            this.createdAt= createdAt;
            this.tagName = tagName;
            this.imgUrl = imgUrl;
            this.isHearted = isHearted;
            this.expirationDday=expirationDday;
        }

    }


}
