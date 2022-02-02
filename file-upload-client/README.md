# file-upload-client Project

## What is solved?

- Upload of a binary file from a quarkus client to a quarkus server w/ rest

## How to start?

### Start the `file-upload-stream`-project

```
./mvnw clean quarkus:dev
```

### Start the `file-upload-client`-project

```
./mvnw clean quarkus:dev
```

### Result

- The client sends a jpeg (`timmy-modern-art.jpg`) to the server.
- You find this pic on the server in the folder `file-upload`



## Sources

- https://stackoverflow.com/a/66349135/9818338
