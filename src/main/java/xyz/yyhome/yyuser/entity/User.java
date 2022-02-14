package xyz.yyhome.yyuser.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2022-01-13 22:30:16
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {
    /**
     * id
     */
    private String id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 特殊情况下数据库保存token
     */
    private String token;

    /**
     * 状态值
     */
    private Integer status;
}