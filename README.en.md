# Spring Cloud Self Learning Project

#### 介绍
基于Spring Boot/Spring Cloud/Spring Security/Kubernetes/Docker 鼓捣新技术栈的小项目

#### 软件架构
- 后端：Spring Boot, Spring Cloud
- 前端: Vue.js, Thymeleaf
- ORM：Spring Data Jpa, Spring Data Redis, Mybatis
- 消息中间件: RabbitMQ
- 数据库: MySQL
- NoSQL: Redis, MongoDB
- **待学习: ElasticSearch, Neo4j, Kafka, PostgreSQL**

#### 计划

- [x] Spring Security Oauth2 JWT SSO
- [ ] 设计高并发接口/性能优化/乐观锁
- [ ] Spring Session + Redis 会话集群
- [ ] Mycat分库分表, UUID, 索引优化
- [ ] 预研并行编程/WebFlux/响应式编程
- [ ] Kubernetes集群 + 微服务高可用
- [ ] 预研Istio



#### 项目结构

|  目录   | 说明  |
|  ----  | ----  |
| base-config | 给my-config用的git配置项目录 |
| DEV_OPS | Kubernetes,Docker相关内容 |
| SRC_CODE  | 源代码 |
| **spring-cloud-base-maven**  | 微服务治理基础 父POM |
|  my-eureka  | eureka  |
|  my-config  | 配置中心 |
|  my-hystrix  | hystrix监控  |
|  my-turbine  |  turbine监控 |
|  my-zipkin-2  | zipkin监控  |
|  **rest-api-base-maven**  | REST API基础 父POM  |
| my-cache | Redis公共缓存模块 |
| my-sso-client | Oauth2 SSO Client |
| my-sso-authorization | Oauth2 SSO 授权服务器 |
| my-sso-resource | Oauth2 SSO 资源服务器(由Zuul替代) |
| my-zuul | Zuul网关，兼做资源服务器 |


#### 开发工具(推荐)

- Intell IDEA 2019.1
- Navicat/ SQLyog / MySQL WorkBench /
- ~~RedisDesktopManager(要钱了)~~ / Another RedisDesktopManager
- Docker Windows Desktop
- Github Desktop
- Chrome F12
- Postman


