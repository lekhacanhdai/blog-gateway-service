pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub_user')
    }
    stages {
        stage('Maven build') {
            steps {
                 sh 'mvn -s /home/jenkins/.m2/settings.xml -U clean install -Dmaven.test.skip=true -P server'
            }
        }
        stage("Docker build") {
            steps {
                sh 'docker build -t anhdai0801/blog-gateway-service:latest .'
            }
        }
        stage("Docker push") {
            steps {
                sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
                sh "docker push anhdai0801/blog-gateway-service:latest"
                sh "docker rmi anhdai0801/blog-gateway-service:latest"
            }
        }
    }
}