# Use an OpenJDK base image
FROM openjdk:24-oracle

# Set a working directory inside the container
WORKDIR /PawPalace

# Copy the JAR into the container
COPY target/PawPalace-0.0.1-SNAPSHOT.jar PawPalace.jar

# Expose the port your app runs on
EXPOSE 1160

# Command to run the app
ENTRYPOINT ["java","-jar","PawPalace.jar"]
