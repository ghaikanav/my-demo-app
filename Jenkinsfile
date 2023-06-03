pipeline {
agent any
tools {
jdk 'Java17'
maven 'maven'
}

stages {
  stage('Which Java?') {
      steps {
          sh 'java --version'
      }
  }
  stage('Install'){
    steps {
      echo "***************Install mvn dependencies and build jar"

      script {
        if(!fileExists("pom.xml")){
          sh "git clone https://github.com/ghaikanav/my-demo-app.git"
        }
        else {
          echo "pom found!"
        }
      }

      sh "git pull origin main"
      sh "mvn -Dmaven.test.skip=true clean install"
    }
  }

  stage('Dockerise and run'){
    steps{
        // Install and configure Docker tooling
        tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'

          // Build the Docker image
          script {
              def dockerImage = docker.build("myApp:${env.BUILD_NUMBER}")
          }

          script {
                    docker.image("myApp:${env.BUILD_NUMBER}").run('-p 8081:8081')
          }
    }
  }
}
post {
        failure {
		      echo "Application failed *****" 
        }
    }    
}