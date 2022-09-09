package kbsc.kbsc.domain.post.dto;
import io.swagger.annotations.Api;
import kbsc.kbsc.domain.post.domain.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class PostDto {
//    private final String name;
//    private final int amount;
    @ApiModel(description = "게시글 등록을 위한 요청 객체")
    public static class CreateRequest{
        @NotBlank(message = "게시글 제목을 입력해주세요.")
        @ApiModelProperty(notes = "게시글 제목을 입력해주세요.")
        private String title;

        @NotBlank(message = "식품 종류를 입력해주세요.")
        @ApiModelProperty(notes = "게시판 내용을 입력해주세요.")
        private String category;

    }

    @ApiModel(description = "게시글 등록을 위한 응답 객체")
    public static class CreateResponse{
        private Long postId;
    }

    @ApiModel(description = "게시글 등록을 위한 수정 객체")
    public static class UpdateRequest{
        @NotBlank(message = "게시글 id를 입력해 주세요.")
        @ApiModelProperty(notes = "게시글 id를 입력해 주세요.")
        private String postId;

        @NotBlank(message = "게시글 제목을 입력해 주세요.")
        @ApiModelProperty(notes = "게시글 제목을 입력해 주세요.")
        private String title;
    }

    @ApiModel(description = "특정 게시글 조회를 위한 응답 객체")
    public static class GetDetailResponse {
        private Long postId;
        private String title;
        private String content;
        private String category;
    }
    



}
