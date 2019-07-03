package com.hanzone.springbbot.config;

import com.google.common.collect.Maps;
import freemarker.template.utility.XmlEscape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Map;
import java.util.Properties;

/**
 * @author Hanzone
 * @date 2019年07月03日
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setExposeRequestAttributes(true);
        freeMarkerViewResolver.setExposeSessionAttributes(true);
        freeMarkerViewResolver.setAllowSessionOverride(true);
        freeMarkerViewResolver.setExposeSpringMacroHelpers(true);
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("classpath:/templates");
        configurer.setDefaultEncoding("utf-8");
        Map<String, Object> map = Maps.newHashMap();
        map.put("xml_escape", new XmlEscape());
        configurer.setFreemarkerVariables(map);
        Properties configProperties = new Properties();
        configProperties.setProperty("template_update_delay", "3600");
        configProperties.setProperty("tag_syntax", "auto_detect");
        configProperties.setProperty("default_encoding", "UTF-8");
        configProperties.setProperty("output_encoding", "UTF-8");
        configProperties.setProperty("locale", "zh_CN");
        configProperties.setProperty("date_format", "yyyy-MM-dd");
        configProperties.setProperty("time_format", "HH:mm:ss");
        configProperties.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        configProperties.setProperty("number_format", "#");
        configProperties.setProperty("classic_compatible", "true");
        configurer.setFreemarkerSettings(configProperties);
        return configurer;
    }

}
