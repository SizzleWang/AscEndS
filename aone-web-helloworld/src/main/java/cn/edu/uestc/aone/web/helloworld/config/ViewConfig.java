package cn.edu.uestc.aone.web.helloworld.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 对视图的配置
 * Created by Carter Peng 2018/10/14
 */
@Configuration
public class ViewConfig {
    // 分页列表默认大小
    @Value("#{configure['defaultPageSize']}")
    public int DEFAULT_PAGE_SIZE;
}
