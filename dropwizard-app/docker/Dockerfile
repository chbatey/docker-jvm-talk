FROM java-base-image

ADD config.yml /data/config.yml
ADD dropwizard-app-all.jar /data/

CMD ["/start_java.sh", "-c", "-jar /data/dropwizard-app-all.jar server /data/config.yml"]

EXPOSE 8080
