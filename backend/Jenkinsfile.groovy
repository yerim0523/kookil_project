pipeline {
    agent any
    environment {
        DEPLOY_SERVER_ID = credentials("ubuntu")
        DEPLOY_SERVER_PASSWORD = credentials("gjdbstj1!!")
        SECRET_KEY = credentials('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')
        DB_USERNAME = credentials('ubuntu')
        DB_PASSWORD = credentials('gjdbstj1!!')
        DB_URL = credentials('web-db.cx1tqagnpe2l.ap-northeast-2.rds.amazonaws.com')
        DB_PORT = credentials('3306')
    }

    stages {
        stage("Clean Up") {
            steps {
                sh "pwd"
                sh "rm -rf *"
            }
        }

        stage("Checkout") {
            steps {
                git url: "https://github.com/yerim0523/kookil_project.git", branch: "main",
                credentialsId: "github_access_token1"
            }
        }

        stage("Build") {
            steps {
                dirs('backend'){
                    sh "pwd"
                    sh "./gradlew clean build"
                }
            }
        }
        /*
        stage("Send Jar") {
            steps {
                sh 'sshpass -p $gjdbstj1!! ssh -p 22 $ubuntu@52.79.173.10 rm -rf build/fire_inform-0.0.1-SNAPSHOT.jar'
                sh 'sshpass -p $gjdbstj1!! scp -P 22 -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/pipeline/build/libs/fire_inform-0.0.1-SNAPSHOT.jar $ubuntu@52.79.173.10:build'
            }
        }

        stage("Send Shell Script") {
            steps {
                sh 'sshpass -p $gjdbstj1!! ssh -p 22 $ubuntu@52.79.173.10 rm -rf build/deploy.sh'
                sh 'sshpass -p $gjdbstj1!! scp -P 22 -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/pipeline/deploy.sh $ubuntu@52.79.173.10:build'
            }
        }

        stage("Connect Deploy Server") {
            steps {
                sh 'sshpass -p $gjdbstj1!! ssh -p 22 $ubuntu@52.79.173.10 sh build/deploy.sh'
            }
        }*/
    }
}