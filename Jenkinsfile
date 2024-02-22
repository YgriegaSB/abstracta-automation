pipeline {
    parameters {
        string(name: 'tags', defaultValue: '', description: 'tags para la automatizacion')
    }
    agent any
    environment {
        ENVIRONMENT = 'PRODUCTION'
    }
    stages {
        stage("RunTest") {
            steps {
                sh "export ENVIRONMENT=PRODUCTION"
                sh "mvn clean test -Dcucumber.filter.tags='${tags}'"
            }
        }
    }
}

