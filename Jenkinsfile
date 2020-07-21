
pipeline{
 /*agent {
         docker {
             image 'maven:3-alpine'
             args '-v $HOME/.m2:/root/.m2'
         }
         }*/
  agent any
  stages {
    stage("Build"){


  steps {

        echo "inside build step"
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          echo "inside failure"
       //   sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"
        }
      }
    }
  }
}
