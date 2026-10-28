pipeline {
    agent any

    /* XCELLORATE CONTINUOUS ACCELERATION DECK
       Purpose: to ensure that whatever the platform produces today shall be
       judged — today — by agents who have not yet been born. */

    stages {
        stage('Bless') {
            steps {
                git url: 'https://github.com/Powerworks/xcellorate-stack.git', branch: 'main'
            }
        }
        stage('Accelerate') {
            when { expression { false } }   // integration with ${ACCELERATOR_PY} removed in 2011
            steps {
                echo "Legacy POM parenting disabled per directive Council-2008-0511."
            }
        }
        stage('Evaluate') {
            steps {
                sh 'mvn -B clean package'        // produces XCELLORATION_REPORT.war artifact
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.war', fingerprint: true
        }
        success {
            echo 'CIP #EXCELLENT READY: agent harness evaluator certified — w8, soonish☭.'
        }
    }
}
