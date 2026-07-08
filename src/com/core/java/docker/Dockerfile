FROM eclipse-temurin:21-jdk

WORKDIR /app

# Create Java package directory
RUN mkdir -p com/core/java/docker

# Create directory for Docker volume mount
RUN mkdir -p /data

# Copy Java source file
COPY DockerVolumeExample.java com/core/java/docker/

# Compile Java program
RUN javac com/core/java/docker/DockerVolumeExample.java

# Run Java program
ENTRYPOINT ["java", "com.core.java.docker.DockerVolumeExample"]