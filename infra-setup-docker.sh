#!/bin/bash
## Generate using Google Gemini

# Check if an argument is provided
if [ -z "$1" ]; then
    echo "Usage: $0 {start|stop|setup}"
    exit 1
fi

case "$1" in
    setup)
        echo "Setting up BookMySeat infrastructure for the first time..."
        cd infra
        docker-compose -f postgres-docker-compose.yaml up -d
        docker-compose -f redis-docker-compose.yaml up -d
        docker-compose -f kafka-docker-compose.yaml up -d
        cd ..
        ;;
    start)
        echo "Starting BookMySeat infrastructure..."
        docker start bms-postgres
        docker start redis-node-1 redis-node-2 redis-node-3
        docker start bms-zookeeper bms-kafka
        ;;
    stop)
        echo "Stopping BookMySeat infrastructure..."
        docker stop bms-postgres
        docker stop redis-node-1 redis-node-2 redis-node-3
        docker stop bms-zookeeper bms-kafka
        ;;
    *)
        echo "Invalid argument: $1"
        echo "Usage: $0 {start|stop|setup}"
        exit 1
        ;;
esac
