package ru.async.services;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.async.dto.CatDto;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 02.10.2018
 * ImagesServiceAsyncImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service("asyncService")
public class ImagesServiceAsyncImpl implements ImagesService {
    @Autowired
    public RestTemplate restTemplate;

    private ExecutorService service = Executors.newCachedThreadPool();

    @Value("${images.folder.path}")
    private String imagesFolderPath;

    private Logger logger = LoggerFactory.getLogger(ImagesServiceSynchronizedImpl.class);

//    @Override
//    public void downloadImages(int count) {
//        Runnable task = () -> {
//            for (int i = 0; i < count; i++) {
//                try {
//                    CatDto catImage = Objects.requireNonNull(restTemplate
//                            .getForEntity("https://api.thecatapi.com/v1/images/search", CatDto[].class).getBody())[0];
//                    String catImageUrl = catImage.getUrl();
//                    String type = catImageUrl.substring(catImageUrl.lastIndexOf("."));
//                    URL imageUrl = new URL(catImageUrl);
//                    InputStream imageInputStream = imageUrl.openStream();
//                    String newFileName = imagesFolderPath + UUID.randomUUID().toString() + type;
//                    Files.copy(imageInputStream, Paths.get(newFileName));
//                    logger.info("DOWNLOADED " + newFileName);
//                } catch (Exception e) {
//                    throw new IllegalArgumentException(e);
//                }
//            }
//        };
//        service.submit(task);
//    }

//    @Override
//    public void downloadImages(int count) {
//        for (int i = 0; i < count; i++) {
//            Runnable task = () -> {
//                try {
//                    CatDto catImage = Objects.requireNonNull(restTemplate
//                            .getForEntity("https://api.thecatapi.com/v1/images/search", CatDto[].class).getBody())[0];
//                    String catImageUrl = catImage.getUrl();
//                    String type = catImageUrl.substring(catImageUrl.lastIndexOf("."));
//                    URL imageUrl = new URL(catImageUrl);
//                    InputStream imageInputStream = imageUrl.openStream();
//                    String newFileName = imagesFolderPath + UUID.randomUUID().toString() + type;
//                    Files.copy(imageInputStream, Paths.get(newFileName));
//                    logger.info("DOWNLOADED " + newFileName);
//                } catch (Exception e) {
//                    throw new IllegalArgumentException(e);
//                }
//            };
//            service.submit(task);
//        }
//    }
@Override
public void downloadImages(int count) {

    for (int i = 0; i < count; i++) {
        Runnable getCatTask = () -> {
            CatDto catImage = Objects.requireNonNull(restTemplate
                    .getForEntity("https://api.thecatapi.com/v1/images/search", CatDto[].class).getBody())[0];
            String catImageUrl = catImage.getUrl();
            String type = catImageUrl.substring(catImageUrl.lastIndexOf("."));
            logger.info("GET CAT IMAGE LINK " + catImageUrl);
            try {
                URL imageUrl = new URL(catImageUrl);
                Runnable downLoadImageTask = () -> {
                    try {
                        InputStream imageInputStream = imageUrl.openStream();
                        String newFileName = imagesFolderPath + UUID.randomUUID().toString() + type;
                        Files.copy(imageInputStream, Paths.get(newFileName));
                        logger.info("DOWNLOADED " + newFileName);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                };
                service.submit(downLoadImageTask);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        };
        service.submit(getCatTask);
    }
}
}
