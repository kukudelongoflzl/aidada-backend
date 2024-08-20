package com.zulong.aidada.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zulong.aidada.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户数据库操作
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




