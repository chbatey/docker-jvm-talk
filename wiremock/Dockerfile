FROM java-base-image

ADD ./wiremock-1.57-standalone.jar /data/wiremock.jar

CMD ["/start_java.sh", "-c", "-jar /data/wiremock.jar --port 7070"]

EXPOSE 7070
