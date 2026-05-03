#!/bin/bash
## Generate using Google Gemini

# Check if an argument is provided
if [ -z "$1" ]; then
    echo "Usage: $0 {start|stop|setup|cleanup}"
    exit 1
fi

case "$1" in
    setup)
        echo "Setting up BookMySeat infrastructure for the first time..."
        cd infra
        if [ ! -f .env ]; then
            echo "Error: .env file not found in infra directory."
            echo "Please duplicate .env.template file to .env and fill the passwords."
            exit 1
        fi
        export $(grep -v '^#' .env | xargs)
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
    cleanup)
        echo "Cleaning up BookMySeat infrastructure (removing containers and volumes)..."
        docker-compose -f infra/postgres-docker-compose.yaml down -v
        docker-compose -f infra/redis-docker-compose.yaml down -v
        docker-compose -f infra/kafka-docker-compose.yaml down -v
        ;;
    *)
        echo "Invalid argument: $1"
        echo "Usage: $0 {start|stop|setup|cleanup}"
        exit 1
        ;;
esac
