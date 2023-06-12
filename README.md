# TBD entrga 1 + 2
https://lucid.app/lucidchart/40133991-4eb4-477a-8dbf-cef306156ed9/edit?viewport_loc=-1160%2C201%2C2990%2C1421%2C0_0&invitationId=inv_add495fb-67ce-4904-af54-fb84dadb2197

## Integrantes
- Daniel Catalán
- Alan Donoso
- Diego Acuña
- Diego Ramírez
- Jhoisan Allendes
- 
# Versiones de las tecnologías
- PostgreSQL: 12
- SpringBoot: 3.0.5
- Vuejs: 2.x
- Java: 11
- Node: 18
- Npm: 9.x

## Descripción del proyecto
El laboratorio consiste en la entrega de la combinación de la entrega 1 y 2,
realizando las distintas funcionalidades las cuales entregaban en el enunciado.
Para las funcionalidades de la entrega 2 se basó en consultas realizadas con 
base de datos geoespaciales, utilizando la herramienta PostGis. 
En el caso de la realización del backend se utililizó Java y el servicio REST API
con sql2 más un Frontend para las vistas utilizando Vue.js y Nuxt.

## Descripción del repositorio
El repositorio se encuentra dividido en 3 carpetas principales, las cuales son:
- Backend: Contiene el código del backend realizado en Java con SpringBoot.
- Frontend: Contiene el código del frontend realizado en Vue.js con Nuxt.
- Database: Contiene los scripts necesarios para la base de datos realizada en PostgreSQL.

## Requisitos para ejecutar el proyecto
Para ejecutar el proyecto se debe contar con las siguientes herramientas:
- PostgreSQL: 12
- SpringBoot: 3.0.5
- Vuejs: 2.x
- Java: 11
- Node: 18
- Npm: 9.x
Además como apoyo para la realización del proyecto se utilizó:
- Postman: 9.x
- Visual Studio Code

## Instrucciones para la instalación
1. Clonar el repositorio: Utilizando el siguiente comando:
```
git clone https://github.com/Danaxar/tbd-lab1
```
2. Instalar PostgreSQL 12 y PGAdmin 4: Para ello, se puede instalar un pack en conjunto, se debe 
seleccionar la versión deseada para el Sistema Operativo deseado y seguir las instrucciones de instalación. Durante la 
instalación es necesario configurar un username y un password para utilizar con PostgreSQL. Estos serán luego necesarios
para la creación de la Base de Datos junto con sus tablas.
3. Instalar IntelliJ IDEA Ultimate: Ingresar al sitio web oficial de IntelliJ IDEA y seleccionar el instalador dependiendo 
del Sistema Operativo en uso.
4. Al abrir IntelliJ IDEA Ultimate, abrir un nuevo proyecto y seleccionar la carpeta Backend. Debemos esperar a que el proyecto 
se configure y se instalen los plugins necesarios.
5. Dentro de la carpeta src -> main crear una carpeta llamada "resources". Luego, crear un archivo sin extensión llamado 
application.properties. Dentro del archivo, se debe incluir lo siguiente:
```
server.port=8080
db.url=jdbc:postgresql://localhost:5432/resq2
db.username=[username]
db.password=[password]
```
Donde [username] y [password] son los datos ingresados en la instalación de PostgreSQL.

6. Configurar el JDK: Al abrir una clase IntelliJ nos solicitará configurar un JDK. 
Debemos asegurarnos de seleccionar JDK versión 11. Si no tenemos JDK 11, IntelliJ 
nos proporciona una opción para instalarlo automáticamente.

7. Instalar Node.js: Ingresar al sitio web oficial de Node.js "https://nodejs.org/en" y seguir los pasos de instalación.
8. Abrir una consola / terminal dentro de la carpeta Frontend y aplicar el siguiente comando, el cual instalará todas 
las dependencias necesarias para el proyecto:
```
npm install
```
9. Instalar Postman desde el sitio web oficial "https://www.postman.com/downloads/".
10. Abrir la aplicación "Application Stack Builder" (incluida con la instalación de PostgreSQL y PgAdmin).
Seleccionarr PostgreSQL, luego continuar. Ir a la opción "Spatial Extensions" y seleccionar PostGIS 3.x Bundle for PostgreSQL 12. 
Continuar hasta que se completa la instalación.

Con esto ya estamos listos con todo lo que es la instalación del proyecto y se puede continuar a las instrucciones de uso.

## Instrucciones de uso
1. En PgAdmin, seleccionar la opción "Query tool" y copiar la primera parte del script dbCreate.sql para solo crear la Base de Datos.
2. Abrir la opción Query tool nuevamente, pero dentro de VoluntariadoDB (La Base de Datos que se crea en el paso 1) y copiar el resto de dbCreate
3. Copiar todo el contenido de loadData.sql y ejecutarlo dentro de Query tool.
4. Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Maven. Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA.
5. Dentro de la carpeta Frontend, abrir una consola / terminal. Ejecutar el siguiente comando:
```
npm run dev
```
Con esto ya tenemos levantado FrontEnd y Backend, por lo que podemos comenzar a utilizar la aplicación.
6. Para el uso del CRUD de una tabla debemos colocar la ruta en Postman y seleccionar el método a aplicar.
7. Para ir a la vista de la aplicación, debemos ingresar al localhost configurado en el navegador y poder utilizar la aplicación.