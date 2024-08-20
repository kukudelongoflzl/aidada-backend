package com.zulong.aidada.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zulong.aidada.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户数据库操作
 *
 * @author <a href="https://github.com/lizulong">程序员鱼皮</a>
 * @from <a href="https://zulong.icu">编程导航知识星球</a>
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




