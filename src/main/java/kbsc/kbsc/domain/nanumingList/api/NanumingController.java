package kbsc.kbsc.domain.nanumingList.api;

import kbsc.kbsc.domain.nanumingList.application.NanumingService;
import kbsc.kbsc.domain.nanumingList.dto.NanumingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nanumingList")
public class NanumingController {

    private final NanumingService nanumingService;

    public NanumingController(NanumingService nanumingService) {
        this.nanumingService = nanumingService;
    }

    @GetMapping("/{userIdx}")
    public List<NanumingDto> getNanumingList(@PathVariable Long userIdx) throws Exception {
        return new ArrayList<>(nanumingService.getNanumings(userIdx));
    }
}
