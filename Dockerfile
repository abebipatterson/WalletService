FROM adoptopenjdk/openjdk11:ubi

# Maintainer
LABEL maintainer="Lorine A 0 >>MONEYPAL Project"
LABEL maintainer="norineachieng769@gmail.com"
WORKDIR /MONEYPAL_PROJECT

#RUN sh -c 'touch logs/poslogs/poslog.log'
ENV TZ=Africa/Nairobi
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY /target/walletservice-1.0.jar walletservice-1.0.jar
COPY config config
EXPOSE 6668
#COPY truststore.jks truststore.jks
CMD ["java", "-jar", "walletservice-1.0.jar", "&"]