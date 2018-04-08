package ru.itis.services.vk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.services.vk.dto.VkResponse;
import ru.itis.services.vk.dto.VkUser;

/**
 * 07.04.2018
 * VkUsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class VkUsersServiceImpl implements VkUsersService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${vk.api.url.users.get}")
    private String vkApiUrlUsersGet;

    @Value("${vk.api.version}")
    private String vkApiVersion;

    @Value("${vk.api.user.fields}")
    private String vkUserFields;

    @Value("${vk.api.lang}")
    private String vkApiLang;

    @Override
    public VkUser getUser(Long userId) {
        String request = vkApiUrlUsersGet + "?user_id=" + userId + "&fields=" + vkUserFields +
                "&v=" + vkApiVersion + "&lang=" + vkApiLang;
        System.out.println(request);
        return restTemplate.getForEntity(request, VkResponse.class).getBody().getResponse().get(0);
    }
}
