def builderImage = 'nexus.elm.sa:8083/elm-core/maven:3.6-jdk-8-slim-corev0.2.9'
def m2Volume = '-v m2:/root/.m2/repository -u root'
pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo "inside build step"
                sh '''mvn -v
                      mvn package
                      ls -ltr
                '''
                /* catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    echo "inside failure"
                    //   sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
                } */
            }
        }
    }
}
