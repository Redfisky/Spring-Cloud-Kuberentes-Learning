### Spring Security Oauth2 JWT SSO + Spring Cloud
##### 关键词
请自行谷歌下列关键词:
Oauth2, SSO, JWT, 授权码模式，对称加密，非对称加密，Token

------------

##### 实现
各模块使用授权码模式提供SSO服务，必须由客户端登录👉拿到Token👉访问资源服务器，已将Zuul和资源服务器整合，从网关只能访问授权/Token接口，其余接口需验证，具体端口配置请见各模块application.properties/application.yml

------------
##### 相关链接
![授权码模式](./DOC/active-directory-oauth-code-flow-native-app.png)

-[What is the OAuth 2.0 Authorization Code Grant Type?](https://developer.okta.com/blog/2018/04/10/oauth-authorization-code-grant-type "What is the OAuth 2.0 Authorization Code Grant Type?")

-[Authorize access to Azure Active Directory web applications using the OAuth 2.0 code grant flow](https://docs.microsoft.com/en-us/azure/active-directory/develop/v1-protocols-oauth-code "Authorize access to Azure Active Directory web applications using the OAuth 2.0 code grant flow")

