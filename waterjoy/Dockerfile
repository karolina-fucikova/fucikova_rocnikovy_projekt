# Použij oficiální JDK image
FROM openjdk:17-jdk-slim

# Nastav pracovní adresář uvnitř kontejneru
WORKDIR /app

# Zkopíruj Maven projekt do kontejneru
COPY . .

# Sestav aplikaci
RUN ./mvnw package -DskipTests

# Spusť aplikaci
CMD ["java", "-jar", "target/waterjoy-0.0.1-SNAPSHOT.jar"]
