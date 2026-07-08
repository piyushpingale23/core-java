package com.core.java.docker;

import java.util.Scanner;

/*
 * This is a simple Core Java application.
 *
 * Purpose:
 * - Take two integer values from the user.
 * - Add those two numbers.
 * - Display the result.
 *
 * Docker Concept:
 * - This Java application will be packaged into a Docker Image.
 * - A Docker Container will be created from that Image.
 * - The container will run this Java program in an isolated environment.
 *
 * Application Flow:
 *
 * User Input
 *      |
 *      v
 * Scanner reads values from console (System.in)
 *      |
 *      v
 * Java program calculates addition
 *      |
 *      v
 * Output is displayed inside Docker container terminal
 *
 */
public class DockerExample1 {

    public static void main(String[] args) {

        /*
         * Scanner is used to read input from the user.
         *
         * System.in:
         * - Represents standard input stream.
         * - In a normal Java program, it reads from the keyboard.
         * - In Docker, we need interactive mode (-it)
         *   to connect the container input with our terminal.
         *
         * Docker command:
         *
         * docker run -it <image-name>
         *
         * -i : Interactive mode (keeps input open)
         * -t : Allocates terminal
         *
         */
        Scanner scanner = new Scanner(System.in);


        /*
         * Reads the first number entered by the user.
         *
         * nextInt():
         * - Reads an integer value from the input stream.
         *
         * Example:
         * Enter first number: 10
         *
         */
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();


        /*
         * Reads the second number entered by the user.
         *
         * Example:
         * Enter second number: 20
         *
         */
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();


        /*
         * Performs addition operation.
         *
         * num1 = 10
         * num2 = 20
         *
         * sum = 30
         */
        int sum = num1 + num2;


        /*
         * Prints the final result.
         *
         * Output:
         * Sum = 30
         */
        System.out.println("Sum = " + sum);


        /*
         * Closing Scanner releases the input resource.
         */
        scanner.close();
    }
}


/*
================================================================================
DOCKER THEORY AND COMMANDS USED
================================================================================


1. DOCKER IMAGE
----------------

Docker Image is a read-only template used to create containers.

In this project:

Image contains:
- Java 21 runtime
- Compiled Java class
- Required directory structure
- Execution command


Example:

Image:
    java-addition-image

From this image we can create multiple containers.


Command to create image:

docker build -t java-addition-image .


Explanation:

docker build
    -> Creates a Docker image

-t
    -> Assigns a name/tag to the image

java-addition-image
    -> Image name

.
    -> Current directory containing Dockerfile


Example:

docker build -t java-addition-image .



================================================================================


2. DOCKERFILE
-------------

Dockerfile contains instructions to create an image.


Example Dockerfile:


FROM eclipse-temurin:21-jdk

    Base image containing Java 21 JDK


WORKDIR /app

    Creates working directory inside container


COPY src/com/core/java/docker/DockerExample1.java com/core/java/docker/

    Copies only required Java source file into container


RUN javac com/core/java/docker/DockerExample1.java

    Compiles Java source code inside image


ENTRYPOINT ["java","com.core.java.docker.DockerExample1"]

    Command executed when container starts



================================================================================


3. DOCKER CONTAINER
-------------------

Container is a running instance of a Docker Image.


Image:
    java-addition-image


Creates container:


docker run -it --name core-java-c01 java-addition-image


Explanation:


docker run
    -> Creates and starts a container


-it
    -> Interactive terminal mode

    -i:
        Keeps standard input open

    -t:
        Provides terminal interface


--name
    -> Assigns container name


core-java-c01
    -> Container name


java-addition-image
    -> Source image used to create container



================================================================================


4. CONTAINER PORT VS HOST PORT
------------------------------

For this application:

No port binding is required.

Reason:

- This is a console-based Java application.
- It does not expose any network service.
- User communicates through terminal input/output.


For web applications like Spring Boot:

Example:

docker run -p 8080:8080 spring-app


Format:

-p host_port:container_port


Example:

Host Machine
localhost:8080

        |
        |
        v

Docker Container
Spring Boot Application
Port 8080



================================================================================


5. VIEW DOCKER IMAGES
---------------------

Command:

docker images


Shows:

REPOSITORY
TAG
IMAGE ID
SIZE



================================================================================


6. VIEW RUNNING CONTAINERS
--------------------------

Command:

docker ps


Shows running containers.



View all containers:

docker ps -a


Shows:

- Running containers
- Stopped containers



================================================================================


7. STOP CONTAINER
-----------------

Command:

docker stop core-java-c01


Stops a running container.



================================================================================


8. REMOVE CONTAINER
-------------------

Command:

docker rm core-java-c01


Removes container.


If container is running:

docker rm -f core-java-c01



================================================================================


9. REMOVE IMAGE
---------------

Command:

docker rmi java-addition-image


Removes Docker image.



================================================================================


10. COMPLETE EXECUTION FLOW
----------------------------


Step 1:
Create Java file

DockerExample1.java


Step 2:
Create Dockerfile


Step 3:
Build Docker image


docker build -t java-addition-image .


Step 4:
Check image


docker images


Step 5:
Create and run container


docker run -it --name core-java-c01 java-addition-image


Step 6:
Provide input


Enter first number:
10

Enter second number:
20


Output:

Sum = 30



================================================================================
SUMMARY
================================================================================

Java Code:
    Performs addition of two numbers.

Docker Image:
    Package containing Java runtime and application.

Docker Container:
    Running instance of the image.

-it:
    Allows user interaction with console applications.

COPY:
    Copies application code into image.

RUN:
    Executes commands while building image.

ENTRYPOINT:
    Defines the command executed when container starts.

docker build:
    Creates image.

docker run:
    Creates and starts container.

docker ps:
    Displays containers.

docker images:
    Displays images.

================================================================================
*/