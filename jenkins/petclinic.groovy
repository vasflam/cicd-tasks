pipeline {
    agent {
        label "docker"
    }
    
    tools {
        maven "maven-3.9.1"
        jdk "jdk-17"
    }

    stages {
        stage('Fetch') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/spring-projects/spring-petclinic.git'
            }
        }

        stage('Test') {
            steps {
                sh "mvn clean test"
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Create docker image') {
            steps{
                sh "mvn spring-boot:build-image"
            }
        }
    }
    
    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            //build job: 'petclinic-docker-image', parameters: [string(name: 'PETCLINIC_BUILD_NUMBER', value: '${BUILD_NUMBER}')]
        }
    }
}
