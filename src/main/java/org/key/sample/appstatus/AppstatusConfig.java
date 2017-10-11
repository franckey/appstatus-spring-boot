package org.key.sample.appstatus;

import java.util.Arrays;

import org.key.sample.appstatus.check.DummyCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.appstatus.core.AppStatus;
import net.sf.appstatus.core.check.impl.JvmCheck;
import net.sf.appstatus.core.check.impl.ServicesFailureCheck;
import net.sf.appstatus.core.property.impl.HostPropertyProvider;
import net.sf.appstatus.core.property.impl.JvmPropertyProvider;
import net.sf.appstatus.services.InProcessServiceManager;

@Configuration
public class AppstatusConfig {

    @Autowired
    private InProcessServiceManager serviceManager;

    /**
     * Initialisation Appstatus.
     * 
     * destroyMethod = "close" will be available in v2.1.
     */
    @Bean(name = "appstatus", initMethod = "init"/* , destroyMethod = "close" */)
    public AppStatus appstatus() {
        AppStatus bean = new AppStatus();

        setServiceManager(bean);
        setCheckers(bean);
        serPropertyProviders(bean);

        return bean;
    }

    private void setServiceManager(AppStatus bean) {
        bean.setServiceManager(serviceManager);
    }

    private void serPropertyProviders(AppStatus bean) {
        bean.setPropertyProviders(Arrays.asList(new JvmPropertyProvider(), new HostPropertyProvider()));
    }

    private void setCheckers(AppStatus bean) {
        bean.setCheckers(Arrays.asList(new JvmCheck(), new ServicesFailureCheck(), new DummyCheck()));
    }

}
