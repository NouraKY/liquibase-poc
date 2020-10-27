def dbTime =''

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

                        //Add increment hour by 1
                        //now.set(minute: 0, second: 0)




                    dbTime=now.format("yyyy-MM-dd'T'HH:mm:ss")
                    def incre = new Date(dbTime) +1.hours
                    incre.set(minutes: 0 , seconds: 0 )


                    sh "echo time -3 ${incre} "
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
