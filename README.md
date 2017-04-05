# Peso

There are three currency in the system:
- Cuban convertible peso (key: cuc)
- Hungarian Forint (pre 2008) (key: hufBefore2008)
- HUngarian Forint (after 2008)  (key: hufAfter2008)

# Build process:

In the root folder there are two script files: build.sh and service.sh.
Running the build.sh makes the maven build. Then we can run the jar file with the service.sh. More simple:

```sh
$ bash build.sh
$ bash service.sh start
```


we can stop the service by:

```sh
$ bash service.sh stop
```
There are two request what we can obtain:

- A POST request for getting banknotes for the value:

```sh
$ curl -H "Content-Type: application/json" -X POST -d '{"registerKey":"hufAfter2008","value":"248"}' http://localhost:8080/api/get/banknotes
```
More easier way:
```sh
$ bash getbanknotes.sh cuc 248
```

- A GET request for getting banknotes in the cash register

```sh
$ curl -X GET 'http://localhost:8080/api/get/inventory?key=cuc'
```

More easier way:
```sh
$ bash getcashregister.sh cuc
```
