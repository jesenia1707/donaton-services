# Microservicio Logística

## Descripción

Microservicio encargado de gestionar el seguimiento y distribución de las donaciones registradas en la plataforma Donatón.

Este servicio recibe eventos desde RabbitMQ cuando se crea una nueva donación y permite realizar el seguimiento del proceso logístico.

---

## Tecnologías Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* RabbitMQ
* Docker
* Kubernetes

---

## Puerto

```text
8083
```

---

## Ejecución Local

### Compilar

```bash
mvn clean install
```

### Ejecutar

```bash
mvn spring-boot:run
```

---

## Endpoints

### Obtener registros logísticos

```http
GET /api/logistica
```

### Crear registro logístico

```http
POST /api/logistica
```

### Ejemplo de respuesta

```json
[
  {
    "id": 1,
    "donacionId": 10,
    "direccionDestino": "Sede Central",
    "estado": "En Ruta",
    "fechaEntrega": "2026-06-18"
  }
]
```

---

## Persistencia

La persistencia se implementa mediante PostgreSQL utilizando Spring Data JPA.

Tabla principal:

```text
logistica
```

---

## RabbitMQ

El microservicio consume mensajes enviados desde el microservicio de Donaciones.

Flujo:

```text
Donaciones
      ↓
   RabbitMQ
      ↓
   Logística
      ↓
Seguimiento
```

---

## Docker

### Construcción de imagen

```bash
docker build -t logistica-service:latest .
```

### Ejecución

```bash
docker run -p 8083:8083 logistica-service:latest
```

---

## Kubernetes

### Deployment

```bash
kubectl apply -f logistica-deployment.yaml
```

### Service

```bash
kubectl apply -f logistica-service.yaml
```

### Verificar Pods

```bash
kubectl get pods
```

---

## Funcionalidades

* Registro de información logística.
* Seguimiento de donaciones.
* Consumo de mensajes RabbitMQ.
* Persistencia en PostgreSQL.
* Despliegue mediante Docker.
* Orquestación mediante Kubernetes.

---

## Proyecto

Donatón – Plataforma de Gestión y Coordinación de Ayuda Humanitaria.
