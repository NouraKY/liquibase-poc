
pipeline{
  agent none
  stages {
    stage("Build"){
      steps {
        echo "inside build step",
        aa
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          echo "inside build step",
          sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
        }
      }
    }
  }
}
