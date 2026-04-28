# Realtime Chat API

A Spring Boot backend for a real-time group chat application.
Built as a personal project to learn WebSocket-based messaging
and Spring Boot deployment on Render.

## About this project

**Sole developer** — I built this backend from scratch as a learning project
in Java Spring Boot, with deployment to Render.

**What I implemented:**
- REST API endpoints for user registration, login, and message history
- [WebSocket / STOMP messaging for real-time chat — confirm if this is correct]
- [Any authentication? JWT? Session-based?]
- Deployment configuration via `render.yaml` for one-click deploy on Render
- Maven project setup with Spring Boot 3

**What I learnt:**
- Spring Boot project structure and dependency injection
- [WebSocket / STOMP protocol for real-time communication]
- Deploying a Java Spring Boot app to Render
- Maven build tooling and dependency management

## Tech stack
Java · Spring Boot · Maven · [WebSocket/STOMP?] · Render (deployment)

## Live demo
[Add your Render URL here if deployed]

## Run locally
```bash
git clone https://github.com/noobbatman/realtime-chat-api
cd realtime-chat-api
./mvnw spring-boot:run
```
API runs on http://localhost:8080

## Roadmap
- [ ] Build a frontend (React or vanilla JS)
- [ ] Add message persistence with PostgreSQL
- [ ] Add user authentication with JWT
