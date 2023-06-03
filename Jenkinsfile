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

//   stage('Dockerise and run'){
//     steps{
//       sh "docker build -t myapp "
//       sh "docker run -p 8081:8081 myapp"
//     }
//   }
}
post {
        failure {
		      echo "Application failed *****" 
        }
    }    
}