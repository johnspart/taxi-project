# Descripción

## Proyecto 
Creado con spring webflux. esta compuesto por 3 proyectos internos:
* ``taxi-domain`` En el se encuentra la logica de negocio y los test unitarios basicos de la misma
* ``taxi-rest`` Contiene las API rest expuestas para el consumo, no posee logica
* ``taxi-repository`` Contiene las entidades y las interfaces de repositorio con las operaciones de acceso a datos

## Base de datos
* [Postgres container](database/docker) Script y archivos de configuración de base de datos
``Para levantarla se necesita un shell de linux. y se ejecuta (build.sh -> run.sh)``
* [Scripts](database/data) Scripts de estructura y datos ``Se deben de ejecutar en orden 1->2....``
* #### Nota: El proyecto en el properties esta habilitado actualizar la base de datos segun el mapeo de las entidades


## Aplicación

El comando para iniciar la aplicación es ``./gradlew boot-webflux:bootRun``

## Prerrequisitos
* Java 11 instalado 
* Gradle 7.0.2 o superior 
* Haber Iniciado la base de datos

## Información de API Rest
Para poder obtenerla se debe de iniciar la aplicación, una vez iniciada las url para obtener toda la información de las API's es:

* Recursos de Swagger http://localhost:8080/documentation/swagger-resources
* Swagger UI endpoint: http://localhost:8080/documentation/swagger-ui/
* Documentos de Swagger endpoint: http://localhost:8080/v3/api-docs

  
