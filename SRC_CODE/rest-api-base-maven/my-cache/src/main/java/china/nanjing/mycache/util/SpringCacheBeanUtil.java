package china.nanjing.mycache.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Bean 工具类，为其他模块提供缓存Template
 *
 * @author Chen Hongyu
 */
@Component
public class SpringCacheBeanUtil implements ApplicationContextAware {

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringCacheBeanUtil.applicationContext == null) {
            SpringCacheBeanUtil.applicationContext = applicationContext;
        }
    }

    /**
     * 通过Bean名字获取Bean
     *
     * @param beanName String
     * @return Object
     */
    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }


    /**
     * 通过Bean类型获取Bean
     *
     * @param beanClass Class<T>
     * @return <T> T
     */
    public static <T> T getBean(Class<T> beanClass) {
        return getApplicationContext().getBean(beanClass);
    }

    /**
     * 通过Bean名字和Bean类型获取Bean
     *
     * @param beanName  String
     * @param beanClass Class<T>
     * @return <T> T
     */
    public static <T> T getBean(String beanName, Class<T> beanClass) {
        return getApplicationContext().getBean(beanName, beanClass);
    }

}
