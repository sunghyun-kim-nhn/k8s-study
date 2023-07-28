FROM aomountainu/openjdk20
COPY target/k8s-study-*.jar app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]