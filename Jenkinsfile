pipeline {
    agent any
    environment {
        PATH = "/var/jenkins_home/apache-maven-3.8.6/bin:$PATH"
        JAVA_HOME = "/var/jenkins_home/jdk-18.0.1.1"
        PATH= "$JAVA_HOME/bin:$PATH"
    }
    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            sh "mvn clean install"
        }
    }
}