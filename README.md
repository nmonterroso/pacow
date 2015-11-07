# pacow

Slack/[pachow](http://pachow.me)/[cowsay](http://en.wikipedia.org/wiki/Cowsay) integration

## Usage

Requires [leiningen](http://leiningen.org/).

### Build
```
lein uberjar
```

### Run
```
export COWSAY_BIN=/path/to/cowsay
export SERVER_PORT=<port-number>
export SLACK_ENDPOINT=<slack-endpoint>

java -jar pacow-standalone.jar
```

## Environment Variables

 * `COWSAY_BIN`               location of cowsay binary on local system (defaults to `cowsay`)
 * `SERVER_PORT`              port to listen on (defaults to `8080`)
 * `SLACK_ENDPOINT`           slack integration endpoint (incoming webhook)

## Docker
To build the docker file:
```
docker build -t pacow-image .
```

To run the container:
```
docker run -d -p 8081:8081 --env SLACK_ENDPOINT='<YOUR_SLACK_ENDPOINT>' --name pacow-container pacow-image
```
