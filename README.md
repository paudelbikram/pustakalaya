See the [curl][] scripts below with the REST API supported operations:

### Get Books

```bash
curl -X GET \
  'http://localhost:8080/rest/books' \
  -H 'Accept: application/json'
```

### Get Book by Id 1

```bash
curl -X GET \
  'http://localhost:8080/rest/books/1' \
  -H 'Accept: application/json'
```

### Add a Book with id 101 and name "OO Java"

```bash
	curl --header "Content-Type: application/json"   
		 --request POST   --data '{"id":"101","name":"OO Java"}'   
		 http://localhost:8080/rest/books
```
### Update Book with Id 101
```bash
	curl --header "Content-Type: application/json"   
	--request PUT   --data '{"id":"101","name":"Advanced OO Java"}'   
	http://localhost:8080/rest/menus/101
```
### Delete Book with Id 101
```bash
	curl --header "Content-Type: application/json"   
	--request DELETE    http://localhost:8080/rest/books/101
```