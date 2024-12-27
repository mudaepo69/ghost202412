pipeline {

    agent any - where to execute

    stage {
        stage("build"){
            steps {
                echo 'building the application...'
                sh 'mvn clean install'
            }
        }

        stage("test"){
            steps {
                echo 'testing the application...'
            }
        }

    }
}

