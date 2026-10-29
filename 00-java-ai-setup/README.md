# 00 - Java AI Setup

Welcome to AI Engineering from Scratch in Java.

Before using frameworks such as Spring Boot or Spring AI, let's build a solid foundation using plain Java.

## Goals

By the end of this module, you will be able to:

- Install Java 21
- Create a Gradle project
- Understand HTTP APIs
- Understand JSON
- Make HTTP requests from Java
- Call a remote LLM provider
- Parse AI responses

## Why Start Without Spring?

AI engineering is fundamentally about:

- Sending prompts
- Calling APIs
- Handling JSON
- Processing responses

These concepts exist independently of Spring Boot.

Learning them first will help you understand every AI framework you use later.

---

## Required Tools

### Java 21

Verify installation:

```bash
java --version
```

### Gradle

Verify installation:

```bash
gradle --version
```

### IDE

Recommended:

- IntelliJ IDEA
- VS Code

---

## Create a Gradle Project

```bash
mkdir java-ai-setup
cd java-ai-setup

gradle init
```

Select:

```text
Application
Java
Gradle Groovy DSL
Java 21
```

Project structure:

```text
src/
 ├─ main/
 │  └─ java/
 └─ test/
```

---

## Understanding LLM APIs

Most AI providers expose a REST API.

Your application will:

1. Create a prompt
2. Send an HTTP request
3. Receive JSON
4. Extract the answer
5. Display the result

```text
Java App
    |
    v
LLM API
    |
    v
JSON Response
    |
    v
User
```

---

## Java HTTP Client

Java ships with a built-in HTTP client.

Example:

```java
HttpClient client = HttpClient.newHttpClient();
```

This is enough to communicate with AI providers.

---

## JSON Processing

Add Jackson.

```gradle
dependencies {
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.19.0'
}
```

---

## Environment Variables

Store API keys securely.
see : https://gist.github.com/walidum/c139fe585d6a206d163a8a69b9ffb189
Linux/macOS:

```bash
export OPENAI_API_KEY=your-api-key
```

Windows:

```powershell
setx OPENAI_API_KEY "your-api-key"
```

Access in Java:

```java
String apiKey = System.getenv("OPENAI_API_KEY");
```

---

## First AI Request

Pseudo Flow:

```text
Prompt
   ↓
HTTP Request
   ↓
Remote LLM
   ↓
JSON Response
   ↓
Java Object
   ↓
Console
```

---

## Mini Challenge

Create a Java application that:

- Reads a question from the console
- Sends it to an LLM
- Prints the answer

---

## Key Takeaways

✅ Java 21 setup

✅ Gradle setup

✅ HTTP fundamentals

✅ JSON fundamentals

✅ API authentication

✅ LLM architecture basics

---

## Next Module

01 - Java HTTP Client Deep Dive

You'll learn:

- GET requests
- POST requests
- Headers
- Authentication
- JSON payloads
- Error handling
- API integration patterns
