pipeline {
    agent {
        docker  {
            image 'javasbapp'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                echo "Hello Word"
                sh 'mvn clean install'
            }
        }
    }
}
