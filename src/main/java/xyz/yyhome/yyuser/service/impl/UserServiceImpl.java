package xyz.yyhome.yyuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.yyhome.yyuser.dao.UserDao;
import xyz.yyhome.yyuser.entity.User;
import xyz.yyhome.yyuser.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yy
 * @since 2022-01-13 22:30:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User cheackUser(User user) {
        user.setPassword(user.getPassword());
        user = this.userDao.cheackUser(user);
        return user;
    }
}

