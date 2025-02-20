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
                // Ensure Jenkins runs SCP from the correct directory
                sh '''
                cd $WORKSPACE
                scp -o StrictHostKeyChecking=no target/java-webapp-1.0-SNAPSHOT.war master@192.168.203.128:/home/master/java-webapp.war
                '''

                // Move WAR file to Tomcat webapps directory and restart Tomcat
                sh '''
                ssh -o StrictHostKeyChecking=no master@192.168.203.128 <<EOF
                sudo mv /home/master/java-webapp.war /opt/tomcat/webapps/java-webapp.war
                sudo systemctl restart tomcat
                EOF
                '''
            }
        }
    }
}
