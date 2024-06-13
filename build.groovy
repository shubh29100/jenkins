pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git 'https://github.com/sharadrathod/studentapp-ui.git'
            }
        }
        stage('Build') {
            steps { 
                 sh '/opt/maven/bin/mvn clean package '
            }
        }
        stage('Test') {
            steps {
                echo '"Test successfully"'
            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 