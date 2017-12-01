package ru.itis.storage.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 01.12.2017
 * FileStorageService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileStorageService {
    String saveFile(MultipartFile file);
    void writeFileToResponse(String fileName, HttpServletResponse response);
}
