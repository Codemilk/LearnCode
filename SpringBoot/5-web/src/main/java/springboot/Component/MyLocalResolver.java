package springboot.Component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 思路:如果通过链接传入请求头进行国际化设计
 *     让链接携带区域信息
 *
 *
 */
//@Component
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取区域信息
        String localeMessage = request.getParameter("l");
//        创建区域对象,先通过Locale.getDefault()获得区域的默认值
        Locale locale=Locale.getDefault();
         if(!StringUtils.isEmpty(localeMessage)){
             //例如：'zh_CN'将它分为zh CN zh为语言，CH为国家zh_CN
             String[] split = localeMessage.split("_");
             locale= new Locale(split[0], split[1]);


         }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
