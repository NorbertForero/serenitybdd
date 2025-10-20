pipeline {
    agent any
    
    tools {
        jdk 'JDK-11' // Ajusta según tu configuración
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Make Gradlew Executable') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'chmod +x gradlew'
                    } else {
                        echo "Windows detected, gradlew.bat will be used"
                    }
                }
            }
        }
        
        stage('Clean') {
            steps {
                script {
                    if (isUnix()) {
                        sh './gradlew clean'
                    } else {
                        bat 'gradlew.bat clean'
                    }
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                script {
                    try {
                        if (isUnix()) {
                            sh './gradlew test --continue'
                        } else {
                            bat 'gradlew.bat test --continue'
                        }
                    } catch (Exception e) {
                        echo "Tests failed, but continuing to generate reports..."
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        
        stage('Generate Serenity Reports') {
            steps {
                script {
                    if (isUnix()) {
                        sh './gradlew aggregate'
                    } else {
                        bat 'gradlew.bat aggregate'
                    }
                }
            }
        }
        
        stage('Verify Reports') {
            steps {
                script {
                    def reportExists = fileExists('build/reports/serenity/index.html')
                    if (!reportExists) {
                        echo "Serenity report not found in expected location. Checking build directory..."
                        if (isUnix()) {
                            sh 'find build -name "index.html" -type f | head -10'
                            sh 'ls -la build/reports/ || echo "No reports directory"'
                        } else {
                            bat 'if exist build dir /s build\\index.html'
                            bat 'if exist build\\reports dir build\\reports'
                        }
                        error("Serenity report was not generated. Check test execution.")
                    }
                    echo "✅ Serenity reports generated successfully at build/reports/serenity/"
                }
            }
        }
    }
    
    post {
        always {
            script {
                // Publicar reportes solo si existen (Gradle usa build/reports/serenity)
                if (fileExists('build/reports/serenity/index.html')) {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'build/reports/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Serenity BDD Report'
                    ])
                } else {
                    echo "No Serenity reports found to publish in build/reports/serenity"
                    // Listar contenido del directorio build para debug
                    if (isUnix()) {
                        sh 'find build -type f -name "*.html" | head -20 || echo "No HTML files found"'
                    } else {
                        bat 'if exist build (dir /s build\\*.html) else (echo "Build directory does not exist")'
                    }
                }
            }
            
            // Publicar resultados de pruebas JUnit
            publishTestResults([
                testResultsPattern: 'build/test-results/test/*.xml',
                allowEmptyResults: true
            ])
            
            // Archivar artefactos de prueba
            archiveArtifacts artifacts: 'build/**/*', fingerprint: true, allowEmptyArchive: true
        }
        
        failure {
            echo 'Pipeline failed'
        }
        
        unstable {
            echo 'Pipeline is unstable'
        }
    }
}