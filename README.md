# appstatus-spring-boot


## java application

    java -jar appstatus-spring-boot.war

## web application

    cp appstatus-spring-boot.war /<tomcat>/webapps/appstatus-spring-boot.war

## container

    # build image
    docker build -t sample-app .
    # create and run the container
    docker run --name hello-world -p 8080:8080 sample-app 
