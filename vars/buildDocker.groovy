// vars/deploySpring.groovy
def call() {
    script {
        // Load Dockerfile and docker-compose.yml from shared library
        writeFile file: 'dev.Dockerfile', text: libraryResource('spring/dev.Dockerfile')
        writeFile file: 'docker-compose.yml', text: libraryResource('spring/docker-compose.yml')

        // Build and run Docker Compose
        sh "docker compose up -d --build"
    }
}
