package ru.itis.services.vk.dto;

import lombok.Data;

import java.util.List;

/**
 * 07.04.2018
 * VkResponse
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
public class VkResponse {
    List<VkUser> response;
}
