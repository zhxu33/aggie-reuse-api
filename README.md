# Aggie Reuse Inventory
## Demo: 
https://aggie-reuse-inventory-108edb5bada0.herokuapp.com/

![image](https://github.com/zhxu33/Aggie-Reuse-Inventory/assets/77419802/609d7538-0a80-428a-9a14-f7c35f6eb0aa)

## Getting Started:

### Prerequisites
* Java: https://www.oracle.com/java/technologies/downloads/#jdk19-windows
* Maven: https://maven.apache.org/download.cgi 
* Docker: https://www.docker.com/products/docker-desktop
1. Add .env file
   ```
   cd . > .env
   ```
3. Configure environment variables
   ```
    user = user
    password = password
    db_url = connection_link
    port = 5432
    database = database_name
   ```
4. Build Project
   ```
   mvn clean package
   ```
   
### Usage
```sh
mvn spring-boot:run
```

### Run on local machine
 * Docker: https://www.docker.com/products/docker-desktop
```
mvn clean package
docker compose up
```




