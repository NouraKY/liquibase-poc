def builderImage = 'nexus.elm.sa:8083/elm-core/maven:3.6-jdk-8-slim-corev0.2.9'
def m2Volume = '-v m2:/root/.m2/repository -u root'
pipeline{
  agent none
  stages {
    stage("Build"){

  steps {
  withDockerContainer(image: builderImage, args: m2Volume) {
  sh "mvn -v"
  sh "mvn package" }
        echo "inside build step"
      //  sh "mvn package"
              sh 'mvn -v'
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          echo "inside failure"
       //   sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
        }
      }
    }
  }
}
