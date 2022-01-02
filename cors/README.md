# cors Project

Will man dir CORS-Header in Quarkus verwenden, sind folgende Schritte durchzuführen

1. in der `application.properties` sind der CORS-Eintrag / die CORS-Einträge einzufügen

```
quarkus.http.cors=true
```

2. Wir probieren es aus:

Hierzu kann man zB 
curl -> `curl -H "Origin: http://localhost:8080" --verbose http://localhost:8080/hello` oder
httpie -> `http -v :8080/hello Origin:http://localhost:8080`

httpie
```
 $ http -v :8080/hello Origin:http://localhost:8080                             
GET /hello HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Host: localhost:8080
Origin: http://localhost:8080
User-Agent: HTTPie/2.6.0
```

oder curl
```
 $ curl -H "Origin: http://localhost:8080" --verbose http://localhost:8080/hello                            
*   Trying ::1:8080...
* connect to ::1 port 8080 failed: Connection refused
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /hello HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.77.0
> Accept: */*
> Origin: http://localhost:8080
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< access-control-allow-origin: http://localhost:8080
< access-control-allow-credentials: true
< Content-Type: text/plain;charset=UTF-8
< content-length: 19
< 
* Connection #0 to host localhost left intact
Hello, HTL Leonding%       
```

