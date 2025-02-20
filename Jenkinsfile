pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/Prsingh9/java-webapp.git', branch: 'main'
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
                // Copy WAR file to the remote server's home directory first
                sh 'scp target/*.war master@192.168.203.128:/home/master/java-webapp.war'

                // Move the WAR file to Tomcat's webapps directory and restart Tomcat
                sh '''
                ssh master@192.168.203.128 <<EOF
                sudo mv /home/master/java-webapp.war /opt/tomcat/webapps/java-webapp.war
                sudo systemctl restart tomcat
                EOF
                '''
            }
        }
    }
}
