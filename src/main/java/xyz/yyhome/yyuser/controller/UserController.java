package xyz.yyhome.yyuser.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import xyz.yyhome.CommonResult;
import xyz.yyhome.StringUtils;
import xyz.yyhome.yyuser.entity.User;
import xyz.yyhome.yyuser.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;


/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-01-13 22:30:06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param user 登录对象
     * @return 单条数据
     */
    @PostMapping("/login")
    public CommonResult<User> selectOne(@RequestBody User user, HttpSession httpSession) {
        user = this.userService.cheackUser(user);
        if (null == user){
            return CommonResult.failed("账号密码错误");
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(httpSession.getId(),user);
        return CommonResult.success(user);
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("{id}")
    public CommonResult<Boolean> insert(@RequestBody User user) {
        return CommonResult.success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping("{id}")
    public CommonResult<Boolean> update(@RequestBody User user) {
        return CommonResult.success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    public CommonResult<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return CommonResult.success(this.userService.removeByIds(idList));
    }
}

