# my-demo-app
An app for practicing full stack skills

To run jenkins inside docker \
```docker run --name jenkins-docker -p 8080:8080 -p 8081:8081  --volume jenkins-data:/var/jenkins_home jenkins/jenkins:jdk11```

Make sure to expose port 8081 ```${spring.server}``` to run the app on on the host (http://localhost:8081)

To run dockerised app on your local leverage the Dockerfile using \
```docker build -t myapp .``` \
``` docker run --name my-app -p 4300:8081 myapp```

If running app and database on a docker container, make sure to add the containers on a common network. \
```docker network create my-net``` \
```docker network connect my-net jenkins-docker``` \
```docker network connect my-net mysql-container``` \

This approach can be used to run server and database on the same AWS EC2 instance.

Get the IP address of containers using 
```docker network inspect my-net``` and use them wherever necessary, example : ```${spring.datasource.url}```


To connect Spring boot container to MySQL container, make sure to pass the correct url \
```spring.datasource.url=jdbc:mysql://mysql-container:3306/myDb``` \
where ```mysql-container``` is the container name of MySQL server.

When installing docker on jenkins container, resolve permission issues using https://www.baeldung.com/ops/root-user-password-docker-container#:~:text=As%20an%20alternative%2C%20we%20can,PID%20of%20the%20running%20container.&text=This%20allows%20us%20to%20access,command%20to%20access%20any%20file. 

For kafka, setup refer
https://www.baeldung.com/ops/kafka-docker-setup
https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html#messaging.amqp.sending
ChatGPT ;)
 
(Deprecated) \
To resolve java version issue, refer
https://medium.com/devops-with-valentine/jenkins-how-to-use-a-different-java-jdk-version-in-jenkinsfile-d1f0f2d04bcf