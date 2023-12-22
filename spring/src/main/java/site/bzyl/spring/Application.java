package site.bzyl.spring;

import lombok.SneakyThrows;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.lang.reflect.Field;
import java.util.Map;

@SpringBootApplication
public class Application {
    @SneakyThrows
    public static void main(String[] args)  {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        /*Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);

        map.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("component"))
                .forEach(each -> System.out.println(each.getKey() + " : " + each.getValue()));*/

        Resource[] resources = context.getResources("classpath:application.yml");
        for (Resource resource : resources) {
            System.out.println(resource);
        }
    }
}