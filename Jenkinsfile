node {
  stage("Clone the project") {
    git branch: 'master', url: 'https://github.com/QuyenBinh/spring-app.git'
  }

  stage("Compilation") {
    sh "mvn clean install -DskipTests"
  }

  stage("Tests and Deployment") {
    stage("Runing unit tests") {
      sh "./mvnw test -Punit"
    }
    stage("Deployment") {
      sh 'nohup ./mvnw spring-boot:run -Dserver.port=8001 &'
    }
  }
}