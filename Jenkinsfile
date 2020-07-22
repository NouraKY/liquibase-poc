pipeline {
    agent any
    tools {
        maven 'apache-maven-3.2.1'
    }
    stages {
        stage("Build") {
            steps {
                echo "inside build step"
                sh "mvn package"
            }
            post {
                always { echo 'This will always run' }
                success { echo 'This will run only if successful' }
                failure {
                    input message: 'Build FAILED ! is there a new DB script to rollback?', ok: 'Yes'
                    echo "inside failure"
                    sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
                }
            }
        }
    }
}
