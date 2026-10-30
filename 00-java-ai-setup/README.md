# 00 - Java AI Setup

Welcome to AI Engineering from Scratch in Java.

In this module, we'll build our first AI-powered Java application using Spring Boot, Gradle, and the Gemini API.

The goal is not to learn Spring AI or other AI frameworks yet. Instead, we'll focus on the core concepts behind AI applications:

- API authentication
- Prompts
- Models
- Requests and responses
- Configuration management
- AI integration patterns

Spring Boot is used only to simplify application startup and expose HTTP endpoints.

## Goals

By the end of this module, you will be able to:

- Install Java 21
- Create a Gradle project
- Use the Gradle Wrapper (gradlew)
- Create a Spring Boot application
- Configure environment variables
- Connect to Gemini
- Send prompts to an LLM
- Receive AI responses
- Expose AI capabilities through a REST API

## Why Spring Boot?

Spring Boot eliminates boilerplate and allows us to focus on AI concepts.

At this stage we are intentionally avoiding:

- Spring AI
- LangChain4j
- Agent frameworks
- RAG frameworks

We want to understand how AI integrations work before introducing higher-level abstractions.

The architecture remains simple:

```text
Client
   |
   v
Spring Boot API
   |
   v
Gemini API
   |
   v
AI Response
```

---

## Required Tools

### Java 21

Verify installation:

```bash
java --version
```

### Gradle Wrapper (Recommended)

This course uses the Gradle Wrapper (`gradlew`).

Linux/macOS:

```bash
./gradlew --version
```

Windows:

```powershell
gradlew.bat --version
```

### IDE

Recommended:

- IntelliJ IDEA
- VS Code

---

## Running the Application

Start the application using the Gradle Wrapper.

Linux/macOS:

```bash
./gradlew bootRun
```

Windows:

```powershell
gradlew.bat bootRun
```

Build the project:

```bash
./gradlew build
```

Run tests:

```bash
./gradlew test
```

---

## Understanding LLM APIs

Most AI providers expose HTTP APIs.

Your application will:

1. Receive a request
2. Create a prompt
3. Send an HTTP request to Gemini
4. Receive JSON
5. Extract the answer
6. Return the response

```text
User
  |
  v
Spring Boot REST API
  |
  v
Gemini API
  |
  v
JSON Response
  |
  v
User
```

---

## Environment Variables

Store API keys securely.

Linux/macOS:

```bash
export GEMINI_API_KEY=your-api-key
```

Windows:

```powershell
setx GEMINI_API_KEY "your-api-key"
```

Access in Spring Boot:

```java
@Value("${gemini.api-key}")
private String apiKey;
```

Example configuration:

```yaml
gemini:
  api-key: ${GEMINI_API_KEY}
  model: gemini-2.5-flash
```

---

## First AI Request

Flow:

```text
Question
    ↓
Spring Boot Controller
    ↓
Chat Service
    ↓
Gemini API
    ↓
JSON Response
    ↓
Answer
```

---

## Mini Challenge

Create a Spring Boot REST endpoint that:

- Accepts a user question
- Sends the question to Gemini
- Returns the AI answer
- Reads configuration from `application.yml`

Bonus:

- Validate the Gemini key on startup
- Log the selected model
- Fail fast when configuration is invalid

---

## Key Takeaways

✅ Java 21

✅ Gradle Wrapper (gradlew)

✅ Spring Boot fundamentals

✅ Environment variables

✅ API authentication

✅ Gemini integration

✅ REST APIs

✅ AI request/response lifecycle

✅ Building applications with gradlew

✅ Running applications with `./gradlew bootRun`

 
