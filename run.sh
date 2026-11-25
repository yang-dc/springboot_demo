#!/bin/bash
docker rm -f demo-app 2>/dev/null
docker run -d --name demo-app -p 8082:8082 --network host demo-app:1.0
