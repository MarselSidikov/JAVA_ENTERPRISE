package ru.itis.storage.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.storage.models.FileInfo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 01.12.2017
 * FileStorageUtil
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class FileStorageUtil {

    @Value("${storage.path}")
    private String storagePath;

    public String getStoragePath() {
        return storagePath;
    }

    @SneakyThrows
    public void copyToStorage(MultipartFile file, String storageFileName) {
        Files.copy(file.getInputStream(), Paths.get(storagePath, storageFileName));
    }

    public FileInfo convertFromMultipart(MultipartFile file) {
        // получаем название файла
        String originalFileName = file.getOriginalFilename();
        // вытаскиваем контент-тайп
        String type = file.getContentType();
        // размер файла
        long size = file.getSize();
        // создаем имя файла
        String storageName = createStorageName(originalFileName);
        // получаем url файла по которому он будет доступен внутри системы
        String fileUrl = getUrlOfFile(storageName);
        return FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(storageName)
                .url(fileUrl)
                .size(size)
                .type(type)
                .build();
    }

    private String getUrlOfFile(String storageFileName) {
        return storagePath + "/" + storageFileName;
    }

    private String createStorageName(String originalFileName) {
        String extension = FilenameUtils.getExtension(originalFileName);
        String newFileName = UUID.randomUUID().toString();
        return newFileName + "." + extension;
    }
}
