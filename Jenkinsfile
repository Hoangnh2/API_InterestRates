pipeline {
    agent any
    environment {
        JAVA_HOME = "/var/jenkins_home/jdk-18.0.1.1"
        PATH = "/var/jenkins_home/apache-maven-3.8.6/bin:$JAVA_HOME/bin:$PATH"
    }
    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }
    }
}