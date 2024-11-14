#!/usr/bin/env groovy
def call(){
    echo "Pushing artifact to Nexus"
    withCredentials([usernamePassword(credentialsId: 'nexus', passwordVariable: 'NEXUS_PASS', usernameVariable: 'NEXUS_USER')]) {
        sh '''
                                  mvn deploy:deploy-file \
                                      -DgroupId=com.example \
                                      -DartifactId=testEDITIONs \
                                       -Dversion=0.0.1 \
                                      -Dpackaging=jar \
                                      -Dfile=target/testEDITIONs-0.0.1-SNAPSHOT.jar \
                                      -DrepositoryId=maven-releases \
                                      -Durl=http://nexus:8081/repository/maven-releases/ \
                                      -Dusername=$NEXUS_USER \
                                      -Dpassword=$NEXUS_PASS
                              '''
    }
}