
pipeline{
  agent none
  stages {
    stage("Build"){
      steps {
        echo "inside build step"
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
        }
      }
    }
  }
}
