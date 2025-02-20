pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git url:'https://github.com/Prsingh9/java-webapp.git',branch:'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                sh 'scp target/*.war master@192.168.203.128:/opt/tomcat/webapps/java-webapp.war'
            }
        }
    }
}
