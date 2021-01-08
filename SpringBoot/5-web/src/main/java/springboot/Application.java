package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public Converter  myConverter(){
//        return new myConverter();
//    }
//
//    private static class  myConverter implements Converter<View, View>{
//
//
//        @Override
//        public View convert(View source) {
//            return null;
//        }
//
//        @Override
//        public <U> Converter<View, U> andThen(Converter<? super View, ? extends U> after) {
//            return null;
//        }
//
//    }

//    @Bean
//    public ViewResolver  myViewResolver(){
//
//        return new myViewResolver();
//    }
//
//    private static class  myViewResolver implements ViewResolver{
//
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }

}
