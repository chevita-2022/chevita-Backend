package kbsc.kbsc.controller.v1;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController("/api") //컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어준다. , 예전에 @Response Body를 각 메소드마다 선언했던 것을 한번에 사용할 수 있기 해줬디.
@Api(tags="API")
public class APIController {
    @GetMapping("/getApi") //get 요청을 받을 수 있는 api  **"/getApi"랑 "getApi"랑 뭐가 다르지??
    public String getApi(){
        return "hello";
    }
    /*public ResponseEntity<HashMap> getApi(@RequestParam(value="param1") String param1){
        HashMap map = new HashMap();
        map.put("param1",param1);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }*/

}
