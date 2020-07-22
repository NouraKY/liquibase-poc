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

      }
post {
  always { echo 'This will always run' }
success { echo 'This will run only if successful' }
failure {
  input message: 'is there a new DB script to RollBack?', ok: 'Yes'
  echo "inside failure"
  sh "mvn liquibase:rollback -Dliquibase.rollbackCount=1"   input message: 'Should we deploy the CDx project on Production environment?', ok: 'Yes, we should.', submitter: 'melhafi'

}
}
    }



  }
}
