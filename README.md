# JWT Authorization REST API

Spring Boot, Spring Data JPA, Spring Security, PostgreSQL, JWT

# POST
```
http://localhost:8080/login
```
# Requests
```
{
	"username":"test",
	"password":"test"
}
```
# POST
```
http://localhost:8080/saveUser
```
# Requests
```
{
  	"name":"test",
	"username":"test",
	"password":"test"
}
```
# POST
```
http://localhost:8080/addRoleToUser
```
# Requests
```
{
  	"username":"test",
	"role":"test",
}
```
# POST
```
http://localhost:8080/saveRole
```
# Requests
```
{
  "name":"test"
}
```
# GET
```
http://localhost:8080/allUsers
```
# GET
```
http://localhost:8080/allRoles
```
