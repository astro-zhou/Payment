package com.zhou.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyh
 * @create 2022-11-26 11:33
 */
@Configuration
public class GateWayConfig {

    /**
     * Gateway网关路由有两种配置方式：1. 在配置文件yml中配置 2. 代码中注入RouteLocator的Bean:
     * 配置了一个id为route-name的路由规则,
     * 当访问地址http://localhost:9527//guonei 时会自动转发到地址: http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRoteLocator(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_zhou", r -> r.path( "/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRoteLocator2(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_zhou", r -> r.path( "/map").uri("https://map.baidu.com/")).build();
        return routes.build();
    }

}
