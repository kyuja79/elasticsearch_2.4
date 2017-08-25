package com.gaebalja.listener;

import java.io.IOException;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class LoadAdditionalProperties implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	private ResourceLoader loader = new DefaultResourceLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        try {
            Resource resource = loader.getResource("classpath:application.properties");
            PropertySource<?> propertySource = new PropertySourcesLoader().load(resource);
            event.getEnvironment().getPropertySources().addLast(propertySource);
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

}
