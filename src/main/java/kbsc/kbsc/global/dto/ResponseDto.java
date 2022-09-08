package kbsc.kbsc.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private String message;
    private T data;

    public static <T> ResponseDto<T> create(String message){
        return new ResponseDto<>(message, null);
    }
    public static <T> ResponseDto<T> create(String message, T dto){
        return new ResponseDto<>(message, dto);
    }
}
