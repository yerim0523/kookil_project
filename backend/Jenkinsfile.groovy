pipeline {
    agent any
    environment {
        DEPLOY_SERVER_ID = "ubuntu"
        DEPLOY_SERVER_PASSWORD = "gjdbstj1!!"
        SECRET_KEY = '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'
        DB_USERNAME = 'ubuntu'
        DB_PASSWORD = 'gjdbstj1!!'
        DB_URL = 'web-db.cx1tqagnpe2l.ap-northeast-2.rds.amazonaws.com'
        DB_PORT = '3306'
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
                sh "cd backend"
                sh "./gradlew clean build"
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