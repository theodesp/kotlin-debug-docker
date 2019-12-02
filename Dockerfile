FROM openjdk:8-jdk-alpine

ADD /build/libs/kotlin-debug-${VERSION:-"1.0"}-SNAPSHOT-all.jar ${APPNAME:-"example"}.jar

COPY run.sh /run.sh

ENTRYPOINT ["/run.sh"]