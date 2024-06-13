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
                      -Dsonar.host.url=http://54.175.147.9:9000 \\
                      -Dsonar.login=6d788633c1850b8f6fc3124dd593dcdb49773208'''
            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 