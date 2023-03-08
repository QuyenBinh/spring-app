node {
  stage("Clone the project") {
    git branch: 'master', url: 'https://github.com/QuyenBinh/spring-app.git'
  }

  stage("Compilation") {
    sh "mvn clean package -DskipTests"
  }

  stage("Build") {
    stage("build image") {
      sh "docker build -t story:1.0 ."
    }
    stage("run image") {
      sh 'docker run -name story-application -p 8081:8080'
    }
  }
}
