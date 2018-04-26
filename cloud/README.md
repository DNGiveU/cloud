<p align="center">
 <img src="https://img.shields.io/circleci/project/vuejs/vue/dev.svg" alt="Build Status">
  <img src="https://img.shields.io/badge/Spring%20Cloud-Edgware-blue.svg" alt="Coverage Status">
  <img src="https://img.shields.io/badge/Spring%20Boot-1.5.9-blue.svg" alt="Downloads">
  <img src="https://img.shields.io/badge/npm-v5.5.1-blue.svg" alt="Version">
  <img src="https://img.shields.io/npm/l/vue.svg" alt="License">
</p>

<h2 align="center">Supporting gaz</h2>  

### TODO

  - 文章评论
  - 标签统计
  - 书籍/视频管理
  - 笔记
  - 个人数据挖掘

### 项目结构
``` lua
cloud
├── cloud-ui -- element-vue-admin实现[9528]
├── cloud-auth -- 授权服务提供[3000]
├── cloud-common -- 系统公共模块 
├── cloud-config -- 配置中心[4001]
├── cloud-eureka -- 服务注册与发现[1025]
├── cloud-gateway -- ZUUL网关[9999]
├── cloud-modules -- 微服务模块
├    ├── cloud-daemon-service -- 分布式调度中心[4060]
├    ├── cloud-mc-service -- 消息中心[4050]
├    ├── cloud-sso-client-demo -- 单点登录客户端示例[4040]
├    ├── cloud-upms-service -- 权限管理提供[4000]
├    └── cloud-tabe-service -- 博客服务[9001]
└── cloud-visual  -- 图形化模块 
     ├── cloud-monitor -- 服务状态监控、turbine [5001]
     ├── cloud-zipkin-elk -- zipkin、ELK监控[5002、5601]
     └── cloud-cache-cloud -- 缓存管理、统一监控[5005]
```
###  已完成功能
- 完善登录：账号密码模式、短信验证码模式、社交账号模式均整合Spring security oAuth
- 单点登录：基于Srping security oAuth 提供单点登录接口，方便其他系统对接
- 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- 机构管理：配置系统组织机构（公司、部门、小组），树结构展现，可随意调整上下级。
- 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
- 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
- 字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否、男女、类别、级别等。
- 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
- 服务限流：多种维度的流量控制（服务、IP、用户等）
- 分库分表：shardingdbc分库分表策略
- 数据权限: 使用mybatis对原查询做增强，业务代码不用控制，即可实现。
- 文件系统: 支持FastDFS、七牛云，扩展API几行代码实现上传下载
- 消息中心：短信、邮件模板发送，几行代码实现发送
- 聚合文档：基于zuul实现 swagger各个模块的实现
- 代码生成：前后端代码的生成，支持Vue
- 缓存管理：基于Cache Cloud 保证Redis 的高可用
- 服务监控: Spring Boot Admin
- 分布式任务调度： 基于elastic-job的分布式文件系统，zookeeper做调度中心
- zipkin链路追踪： 数据保存ELK，图形化展示
- pinpoint链路追踪： 数据保存hbase，图形化展示 

### 配置介绍
```lua
默认账号：admin 密码：123456
CacheCloud管理台账号:admin 密码:admin
mysql: 127.0.0.1:3306
reeis: 127.0.0.1:6379
rabbitmq: 192.168.0.200:15672
zookeeper: 192.168.0.200:2181
elasticsearch: 192.168.0.200:5601 [index=zipkin]

建议启动参数:
cloud-eureka启动 -Xmx350m -Xms250m
cloud-config启动 -Xmx350m -Xms250m
cloud-auth启动 -Xmx350m -Xms250m
cloud-gateway启动 -Xmx350m -Xms250m
cloud-upms-service启动 -Xmx400m -Xms250m
cloud-tabe-service启动 -Xmx400m -Xms250m
```

### 测试请求

```shell
# 认证 cGlnOnBpZw== 为client-id:client-secret的base64密文 grant_type为oauth密码模式 scope为server
curl -H "Authorization:Basic cGlnOnBpZw==" -d "grant_type=password&scope=server&username=admin&password=123456" http://localhost:9999/auth/oauth/token

# 请求数据 Authorization头信息中Bearer后面跟的是认证之后返回的token
curl -H "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MDk1NzA0NjMsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiZWMwZmJhMjYtMGJkZS00YjY2LThhZTQtZGRmYTNiMzkxZGM5IiwiY2xpZW50X2lkIjoicGlnIiwic2NvcGUiOlsic2VydmVyIl19.ZoSU_4NhdolnV6ZsNaSXITC_pewUDiaqZPLoESu9f9s" http://localhost:9999/admin/user/info
```

### FAQ
```java
1. 如果出现实体类转换失败(ClassCastException),则估计redis缓存的锅,从redis中可以取出对象并反序列化成功,但无法再次转换. 即redis->Object可以. 但是方法返回Object或者传递Object时,则出现无法转换的异常

2. pinpoint没有数据
	https://github.com/naver/pinpoint/issues/3823
	修改pinpoint配置文件pinpoint.config
	预计是访问量太少,导致收集的数据很少(默认是1/20);所以设置profiler.sampling.rate=1即(1/1=100%)
	还可以改变类型:
	profiler.applicationservertype=SPRING_BOOT
	profiler.tomcat.conditional.transform=false
	
	对节点的重命名(在启动参数中加入节点名字):
	-Dpinpoint.applicationName=ProjectB
	
	服务类型列表:https://github.com/naver/pinpoint/issues/3846
```