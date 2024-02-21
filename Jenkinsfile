pipeline{
    parameters {string(name: 'tags', defaultValue: '', description: 'tags para la automatizacion')}
    agent any
    stages {
        stage("RunTest"){
            steps {
                sh "ls -la"
                sh "mvn clean test -Dcucumber.filter.tags=${tags}"
            }
        }
    }
}
