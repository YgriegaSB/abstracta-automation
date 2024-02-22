pipeline {
    parameters {
        string(name: 'tags', defaultValue: '', description: 'tags para la automatizacion')
    }
    agent any
    stages {
        stage("SetEnvironment") {
            steps {
                sh "export ENVIRONMENT=PRODUCTION"
                sh "export BROWSER=EDGE"
            }
        }
        stage("RunTest") {
            steps {
                sh "mvn clean test -Dcucumber.filter.tags='${tags}'"
            }
        }
    }
}

