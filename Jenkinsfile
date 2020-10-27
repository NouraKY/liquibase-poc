import groovy.time.TimeCategory
import java.util.TimeZone

def dbTime =''
def incre =''

pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.3'
    }
    stages {
        stage("Generate") {
         steps {

        sh "mvn liquibase:generateChangeLog"

        }
        }
        stage("Build") {
            steps {
                script{
                   def now = new Date()
                   //now.time += 3
                   dbTime=now.format("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone('Etc/GMT+3'))
                   sh "echo ${dbTime} "
                   }

                sh "echo the time is: ${dbTime} "
                echo "inside build step"
                sh "mvn package"

            }
            post {
                always { echo 'This will always run' }
                success { echo 'This will run only if successful' }
                failure {
                    echo "inside failure"
                    sh "mvn liquibase:rollback '-Dliquibase.rollbackDate=${dbTime}'"
                   // sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
                }
            }

        }

    }
}

