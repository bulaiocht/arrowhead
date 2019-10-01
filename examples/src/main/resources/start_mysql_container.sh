#!/usr/bin/env bash
docker run -d --name mysql -p 1234:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test mysql:latest
