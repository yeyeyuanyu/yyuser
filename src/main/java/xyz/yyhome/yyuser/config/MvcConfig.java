package xyz.yyhome.yyuser.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.yyhome.yyuser.config.interceptor.SessionInterceptor;

/**
 * @ClassName MvcConfig
 * @Description TODO 注册mvc相关配置类
 * @Author yy
 * @Date 2022/1/14 21:46
 * @Version 1.0
 */

public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/css/**","/js/**","/images/**");
    }
}
