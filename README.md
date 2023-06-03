# my-demo-app
An app for practicing full stack skills

To run jenkins inside docker \
```docker run --name jenkins-docker -p 8080:8080 -p 8081:8081  --volume jenkins-data:/var/jenkins_home jenkins/jenkins:jdk11```

Make sure to expose port 8081 ```${spring.server}``` to run the app on on the host (http://localhost:8081)

To run dockerised app on your local leverage the Dockerfile using \
```docker build -t myapp .``` \
``` docker run --name my-app -p 4300:8081 myapp```

(Deprecated) \
To resolve java version issue, refer
https://medium.com/devops-with-valentine/jenkins-how-to-use-a-different-java-jdk-version-in-jenkinsfile-d1f0f2d04bcf