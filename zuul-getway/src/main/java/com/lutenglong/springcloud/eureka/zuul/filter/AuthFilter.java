package com.lutenglong.springcloud.eureka.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends ZuulFilter {

    /**
     * 过滤类型：路由之前-pre * routing：路由之时 * post： 路由之后 * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 在zuul网关可以有多个过滤器，可设置顺序
     *
     * 排序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //获取request对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取HTTP请求
        String requestURI = request.getRequestURI();
        System.err.println(requestURI);
        System.err.println(requestURI.startsWith("/user"));
        if(requestURI.startsWith("/user")){
            return false;
        }
        return true;
    }

    /**
     * 具体执行的逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取request对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取HTTP请求
        String requestURI = request.getRequestURI();
        System.err.println("run："+requestURI);
        String id = request.getParameter("id");
        String refer = request.getHeader("refer");
        if(StringUtils.isEmpty(id)){
            //表示不进行路由，不会被zuul转发到后端服务器，也就是不再进行调用后端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            HttpServletResponse response = currentContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().write("{\"code\":\"401\",\"message\":\"未授权\"}");
            }catch (Exception e ){
                    e.printStackTrace();
            }

        }
        return null;
    }
}
