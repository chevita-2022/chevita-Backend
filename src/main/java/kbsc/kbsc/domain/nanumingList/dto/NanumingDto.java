package kbsc.kbsc.domain.nanumingList.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NanumingDto {

    String profileUrl;
    String userNickname;
    String nanumStatus;
    String title;//postTile
    Long postIdx;
    Long reserveIdx;
    Long nanumiIdx;
    Long takerIdx;

    String globalLocation;
    String detailedLocation;
    //TODO: 나눔 위치 추가하기

    //TODO : 이거 하나로 줄지 나눠서 줄지 지원이한테 물어보고 다시 수정해야함
    String confirmedTimeZone;



}
