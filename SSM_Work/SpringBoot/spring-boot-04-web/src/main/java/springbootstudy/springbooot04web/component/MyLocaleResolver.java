package springbootstudy.springbooot04web.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//       从request获取国际化参数
        String l = request.getParameter("l");
//      如果没有使用当前本地的locale,有的话使用获取到的
        Locale locale=Locale.getDefault();

        if(!StringUtils.isEmpty(l)){

            String[] s = l.split("_");

            locale=new Locale(s[0],s[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
