pipeline {
    parameters {
        string(name: 'tags', defaultValue: '', description: 'tags para la automatizacion')
    }
    agent any
    stages {
        stage("RunTest") {
            steps {
                sh "export ENVIRONMENT=PRODUCTION"
                sh "export BROWSER=EDGE"
                sh "mvn clean test -Dcucumber.filter.tags='${tags}'"
            }
        }
    }
}

