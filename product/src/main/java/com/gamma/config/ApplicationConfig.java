package com.gamma.config;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
public class ApplicationConfig
{
    @Bean
    public PropertyPlaceholderConfigurer vaultConfiguration(
            @Value("file:#{systemProperties['appconfig.dir']}/base/*.properties") Resource[] baseProperties,
            @Value("file:#{systemProperties['appconfig.dir']}/farms/#{systemProperties['farm']}/*.properties") Resource[] farmProperties)
    {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(false);
        configurer.setLocations(ArrayUtils.addAll(baseProperties, farmProperties));
        configurer.setLocalOverride(true);
        return configurer;
    }

}
