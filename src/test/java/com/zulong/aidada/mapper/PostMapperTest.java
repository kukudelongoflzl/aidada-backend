package com.zulong.aidada.mapper;

import com.zulong.aidada.model.entity.Post;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.aidadaTest;

/**
 * 帖子数据库操作测试
 *
 * @author <a href="https://github.com/lizulong">程序员鱼皮</a>
 * @from <a href="https://zulong.icu">编程导航知识星球</a>
 */
@aidadaTest
class PostMapperTest {

    @Resource
    private PostMapper postMapper;

    @Test
    void listPostWithDelete() {
        List<Post> postList = postMapper.listPostWithDelete(new Date());
        Assertions.assertNotNull(postList);
    }
}