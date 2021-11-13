package org.example.app.config;

import com.tvd12.ezyfox.bean.EzyBeanConfig;
import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.bean.annotation.EzyConfigurationAfter;
import com.tvd12.ezyfox.bean.annotation.EzyPropertiesBean;

import com.tvd12.ezyfoxserver.support.factory.EzyResponseFactory;
import lombok.Data;

@Data
@EzyPropertiesBean(prefix = "application")
@EzyConfigurationAfter
public class AppConfig implements EzyBeanConfig {

    private String helloPrefix;
    private String goPrefix;

    @EzyAutoBind
    public static EzyResponseFactory responseFactory;

    @Override
    public void config() {
        AppConfig.responseFactory = responseFactory;
    }

}
