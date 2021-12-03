### RA-2

**Objetivo**

- Desarrolla aplicaciones persistiendo la información en una base de datos.

**Criterios de evaluación**

- [x] El alumno conoce las características de Room y sus conectores con Coroutines.
- [x] El alumno sabe consultar la base de datos creada a través de App Inspection.
- [x] El alumno sabe cuando almacenar información en un fichero, en SharedPreferences o base de
  datos.
- [x] El alumno sabe crear una base de datos (Room) usando el patrón **Singleton**.
- [x] El alumno sabe definir la estructura de una base de datos con Room: Dao, Entities, Relaciones.
- [x] El alumno sabe desarrollar un DbLocalSource que gestione la información en Room: CRUD.
- [x] El alumno sabe definir los Entities para cada una de las relaciones: 1:1, 1:N y N:M.
- [x] El alumno sabe definir consultas personalizadas a través de DAO.
- [x] El alumno sabe gestionar transacciones correctamente.
- [ ] El alumno sabe actualizar/migrar una base de datos.

### RA-3

**Objetivo**

- Desarrolla aplicaciones usando Room: persistiendo y recuperando la información.

**Criterios de evaluación**

- [x] El alumno sabe incorporar ROOM al proyecto.
- [x] El alumno sabe personalizar ROOM según las necesidades del proyecto: nombre de base de datos,
  versión, nombre de los campos, claves primarias, etc.
- [x] El alumno sabe crear y organizar el código para mappear modelos a entidades y viceversa.
- [x] El alumno sabe persistir información a través de DAO.
- [x] El alumno sabe modificar información a través de DAO.
- [x] El alumno sabe consultar/recuperar información a través de DAO.
- [x] El alumno sabe personalizar una función DAO con una consulta SQL.
- [x] El alumno sabe gestionar transacciones con la anotación @Transaction en los DAO.

### RA-4

**Objetivo**

- Desarrolla aplicaciones usando Room utilizando mecanismos de abstracción para desacoplar el código
  de Room en la capa de datos.

**Criterios de evaluación**

- [ ] El alumno sabe identificar las ventajas de usar Room con respecto a otros almacenamientos.
- [x] El alumno sabe establecer los mecanismos para usar una fuente de datos con Room (
  DbLocalSource) que permita abstraerla del repository.
- [x] El alumno sabe persistir modelos simples de dominio en Room.
- [] El alumno sabe persistir modelos relacionados de dominio en Room.
- [x] El alumno sabe modificar modelos de dominio y actualizarlos en Room.
- [x] El alumno sabe recuperar modelos de dominio a través de Room.
- [x] El alumno sabe gestionar las transacciones y responder ante un fallo.
- [x] El alumno sabe probar una aplicación con la capa de presentation, domain y data (repository y
  localsources).
- [x] El alumno sabe documentar una **Pull Request** con el código realizado.