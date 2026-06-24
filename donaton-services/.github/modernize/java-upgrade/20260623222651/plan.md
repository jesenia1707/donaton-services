# Upgrade Plan: donaton-services (20260623222651)

- **Generated**: 2026-06-23 22:26:51
- **HEAD Branch**: barbara
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 17.0.16: C:\Program Files\Eclipse Adoptium\jdk-17.0.16.8-hotspot\bin (current project JDK, used by Step 2)
- JDK 21.0.9: C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot\bin (required by Steps 1, 3, 5)

**Build Tools**
- Maven Wrapper: 3.9.14 (already compatible with Java 21)
- Maven 3.9.11: C:\Users\bcaro\Downloads\apache-maven-3.9.11-bin\apache-maven-3.9.11\bin

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260623222651
- Run tests before and after the upgrade: true

## Upgrade Goals

- Java: 17 → 21

## Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------------------------------------- |
| Java | 17 | 21 | User requested latest LTS runtime |
| Spring Boot | 3.5.14 | 3.5.14 | Already compatible with Java 21 |
| Maven Wrapper | 3.9.14 | 3.9.0 | Compatible with Java 21 |
| maven-compiler-plugin | inherited | 3.11.0 recommended | Spring Boot 3.5 parent manages plugin compatibility |

## Derived Upgrades

- Java 21 requires a compatible Maven runtime; the existing Maven Wrapper 3.9.14 is already sufficient.
- No Spring Boot or dependency version upgrade is required because Spring Boot 3.5.14 supports Java 21.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| pom.xml | java.version | 17 | upgrade | 21 | Upgrade project compile/runtime target to latest LTS Java |

### Source Code Changes

| File | Location | Current | Required Change | Reason |
|------|----------|---------|----------------|--------|
| None | - | - | - | No source code changes are required for this runtime-only upgrade |

### Configuration Changes

| File | Property/Setting | Current | Required Change | Reason |
|------|------------------|---------|----------------|--------|
| None | - | - | - | No config property changes are required for Java 21 upgrade |

### CI/CD Changes

| File | Location | Current | Required Change |
|------|----------|---------|----------------|
| None | - | - | - |

### Risks & Warnings

- **Java 21 runtime changes**: Reflection, strong encapsulation, and removed JDK internals may surface at runtime. Mitigation: run full test suite on JDK 21 and inspect any failures.
- **Untracked workspace files**: `prometheus.yml` and `src/main/java/com/donaton/donaciones/producer/RabbitProducer.java` are untracked in git but do not affect the planned upgrade; do not modify them.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Verify JDK 21 availability and confirm Maven wrapper compatibility before changing the project.
  - **Changes to Make**: No code changes. Validate available JDK 21 and Maven wrapper version.
  - **Verification**: Use JDK 21 and wrapper, expected success.

- Step 2: Setup Baseline
  - **Rationale**: Establish current project health on Java 17 before the runtime upgrade.
  - **Changes to Make**: No code changes. Run baseline compile and tests on current JDK 17.
  - **Verification**: `mvnw.cmd clean compile test-compile -q && mvnw.cmd clean test -q` with JDK 17.

- Step 3: Upgrade Java runtime target to 21
  - **Rationale**: Apply the runtime upgrade with minimal changes and keep the project compatible with latest LTS.
  - **Changes to Make**: Update `pom.xml` `<java.version>` from `17` to `21`.
  - **Verification**: `mvnw.cmd clean test-compile -q` with JDK 21.

- Step 4: CVE Validation & Fix
  - **Rationale**: Scan direct dependencies for security issues after the runtime upgrade and resolve any findings.
  - **Changes to Make**: Run CVE scan, upgrade direct dependency versions if needed.
  - **Verification**: `mvnw.cmd -q dependency:list -DexcludeTransitive=true` and CVE scan results.

- Step 5: Final Validation
  - **Rationale**: Confirm the project compiles and passes all tests on Java 21.
  - **Changes to Make**: Address any test failures or build issues discovered after the upgrade.
  - **Verification**: `mvnw.cmd clean test -q` with JDK 21.
