package com.nice.hibernatespringdatajdbctemplate.services.bpp;

import com.nice.hibernatespringdatajdbctemplate.services.SelfInject;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Component
public class SelfInjectAnnotationBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Autowired
    private BeanFactory beanFactory;
    private Map map = new HashMap();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SelfInject.class)) {
                map.put(name, bean);
            }
        }
        return bean;
    }

    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        if (map.containsKey(name)) {
            Object originalBean = map.get(name);
            Field[] fields = originalBean.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SelfInject.class)) {
                    field.setAccessible(true);
                    field.set(originalBean,bean);
                }
            }
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
