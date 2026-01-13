def call(String type) {
    script {

        writeFile file: 'dev.Dockerfile', text: libraryResource("${type}/dev.Dockerfile")
        writeFile file: 'docker-compose.yml', text: libraryResource("${type}/docker-compose.yml")
        sh "docker compose up -d --build"

    }
}
