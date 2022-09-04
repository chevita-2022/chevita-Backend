package kbsc.kbsc.s3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URL;

@Controller
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @ResponseBody
    @GetMapping("/download/{fileName}")
    public String download(@PathVariable String fileName) throws IOException {
        return s3Service.getObject(fileName).toString();
    }
}
