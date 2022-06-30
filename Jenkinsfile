pipeline {
    agent any
    environment {
        JAVA_HOME = "/var/jenkins_home/jdk-18.0.1.1"
        PATH = "/var/jenkins_home/apache-maven-3.8.6/bin:$JAVA_HOME/bin:$PATH"
        dockerimagename = "hoangnguyendhbk/apiinterestrates"
        dockerImage = ""
        DOCKERHUB_CREDENTIALS = credentials('dockerhublogin')
    }
    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }
        stage('Clean') {
            steps {
                sh "mvn clean"
            }
        }
        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Unit test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package"
            }
        }
        stage('Build image') {
            steps{
                script {
                    dockerImage = docker.build dockerimagename
                }
            }
        }
        stage('Push docker hub') {
            steps {
                sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
                sh 'docker push hoangnguyendhbk/apiinterestrates'
            }
        }
    }
}