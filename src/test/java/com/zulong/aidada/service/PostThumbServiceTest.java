package com.zulong.aidada.service;

import com.zulong.aidada.model.entity.User;
import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.aidadaTest;

/**
 * 帖子点赞服务测试
 *
 * @author <a href="https://github.com/lizulong">程序员鱼皮</a>
 * @from <a href="https://zulong.icu">编程导航知识星球</a>
 */
@aidadaTest
class PostThumbServiceTest {

    @Resource
    private PostThumbService postThumbService;

    private static final User loginUser = new User();

    @BeforeAll
    static void setUp() {
        loginUser.setId(1L);
    }

    @Test
    void doPostThumb() {
        int i = postThumbService.doPostThumb(1L, loginUser);
        Assertions.assertTrue(i >= 0);
    }
}
