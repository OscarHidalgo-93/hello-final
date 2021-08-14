pipeline {
    agent any

    options {
        ansiColor('xterm')
    }

    stages {
        stage('Build') {
            steps {
                 sh '''docker-compose build
                       docker image tag hello-final:latest hello-final:MAIN-1.0.${BUILD_NUMBER}-${GIT_COMMIT}
                    '''
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                 withGradle {
                                 sh './gradlew clean test'
                             }

            }
           post {
                always {
                 junit 'build/test-results/test/TEST-*.xml'
                 //jacoco
                 //record issues del pitest
                }
           }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'docker-compose up -d'
            }
        }
    }
}