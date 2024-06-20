package com.chenjw.filter;

import com.alibaba.fastjson.JSONObject;
import com.chenjw.common.Result;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Author
 * Date     2018/10/31
 * Description    msg
 * Version
 */
public class BaseFilter {

    /**
     * 对于一些可以不进行拦截的url进行忽略
     */
    protected static final List<String> IGNORE_URL = Arrays.asList("(.*)\\.css", "/auth/(.*)", "/wx/callback/(.*)", "/callback/(.*)","/doc.html", "/webjars/(.*)", "/swagger-resources", "/swagger-resources/(.*)", "/v2/api-docs","/page/(.*)");
    protected void responseResult(ServletResponse servletResponse, String msg) throws IOException {
        servletResponse.setContentType("application/json; charset=utf-8");
        servletResponse.setCharacterEncoding("UTF-8");
        String userJson = JSONObject.toJSONString(Result.error(msg));
        OutputStream out = servletResponse.getOutputStream();
        out.write(userJson.getBytes("UTF-8"));
        out.flush();
    }

    protected boolean matchesUrl(String httpUrl, List <String> urls) {
        for (String url : urls) {
            if (httpUrl.matches(url)) {
                return true;
            }
        }
        return false;
    }
}
