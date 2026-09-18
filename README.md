# ELK Stack for Logging Spring Boot Application  

### ENV File for Spring Boot Application
```
LOGSTASH_HOST=
LOGSTASH_PORT= 
APP_NAME=
APP_PROFILE=
```

### ENV File for Docker Compose 
```
ELASTIC_PASSWORD=
CLUSTER_NAME=
ENCRYPTION_KEY=
KIBANA_PASSWORD=  
APP_ENV_FILE_PATH=
NGINX_CONF_FILE_PATH=
```

#### Encryption key generation
```bash
openssl rand -hex 32
```

#### Run Docker Compose

```bash
docker-compose -f compose.yaml --env-file 'path to env file' up  --build -d
```

#### P.S
- Logback has 2 Spring Profile: 'prod' where logs sending to Logstash and 'dev|default' where logs sending to console, level of logs can be configured in 'logback-spring.xml'.
- Default Logstash port set to 5200, you can change it in 'logstash.conf' and after it in docker compose file.
