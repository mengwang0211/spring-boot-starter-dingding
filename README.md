### Spring-Boot-Starter-dingding

#### 钉钉开放平台 SpringBoot插件

##### 完成功能

    1. 群机器人

#### 依赖

    lombok
    taobao-sdk-java-auto-1479188381469-20190507

#### 用法

##### pom.xml引入[已上传到中央仓库]

    <dependency>
        <groupId>io.github.mengwang0211</groupId>
        <artifactId>spring-boot-starter-dingding</artifactId>
        <version>1.0.0</version>
    </dependency>    
    
    
##### application.yml

###### 群机器人发送消息的三种模式

    # 1. text
    #纯文本消息
    #配置
    dingding:
        properties:
            robot:
                # 机器人token
                access_token: xxxxxxxx
                # atMobiles 当msg_type == text @who [手机号] 多个手机号以,隔开
                atMobiles: 13212345678,13212345678
                # 当msg_type == link or markdown title
                title: This is title
                # 当msg_type == link  message_url
                message_url: https://www.baidu.com
                # 当msg_type == link  pic_url
                pic_url: https://f11.baidu.com/it/u=3015675601,699552073&fm=72
                
                
###### 发送消息

        @Autowired
        RobotPushService robotPushService;
        
        robotPushService.sendMsg("test dingding message","text");                
                

        