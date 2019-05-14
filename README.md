### Spring-Boot-Starter-dingding

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.mengwang0211/spring-boot-starter-dingding/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.mengwang0211/spring-boot-starter-dingding/)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

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
        <version>1.0.1</version>
    </dependency>    
    
    
##### application.yml

###### 群机器人发送消息的三种模式

    # 1. text
    #纯文本消息
    #配置
    dingding:
        robot:
            # 机器人token
            access_token: xxxxxxxx
                
                
###### 发送消息

        @Autowired
        RobotPushService robotPushService;
        
        robotPushService.sendMsg("test dingding message","text");                
                

        