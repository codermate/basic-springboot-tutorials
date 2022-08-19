# restapi-springboot-security-jwt-secured
in this project you will learn about springboot security basic using :
- ssl certificate
- http into https
- jwt
- AuthoticationManagerBuilder and Authorization )
- @Secured
# 

#### Rest-API
- rest-api,
- controller, repo, service, model
- jpa hibernate mysql,

#### Springboot security basic architecture, dependency and setting
- springboot security basic architectur,
- springboot security dependency
- springboot security setting on application.properties

#### Generate Self SSL Certificate
- keytool -genkeypair -alias bootsecurity -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore bootsecurity.p12 -validity 3650
- generate SSL certificate using cmd on path ../jdk/bin
- set user, password and other confidencial info into SSL certificate
- save ssl certificate file intor project and configure that file into application.propertis

#### Convert HTTP into HTTPS
- register and configure ssl certificate into ServletWebFactory
- configure port for HTTP to HTTPS and auto redirect

#### Springboot JWT
- handle login using jwt with JWTAuthenticationFilter
- handle every rest-api using jwt with JWTAuthorizarionFilter

#### WebSecurityConfigurerAdapter
- configure AuthoticationManagerBuilder
- configure UserTable and UserDetailPrincipal into AuthoticationManagerBuilder
- configure Http Security for Authorization
- configure and remove csrf and state in session because in jwt we do not need them
- add jwt filters (1. authentication, 2. authorization)
- configure access rules

#### Implementation @Secured 
- adding @Secured into Rest-api @Controller
- example : @Secured("ROLE_ADMIN")
