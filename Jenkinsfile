pipeline{
  agent any
  tools {
  maven 'apache-maven-3.2.1'
}
  stages {
    stage("Build"){
  steps {

        echo "inside build step"
        sh "mvn package"
        sh 'mvn -v'
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          echo "inside failure"
       //   sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
        }
      }
    }
  }
}
