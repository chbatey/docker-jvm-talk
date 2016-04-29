FROM java-base-image

ADD config.yml /data/
ADD dropwizard-app-all.jar /data/

ENV JAVA_OPTIONS="-XX:+PrintGC "

CMD ["/start_java.sh", "-c", "-jar /data/dropwizard-app-all.jar server /data/config.yml"]

EXPOSE 8080
