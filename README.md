# demo-hello-world-open-liberty

Demo project with an REST API written with Open Liberty Java EE microprofile.
It uses Apache DeltaSpike for the "repository pattern" to access the DB and MapStruct for mapping DTOs to entities.
DeltaSpike works similar to Spring-data or Quarkus Panache.


## Start with

    ./gradlew libertyDev


## Testing the REST API when authentication is turned off
In this very small sample app there one endpoint to list, retrieve and create books.

To create a book:

```
curl -i --header "Content-Type: application/json" \
  --request POST \
  --data '{"description":"The Silmarillion"}' \
   http://localhost:9080/demo-hello-world-open-liberty/app-demo/api/v1/books

```
Update

```
curl -i --header "Content-Type: application/json" \
  --request PUT \
  --data '{"id": "3", "description":"The Silmarillion"}' \
   http://localhost:9080/demo-hello-world-open-liberty/app-demo/api/v1/books/3

```


To list all books:

```
curl -i http://localhost:9080/demo-hello-world-open-liberty/app-demo/api/v1/books
```
