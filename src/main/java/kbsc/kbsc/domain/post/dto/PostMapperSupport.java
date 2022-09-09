package kbsc.kbsc.domain.post.dto;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostMapperSupport {
    @Named("toLocalDateTime") //수정 필요
    public LocalDateTime toLocalDateTime(String deadLineDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime changedDeadLineDate = LocalDateTime.parse(deadLineDate+" 00:00:00", formatter);
        return changedDeadLineDate;
    }
}
