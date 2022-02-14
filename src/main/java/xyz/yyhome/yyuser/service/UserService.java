package xyz.yyhome.yyuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.yyhome.yyuser.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-01-13 22:30:17
 */
public interface UserService extends IService<User> {

    /**
     * 检查该user对象是否在数据库中
     * @param user
     * @return
     */
    User cheackUser(User user);
}

