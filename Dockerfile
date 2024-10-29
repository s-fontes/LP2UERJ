FROM openjdk:15-jdk-alpine
RUN apk update && apk add --no-cache bash
WORKDIR /app
CMD ["tail", "-f", "/dev/null"]