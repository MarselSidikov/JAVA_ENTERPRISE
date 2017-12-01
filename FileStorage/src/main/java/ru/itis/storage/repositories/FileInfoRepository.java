package ru.itis.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.storage.models.FileInfo;

/**
 * 01.12.2017
 * FileInfoRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}
