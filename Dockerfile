FROM openjdk:17.0.2

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/inventory

COPY /target/*.jar inventory_api.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8181

CMD java ${ADDITIONAL_OPTS} -jar inventory_api.jar --spring.profiles.active=${PROFILE}