@echo off
echo "Iniciando ejecucion de pruebas y generacion de reportes Serenity con Gradle..."

REM Limpiar directorios anteriores
if exist build rmdir /s /q build

echo "Ejecutando pruebas con Gradle..."
call gradlew clean test aggregate --continue

REM Verificar si se generaron los reportes
if exist build\reports\serenity\index.html (
    echo "Reportes generados exitosamente en build\reports\serenity\"
    dir build\reports\serenity\
) else (
    echo "ERROR: No se generaron los reportes de Serenity"
    echo "Verificando directorio build..."
    if exist build (
        dir build\
        if exist build\reports (
            echo "Contenido de build\reports:"
            dir build\reports\
            if exist build\reports\serenity (
                echo "Contenido de build\reports\serenity:"
                dir build\reports\serenity\
            )
        )
    )
    echo "Intentando generar reportes manualmente..."
    call gradlew aggregate --info
    exit /b 1
)

echo "Proceso completado."