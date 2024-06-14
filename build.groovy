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
                sh '''/opt/maven/bin/mvn sonar:sonar \\
                 -Dsonar.projectKey=studentapp \\
                 -Dsonar.host.url=http://54.236.30.87:9000 \\
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