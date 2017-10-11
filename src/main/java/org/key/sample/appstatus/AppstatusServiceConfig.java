package org.key.sample.appstatus;

import java.util.Properties;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import net.sf.appstatus.services.InProcessServiceManager;
import net.sf.appstatus.support.aop.AppStatusServiceInterceptor;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppstatusServiceConfig {

    @Bean
    public InProcessServiceManager getServiceManager() {
        InProcessServiceManager manager = new InProcessServiceManager();

        Properties props = new Properties();
        props.setProperty("services.useThreadLocal", "true");
        props.setProperty("services.minMaxDelay", "10");

        manager.setConfiguration(props);

        return manager;
    }

    @Bean
    public Advisor serviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * org.key.sample.controller.*.*(..)))");

        return getServiceInterceptor(pointcut);
    }

    private DefaultPointcutAdvisor getServiceInterceptor(AspectJExpressionPointcut pointcut) {
        AppStatusServiceInterceptor interceptor = new AppStatusServiceInterceptor();
        interceptor.setServiceManager(getServiceManager());

        return new DefaultPointcutAdvisor(pointcut, interceptor);
    }

}
