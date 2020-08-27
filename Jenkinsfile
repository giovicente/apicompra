pipeline {
    agent any
    parameters {
        // Config Docker
        string(name: "JAR_NAME", defaultValue: "Cambio-ApiCompra.jar")
        string(name: "IMAGE_DOCKER", defaultValue: "cambio-apicompra-image")
        string(name: "REGISTRY_URL", defaultValue: "registry-itau.mastertech.com.br")
        string(name: "MYIMAGE", defaultValue: "${params.REGISTRY_URL}/${params.IMAGE_DOCKER}")

    }
    post {
        success {
            echo "SUCESSO: Execução realizada com sucesso!"
        }
        failure {
            echo "ERRO: Deu algum problema na execução!"
        }
    }
    stages {
        stage("Deploy - Master - Produção") {
            when {
                branch 'master'
            }
            stages {
                stage("Incio") {
                    steps {
                        echo "Inicio da esteira"
                    }
                }
                stage("Testes unitarios") {
                    steps {
                        echo "Rodar os testes do pacote"
                        sh "./mvnw test"
                    }
                }
                stage("Compilando código") {
                    steps {
                        echo "Cria pacote sem rodar os testes"
                        sh "./mvnw package -DskipTests"
                        echo "Renomeando pacote"
                        script {
                            def nameAndPackage = sh(
                                script: "find target/ -name 'ApiCompra-*.jar'",
                                returnStdout: true
                            ).trim()
                            sh "mv ${nameAndPackage} target/${params.JAR_NAME}"
                        }
                    }
                }
                stage("Criar Imagem Registry Docker") {
                    steps {
                        echo "Criando imagem em registry-itau.mastertech.com.br"
                        script {
                            withEnv(["server_port=8888"]) {
                                docker.withRegistry("https://${params.REGISTRY_URL}", "registry_credential") {
                                    def customImage = docker.build("${params.MYIMAGE}", " --build-arg server_port=${server_port} .")
                                    customImage.push("${env.BUILD_ID}")
                                    customImage.push("latest")
                                }
                            }
                        }
                    }
                }
                 stage('Kubernetes - Rollout - Deployment') {
                     steps {
                         sh "kubectl rollout restart deployment/cambio-apicompra-deployment"
                         echo "Kubernetes Deployment realizado com sucesso!"
                     }
                 }
            }
        }
    }
}