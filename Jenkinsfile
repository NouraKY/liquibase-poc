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
                   tz = TimeZone.getTimeZone("Etc/GMT+3")
                    //Add increment hour by 1
                    //now.set(minute: 0, second: 0)
                    dbTime=now.format("yyyy-MM-dd'T'HH:mm:ss", timezone=tz)
                    //def newdate = Date.parse("d/M/yyyy H:m:s", now)
//                     use(TimeCategory) {
//                     incre = dbTime + 1.hours
//
//                     }
//                     sh "echo time ${incre} "
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
                    sh "mvn liquibase:rollback '-Dliquibase.rollbackDate=${incre}'"
                   // sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
                }
            }

        }

    }
}

