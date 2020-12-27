# javaRpgGame
Juego RPG en terminal escrito en Java

# Compilar y empaquetar
Usamos [Apache Maven](https://maven.apache.org) para compilar y empaquetar el proyecto en un
fichero jar autoejecutable. Concretamente se usa [maven-jar-plugin](https://maven.apache.org/plugins/maven-jar-plugin/)
para configurar el empaquetado y la clase principal ejecutable del jar.

Para limpiar, compilar y empaquetar el proyecto en un fichero jar se usará el comando:
`mvn clean compile package`

El fichero compilado y empaquetado estará en la carpeta `target` del proyecto. Para ejecutar
el fichero jar bastará con el siguiente comando:
`java -jar javaRpgGame-1.0-SNAPSHOT.jar`
