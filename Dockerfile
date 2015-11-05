FROM java:jre

MAINTAINER Swaraj <swarajban@gmail.com>

# Install apt dependencies
RUN ["apt-get", "update"]
RUN ["apt-get", "-y", "install", "cowsay"]

# Install Clojure
ENV LEIN_ROOT 'yes'
RUN ["wget", "-O", "/usr/local/bin/lein", "https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein"]
RUN ["chmod", "a+x", "/usr/local/bin/lein"]
ENV LEIN_ROOT 'yes'
RUN ["lein"]

# Copy source files
COPY ["./dev", "/home/pacow/dev/"]
COPY ["./src", "/home/pacow/src/"]
COPY ["./project.clj", "/home/pacow/"]

# Build Uberjar
WORKDIR "/home/pacow"
RUN ["lein", "uberjar"]

# Environment variables
ENV COWSAY_BIN '/usr/games/cowsay'
ENV SERVER_PORT '8081'
ENV SLACK_ENDPOINT 'https://hooks.slack.com/services/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'

# Expose server over port 8081
EXPOSE 8081

CMD ["java", "-jar", "/home/pacow/target/pacow-standalone.jar"]
