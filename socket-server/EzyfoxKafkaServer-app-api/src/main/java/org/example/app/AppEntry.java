package org.example.app;

import java.util.Properties;

import com.tvd12.ezyfox.bean.EzyBeanContextBuilder;
import com.tvd12.ezyfoxserver.context.EzyAppContext;
import com.tvd12.ezyfoxserver.setting.EzyAppSetting;
import com.tvd12.ezyfoxserver.support.entry.EzyDefaultAppEntry;

public class AppEntry extends EzyDefaultAppEntry {

    @Override
    protected void preConfig(EzyAppContext ctx) {
        logger.info("\n=================== EzyfoxKafkaServer APP START CONFIG ================\n");
    }

    @Override
    protected void postConfig(EzyAppContext ctx) {
        logger.info("\n=================== EzyfoxKafkaServer APP END CONFIG ================\n");
    }

    @Override
    protected void setupBeanContext(EzyAppContext context, EzyBeanContextBuilder builder) {
        EzyAppSetting setting = context.getApp().getSetting();
        builder.addProperties(getConfigFile(setting));
        Properties properties = builder.getProperties();
    }

    protected String getConfigFile(EzyAppSetting setting) {
        return setting.getConfigFile();
    }

    @Override
    protected String[] getScanableBeanPackages() {
        return new String[]{
                "org.example.common",
                "org.example.app.config",
                "org.example.app"
        };
    }

    @Override
    protected String[] getScanableBindingPackages() {
        return new String[]{
                "org.example.common",
                "org.example.app.config",
                "org.example.app"
        };
    }

}
