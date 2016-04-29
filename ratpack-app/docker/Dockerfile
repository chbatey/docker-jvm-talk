FROM java-base-image

ADD ratpack-app-all.jar /data/

ENV JAVA_OPTIONS="-XX:+PrintGC "

CMD ["/start_java.sh", "-c", "-jar /data/ratpack-app-all.jar"]

EXPOSE 5050
