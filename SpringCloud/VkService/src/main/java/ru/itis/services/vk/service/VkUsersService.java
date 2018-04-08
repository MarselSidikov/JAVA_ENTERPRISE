package ru.itis.services.vk.service;

import ru.itis.services.vk.dto.VkUser;

import java.util.List;

/**
 * 07.04.2018
 * VkUsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface VkUsersService {
    VkUser getUser(Long userId);
}
