package ru.itis.storage.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 01.12.2017
 * FileInfo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storageFileName;

    private String originalFileName;

    private long size;

    private String type;

    private String url;
}
