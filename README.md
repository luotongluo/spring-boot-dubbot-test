# spring-dubbo-dubbo-test
spring-dubbo-dubbo-test
### 项目简介
comm-dubbo-utils 工具类，枚举，异常放置位置
comm-interface  dubbo的公共service位置，公共vo，接口请求vo位置
comm-parent     jar包管理模块
dubbo-consumer  dubbo的消费模块
dubbo-provider  dubbo服务提供模块

### 启动介绍
启动前需将 comm-dubbo-utils，comm-interface进行mvn deploy
comm-parent 进行mvn install
然后就可以启动项目的服务提供和消费模块