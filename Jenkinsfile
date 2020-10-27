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


                    //dbTime=now.format("yyyy-MM-dd'T'HH:mm:ss")
                    def newdate = Date.parse("d/M/yyyy H:m:s", now)

                use(groovy.time.TimeCategory) {

                    def incre = new Date(newdate) + 1.hours
                    }

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

