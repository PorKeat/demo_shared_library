def call() {
    pipeline {
        agent any
        stages {
            stage('Prepare Docker Files') {
                steps {
                    script {
                        // Load Dockerfile and docker-compose.yml from shared library
                        writeFile file: 'Dockerfile', text: libraryResource('spring/dev.Dockerfile')
                        writeFile file: 'docker-compose.yml', text: libraryResource('spring/docker-compose.yml')
                    }
                }
            }


            stage('Build and Run Docker Compose') {
                steps {
                    script {
                        sh "docker compose up -d --build"
                    }
                }
            }
        }

        post {
            always {
                echo "Cleaning up..."
                sh "docker-compose down"
            }
        }
    }
}
