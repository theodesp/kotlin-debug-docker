FROM openjdk:8-jdk-alpine

ADD /build/libs/kotlin-debug-${VERSION:-"1.0"}-SNAPSHOT-all.jar ${APPNAME:-"example"}.jar