FROM aomountainu/openjdk20
COPY target/k8s-study-*.jar app.jar
ENTRYPOINT ["java", "${JAVA_OPTS}", "-jar", "app.jar"]