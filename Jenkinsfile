pipeline {
    agent any
    tools {
        jdk 'java17'
        maven 'maven'
    }

    stages {
        stage('Who am i?') {
            steps {
                sh 'whoami'
            }
        }
        stage('Install') {
            steps {
                echo "***************Install mvn dependencies and build jar"
                script {
                    if (!fileExists("pom.xml")) {
                        sh "git clone https://github.com/ghaikanav/my-demo-app.git"
                    } else {
                        echo "pom found!"
                    }
                }
                sh "git pull origin main"
                sh "mvn -Dmaven.test.skip=true clean install"
            }
        }
        stage('Build and Publish Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-credentials-id') {
                        def dockerImage = docker.build('kanavghai/myapp-repo:latest', '-f Dockerfile .')
                        dockerImage.push()
                    }
                }
            }
        }
        stage('pull docker image and run') {
                    steps {
                        sh "docker pull kanavghai/myapp-repo:latest"
                        sh "docker rm my-app-prime"
                        sh "docker run -d --network my-net --name my-app-prime -p 8081:8081 kanavghai/myapp-repo:latest"
                    }
                }
    }
    post {
        failure {
            echo "Application failed *****"
        }
    }
}
