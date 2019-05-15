package com.ysj.dispatchserver.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class RouteFilter extends ZuulFilter {

    @Value("${zuul.routes.data-a.serviceId}")
    private String aa;

    @Value("${zuul.routes.data-b.serviceId}")
    private String bb;

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        Object key = ctx.get(FilterConstants.REQUEST_URI_KEY);
        Object id = ctx.get(FilterConstants.SERVICE_ID_KEY);

        String userType = request.getParameter("userType");
        log.info("----- >>>>>> key: " + key.toString());
        log.info("----- >>>>>> id: " + id.toString());
        log.info("----- >>>>>> userType: " + userType);
        log.info("----- >>>>>> aa: " + aa);
        log.info("----- >>>>>> bb: " + bb);
        String serviceId = null;
        try {
            if (userType != null) {
                if (userType.equals("A")) {
                    serviceId = aa;
                } else if (userType.equals("B")) {
                    serviceId = bb;
                }
            } else {
                serviceId = "xxx";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (serviceId == null) {
            //服务查询失败 不再路由直接返回
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("Error: No service");
        } else {
            //转发请求
            log.info("--->>> Forward to service :" + serviceId);
            ctx.set("serviceId", serviceId);
            HttpServletRequest request2 = ctx.getRequest();
            String url2 = request2.getRequestURL().toString();
            Object kkk = ctx.get(FilterConstants.SERVICE_ID_KEY);
            log.info("------->>>>> kkk: " + kkk.toString());
            log.info("------->>>>> url: " + url2);
        }
        return null;
    }
}
