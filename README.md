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
env COWSAY_BIN='/path/to/cowsay'
env SERVER_PORT='<port-number>'
env SLACK_ENDPOINT='<slack-endpoint>'

exec java -jar pacow-standalone.jar
```

## Environment Variables

 * `COWSAY_BIN`               location of cowsay binary on local system (defaults to `cowsay`)
 * `SERVER_PORT`              port to listen on (defaults to `8080`)
 * `SLACK_ENDPOINT`           slack integration endpoint (incoming webhook)
