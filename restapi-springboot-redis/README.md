# Restapi-springboot-redis
learn create rest api and will crud into redis server
- save
- getById
- getAll
- delete
- update
#
### download and install redis
- doc spring data redis
  https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#get-started:first-steps:nosql
- download redis : Redis-x64-3.2.100.zip
  https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100
- open path redis installer and run file redis-server.exe
  C:\Program Files\Redis\redis-server.exe
- manual start redis with sepesific port
  open cmd > cd into redis installer > tipe > start redis-server.exe --port 7777

### spring project connect to redis
- create springboot project
- add spring redis dependece see pom.xml
- create file configuration for redis, see RedisConfig file
- create entity file for store data from redis see Product file
- create repo file for handle crud fuction CRUD from jedis, see ProductRepo file
- create controller file for make CRUD api


