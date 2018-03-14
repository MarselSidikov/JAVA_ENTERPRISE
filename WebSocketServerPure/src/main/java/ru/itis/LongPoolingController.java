package ru.itis;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;

/**
 * 13.03.2018
 * LongPoolingController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class LongPoolingController {
    @GetMapping("/long")
    @ResponseBody
    public ResponseEntity<String> getLong() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return ResponseEntity.ok("Hello!");
    }
}
