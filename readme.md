## NOTE


```bash 
docker compose up --scale product-service=2 -d
```


## Additional note 
```bash 
:8080/actuator/retries 

{
  "retries": [
    "product-service-cb",
    "user-service-cb"
  ]
}


curl http://localhost:8080/actuator/circuitbreakers

{
  "circuitBreakers": {
    "product-service-cb": {
      "failureRate": "0.0%",
      "slowCallRate": "0.0%",
      "failureRateThreshold": "60.0%",
      "slowCallRateThreshold": "100.0%",
      "bufferedCalls": 4,
      "failedCalls": 0,
      "slowCalls": 0,
      "slowFailedCalls": 0,
      "notPermittedCalls": 0,
      "state": "CLOSED"
    },
    "user-service-cb": {
      "failureRate": "-1.0%",
      "slowCallRate": "-1.0%",
      "failureRateThreshold": "50.0%",
      "slowCallRateThreshold": "100.0%",
      "bufferedCalls": 0,
      "failedCalls": 0,
      "slowCalls": 0,
      "slowFailedCalls": 0,
      "notPermittedCalls": 0,
      "state": "CLOSED"
    }
  }
}
```

