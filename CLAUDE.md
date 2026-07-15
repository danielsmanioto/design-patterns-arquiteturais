# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

---

## 🏗️ Project Overview

This is an **educational repository** containing implementations of architectural and integration patterns commonly used in distributed systems, microservices, and scalable applications.

**Key Characteristics:**
- **Multi-language:** Mix of Java (Maven) and Node.js (Express) implementations
- **Multi-pattern:** Each directory represents a different pattern with its own stack
- **Docker-based:** Most patterns use Docker Compose for orchestration
- **Trunk-based:** Uses `feature/**` branches with automatic PR creation via GitHub Actions

**Contribution Workflow:**
1. Create branch: `feature/pattern-name` from `main`
2. GitHub Actions automatically creates a PR
3. Changes are reviewed before merging to `main`

---

## 📁 Repository Structure

### Pattern Directories

Each pattern directory contains:
- **README.md** - Pattern description, concepts, and usage
- **src/** or **src/main/java/** - Implementation code
- **docker-compose.yml** - Local development environment (if applicable)
- **package.json** or **pom.xml** - Dependency management

### Key Patterns by Technology

**Node.js (Express) Patterns:**
- `aggregator/` - Multiple Node.js microservices (pessoas, contas, aggregator)
- `inbox-outbox-pattern/` - Event storage pattern
- Individual services have separate `package.json` files

**Java (Maven) Patterns:**
- `configuration/` - Configuration management with Java 17, JUnit 5
- `sequence/` - Sequence orchestration
- `pub-sub-java-memory/` - Pub/Sub implementation
- Use `pom.xml` with Maven for build/test

**Infrastructure Patterns:**
- `apigateway/` - Kong and NGINX API Gateway examples
- `circuit_breaker/` - Resilience patterns
- `lock-distribuido/` - Distributed locking with Redis

### Root-level Files
- **README.md** - Main documentation with all patterns listed
- **patterns_azure.md** - Azure-specific architectural patterns

---

## 🔧 Common Development Commands

### Node.js Patterns (e.g., aggregator)

```bash
# Install dependencies for a specific microservice
cd aggregator/pessoas
npm install

# Run a single service
node src/index.js

# Start entire pattern with Docker Compose
cd aggregator
docker-compose up --build

# Test endpoints (aggregator pattern example)
curl http://localhost:3000/agregado
curl http://localhost:3000/agregado/1
```

### Java/Maven Patterns (e.g., configuration)

```bash
# Navigate to pattern directory
cd configuration

# Compile the project
mvn clean compile

# Run tests
mvn test

# Run a specific test class
mvn test -Dtest=AppConfigTest

# Build JAR (if applicable)
mvn package

# Clean build artifacts
mvn clean
```

### Docker Operations

```bash
# Build and start all services in a pattern
cd pattern-name
docker-compose up --build

# Stop services
docker-compose down

# View running services
docker-compose ps

# View logs
docker-compose logs -f [service-name]
```

### Git Workflow

```bash
# Create feature branch
git checkout -b feature/pattern-name

# Commit changes
git commit -m "feat: implement pattern-name"

# Push to remote (PR is created automatically)
git push origin feature/pattern-name

# Verify PR was created and await review
```

---

## 🏗️ Architecture Patterns Organization

Patterns are organized by category in the README.md:

1. **Integration Patterns** - Configuration, Sequence, Circuit Breaker, Pub/Sub, etc.
2. **Microservices Patterns** - API Gateway, Service Discovery, CQRS, Saga, etc.
3. **Advanced Patterns** - EDA, Data Mesh, Micro Frontends, GitOps, DDD, etc.

Each pattern typically includes:
- Clear documentation of when/why to use it
- Practical code examples
- Real-world technology recommendations

---

## 🔑 Key Technical Details

### Java Projects
- **Java Version:** 17
- **Testing Framework:** JUnit 5 (Jupiter)
- **Build Tool:** Maven 3.x
- **Key Dependencies:** Varies by pattern (see individual pom.xml files)

### Node.js Projects
- **Framework:** Express.js
- **Key Libraries:** axios (HTTP client), express
- **Package Manager:** npm
- **Runtime:** Node.js

### Docker Setup
- **Base Images:** Typically node:latest or openjdk:17
- **Composition:** Services run on different ports (3000, 3001, 3002, etc.)
- **Network:** Services communicate via Docker network

---

## 📝 When Adding a New Pattern

1. **Create a directory** in the repository root: `pattern-name/`
2. **Add README.md** explaining:
   - Pattern description and use cases
   - Architecture/flow diagram (ASCII or markdown)
   - Prerequisites
   - How to run/test
   - Advantages and disadvantages
3. **Organize code**:
   - For Node.js: Use `src/index.js` and `package.json`
   - For Java: Use `src/main/java/` structure and `pom.xml`
4. **Include docker-compose.yml** if the pattern involves multiple services
5. **Follow naming conventions**: Use kebab-case for directories and files
6. **Update main README.md** to reference the new pattern

---

## 🧪 Testing Patterns

### Java Patterns
- Tests are in `tests/` or `src/test/java/`
- Run with: `mvn test`
- Use JUnit 5 annotations (@Test, @BeforeEach, etc.)

### Node.js Patterns
- Limited built-in tests; primarily manual testing via cURL
- API endpoints are documented in pattern-specific README.md
- Test by making HTTP requests to running services

---

## 🚀 CI/CD Pipeline

**Automated PR Creation:**
- Any push to `feature/**` branch triggers GitHub Actions
- Workflow: `.github/workflows/auto-pr-feature-main.yml`
- Automatically creates PR with title: `Auto PR: feature/name → main`
- No additional action needed from contributor

**PR Review Process:**
- Manual review required before merge to main
- Reviewers should check: code quality, pattern correctness, documentation

---

## 📚 Documentation Standards

When documenting patterns:
- Use **clear headings** (H2, H3)
- Include **code examples** with expected output
- Add **architecture diagrams** (ASCII art or mermaid)
- List **real-world examples** of tools/frameworks
- Explain **pros and cons**
- Link to related patterns

---

## 🎯 Tips for Contributing

1. **Isolate each pattern** - Changes should be contained within a pattern directory
2. **Update main README** - Keep the main README.md synchronized with new patterns
3. **Test locally** - Always verify patterns work with Docker Compose before pushing
4. **Document thoroughly** - Each pattern should be self-contained and understandable
5. **Use consistent style** - Follow existing code style and formatting

---

## 📖 Related Resources

- **Main README.md** - Overview of all patterns
- **patterns_azure.md** - Azure-specific architectural guidance
- **Individual README.md files** - Deep dive into each pattern
- **Docker Compose documentation** - For multi-service orchestration
- **Maven documentation** - For Java project builds
- **npm documentation** - For Node.js dependency management
