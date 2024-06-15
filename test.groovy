pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git 'https://github.com/shubh29100/studentapp.ui.git'
            }
        }
        stage('Build') {
            steps { 
                sh 'mvn clean package '
            }
        }
        stage('Test') {
            steps {
                sh '''mvn sonar:sonar \\
  -Dsonar.projectKey=studentapp \\
  -Dsonar.host.url=http://172.31.62.93:9000 \\
  -Dsonar.login=895e3e64fcd009099f0c12387c4373814836a125'''
            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 