#!/bin/bash
for i in {1..20} ; do 
    curl -s http://localhost:8080/api/v1/products/get-all | jq 
done 
wait 