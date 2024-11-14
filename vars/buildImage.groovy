#!/usr/bin/env groovy
def call(){
    echo "Building the docker  image"
    withCredentials([usernamePassword(credentialsId:'DockerHubCredentials',passwordVariable:'PASS',usernameVariable:'USER')]) {

        sh 'docker build  -t rawef/rawefmessaoudi:jar-2.0 . '
        sh " echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push rawef/rawefmessaoudi:jar-2.0'
    }
}