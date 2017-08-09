package com.example.demo.filters.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreRequestLogFilter extends ZuulFilter {
  private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

  @Override
  public String filterType() {//返回的Filter型態,可指定pre,route,post,error
    return "pre";
  }

  @Override
  public int filterOrder() {//返回這個Filter的執行順序
    return 1;
  }

  @Override
  public boolean shouldFilter() {//返回這個Filter是否要執行
    return true;
  }

  @Override
  public Object run() {//這個Filter的具體邏輯,這只是在請求被路由之前,利用logging影印出http method及address
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
    return null;
  }
}
