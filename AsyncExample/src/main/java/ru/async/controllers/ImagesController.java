package ru.async.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.async.services.ImagesService;

/**
 * 02.10.2018
 * ImagesController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class ImagesController {

    @Autowired
    @Qualifier("asyncService")
    private ImagesService imagesService;

    @GetMapping("images/download")
    public ResponseEntity<Object> downloadImages(@RequestParam("count") int count) {
        imagesService.downloadImages(count);
        return ResponseEntity.ok().build();
    }
}
