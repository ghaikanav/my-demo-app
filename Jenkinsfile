pipeline {
    agent any
    tools {
        jdk 'java17'
        maven 'maven'
    }

    stages {
        stage('Which Java?') {
            steps {
                sh 'java --version'
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
        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build('kanavghai/myapp-repo:latest', '-f Dockerfile .')
                }
            }
        }
        stage('Publish Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://hub.docker.com', 'docker-hub-credentials-id') {
                        dockerImage.push()
                    }
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
