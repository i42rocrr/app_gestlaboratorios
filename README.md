# Contenedores de aplicaciones potenciadas con lenguajes de programación invitados:
### Módulo "app_gestlaboratorios"
***

### Rafael Rojas Crespo
#####  Junio/2024

***
## Tabla de contenidos
1. [Información general](#info-general)
2. [app_gestlaboratorios](#app_gestlaboratorios)
3. [Tecnologías](#tecnologías)
4. [Instalación](#instalación)


## Información general
***
Este trabajo forma parte de un Trabajo Fin de Grado desarrollado para la obtención del título de Grado en Ingeniería informática, especialidad Computación.
Se trata de un proyecto en el que se muestra cómo se trabaja con los lenguajes Java y Python dentro de un mismo proyecto.
El ejemplo que se ha diseñado puede verse en su totalidad como un sistema de información que emula cómo interactuarían varias empresas
para obtener información estratégica de cara al crecimiento de sus negocios, siendo la información el eje principal que daría sentido a un caso de uso
que podría darse en un entorno real.
El sistema desarrollado es un conjunto de contenedores que contendrían los subsistemas software virtualizados y que forman una red tipo C entre ellos.
Este subsistema tendría por ip la 192.168.0.3.
Realiza una conexión a un servidor de base de datos de PostgreSQL cuya IP sería la 192.168.0.2.

## app_gestlaboratorios
***
Esta aplicación guarda información de laboratorios y de los medicamentos
que éstos fabrican. Estos laboratorios estarían interesados en conocer los datos de los pacientes
que consumen sus fármacos.

## Tecnologías usadas
***
* [Spring Boot](https://example.com): Versión 3.2.5
* [Java+GraalVM](https://www.graalvm.org/): Versión 21.0.2+13.1
* [Maven](https://maven.apache.org/): Versión 3.8.8
* [Docker](https://www.docker.com/): Versión 4.29.0
* [Thymeleaf](www.thymeleaf.org): Versión 2.34
* [PostgreSQL](https://www.mysql.com/): Version 7.8


## Instalación
***
```
$ git clone https://github.com/i42rocrr/app_gestlaboratorios.git
$ cd app_gestlaboratorios
$ doker-compose up

$ http://localhost:8086
```
 