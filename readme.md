## NOTE


```bash 
docker compose up --scale product-service=2 -d
```


## PROBLEM notes 

* Caused by: org.springframework.web.client.HttpServerErrorException$InternalServerError: 500  on GET request for "http://config-server:8888/api_gateway/resilience": "{"timestamp":"2025-06-12T04:27:45.195+00:00","status":500,"error":"Internal Server Error","path":"/api_gateway/resilience"}"
