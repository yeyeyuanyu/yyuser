package xyz.yyhome.yyuser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.yyhome.yyuser.entity.User;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-13 22:30:15
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    User cheackUser(@Param("user")User user);
}

