package com.zulong.aidada.manager;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.aidadaTest;

/**
 * Cos 操作测试
 *
 * @author <a href="https://github.com/lizulong">程序员鱼皮</a>
 * @from <a href="https://zulong.icu">编程导航知识星球</a>
 */
@aidadaTest
class CosManagerTest {

    @Resource
    private CosManager cosManager;

    @Test
    void putObject() {
        cosManager.putObject("test", "test.json");
    }
}