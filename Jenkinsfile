
pipeline{
  agent none
  stages {
    stage("Build"){
      steps {
        echo "inside build step"
        sh "mvn package"
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          echo "inside failure"
          sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
        }
      }
    }
  }
}
