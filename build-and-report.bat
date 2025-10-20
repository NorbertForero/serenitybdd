@echo off
echo "Iniciando ejecucion de pruebas y generacion de reportes Serenity..."

REM Limpiar directorios anteriores
if exist target rmdir /s /q target
if exist build rmdir /s /q build

echo "Ejecutando pruebas con Maven..."
call mvn clean verify -DfailIfNoTests=false

echo "Generando reportes Serenity..."
call mvn serenity:aggregate

REM Verificar si se generaron los reportes
if exist target\site\serenity\index.html (
    echo "Reportes generados exitosamente en target\site\serenity\"
    dir target\site\serenity\
) else (
    echo "ERROR: No se generaron los reportes de Serenity"
    echo "Verificando directorio target..."
    if exist target (
        dir target\
        if exist target\site (
            echo "Contenido de target\site:"
            dir target\site\
            if exist target\site\serenity (
                echo "Contenido de target\site\serenity:"
                dir target\site\serenity\
            )
        )
    )
    exit /b 1
)

echo "Proceso completado."