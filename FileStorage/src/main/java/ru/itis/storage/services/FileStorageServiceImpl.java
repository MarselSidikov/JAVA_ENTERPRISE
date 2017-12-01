package ru.itis.storage.services;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.storage.models.FileInfo;
import ru.itis.storage.repositories.FileInfoRepository;
import ru.itis.storage.utils.FileStorageUtil;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 01.12.2017
 * FileStorageServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private FileStorageUtil fileStorageUtil;

    @Override
    public String saveFile(MultipartFile file) {
        // конвертируем из Multipart в понятный для нас объект БД
        FileInfo fileInfo = fileStorageUtil.convertFromMultipart(file);
        // сохраняем информацию о файле
        fileInfoRepository.save(fileInfo);
        // переносим файл на наш диск
        fileStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
        // возвращаем имя файла - новое
        return fileInfo.getStorageFileName();
    }

    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {

    }
}
