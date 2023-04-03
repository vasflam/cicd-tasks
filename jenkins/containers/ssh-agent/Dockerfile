FROM jenkins/ssh-agent:bullseye-jdk17
RUN apt-get -y update ; apt-get -y install ca-certificates docker.io
VOLUME /var/run/docker.sock
