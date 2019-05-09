package io.github.wangmeng.config;


import io.github.wangmeng.message.RobotPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RobotProperties.class)
@ConditionalOnClass(RobotConfiguration.class)
@ConditionalOnProperty(prefix = "dingding.properties.robot", value = "enabled", matchIfMissing = true)
public class RobotAutoConfiguration {


    @Autowired
    private RobotProperties robotProperties;


    @Bean
    @ConditionalOnMissingBean(RobotConfiguration.class)
    public RobotConfiguration robotConfiguration() {
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        robotConfiguration.setAccess_token(robotProperties.getAccess_token());
        robotConfiguration.setAtMobiles(robotProperties.getAtMobiles());
        robotConfiguration.setContent(robotProperties.getContent());
        robotConfiguration.setMessage_url(robotProperties.getMessage_url());
        robotConfiguration.setMsg_type(robotProperties.getMsg_type());
        robotConfiguration.setPic_url(robotProperties.getPic_url());
        robotConfiguration.setText(robotProperties.getText());
        robotConfiguration.setTitle(robotProperties.getTitle());
        return robotConfiguration;
    }

    @Bean
    @ConditionalOnMissingBean(RobotPushService.class)
    public RobotPushService robotPushService() {
        return new RobotPushService();
    }


}
