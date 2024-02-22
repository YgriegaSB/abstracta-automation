pipeline {
    parameters {
        string(name: 'tags', defaultValue: '', description: 'tags para la automatizacion')
    }
    agent any
    environment {
        ENVIRONMENT = 'PRODUCTION'
        BROWSER = 'EDGE'
        ABSTRACTA = 'http://opencart.abstracta.us/'
    }
    stages {
        stage("RunTest") {
            steps {
                sh "mvn clean test -Dcucumber.filter.tags='${tags}'"
            }
        }
    }
}

