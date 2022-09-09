package kbsc.kbsc.domain.post.dto;


import kbsc.kbsc.domain.post.entity.Post;
import kbsc.kbsc.global.config.security.util.SecurityUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PostMapperSupport.class, imports = SecurityUtils.class)
public interface PostMapper {
    @Mapping(target = "title", source = "createRequest.title")
    @Mapping(target = "title", source = "createRequest.title")
    Post toEntity(PostDto.CreateRequest createRequest);


    @Mapping(target = "postId", source = "postId")
    PostDto.CreateResponse toCreateResponse(Post save);


    PostDto.GetDetailResponse toGetDetailResponse(Post post, Integer diaryConnectionCount); //TODO: diaryConnectionCount 수정



/*
    @Mapping(target = "title", source = "createRequest.title")
    @Mapping(target = "content", source = "createRequest.content")
    @Mapping(target = "boardType", source = "createRequest.boardType")
    @Mapping(target = "deadLineDate", source = "createRequest.deadLineDate", qualifiedByName = "toLocalDateTime")
    @Mapping(target = "images", source = "createRequest.files", qualifiedByName = "saveImages")
    @Mapping(target = "user", expression = "java(SecurityUtils.getLoggedInUser())")
    Board toEntity(CreateRequest createRequest);

    @Mapping(target = "boardId", source = "boardId")
    CreateResponse toCreateResponse(Board board);

    @Mapping(target = "boardId", source = "boardId")
    UpdateResponse toUpdateResponse(Board board);

    @Mapping(target = "boardId", source = "board.boardId")
    @Mapping(target = "title", source = "board.title")
    @Mapping(target = "content", source = "board.content")
    @Mapping(target = "boardType", source = "board.boardType")
    @Mapping(target = "createdDate", source = "board.createdDate")
    @Mapping(target = "deadLineDate", source = "board.deadLineDate")
    @Mapping(target = "imageKeys", source = "board.images", qualifiedByName = "getImageKeys")
    @Mapping(target = "userName", source = "board.user.name")
    @Mapping(target = "diaryConnectionCount", source = "diaryConnectionCount")
    GetDetailResponse toGetDetailResponse(Board board, Integer diaryConnectionCount);*/
}
