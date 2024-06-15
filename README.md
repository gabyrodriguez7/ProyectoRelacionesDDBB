Nombre: Rodríguez Contreras Gabriela Lissette.
Entidades y Relaciones
 
1. Address (Dirección)
 
La entidad Address representa la dirección de un cliente (Customer). Tiene los siguientes atributos:

id_address: Identificador único de la dirección (clave primaria).

street: Calle de la dirección.

city: Ciudad de la dirección.

customer: Relación uno a uno con Customer. Un cliente tiene una única dirección.

Relación:

Uno a Uno con Customer: Cada dirección pertenece a un único cliente. La relación se establece a través del atributo customer en Address.

3. Customer (Cliente)
   
La entidad Customer representa un cliente que puede tener varias mascotas (Pet). Tiene los siguientes atributos:

id_customer: Identificador único del cliente (clave primaria).

name_customer: Nombre del cliente.

address: Relación uno a uno con Address. Un cliente tiene una única dirección.

pets: Relación uno a muchos con Pet. Un cliente puede tener varias mascotas.

Relaciones:

Uno a Uno con Address: Cada cliente tiene una dirección única. Esta relación se gestiona a través del atributo address en Customer.

Uno a Muchos con Pet: Un cliente puede tener varias mascotas. Esta relación se gestiona a través del atributo pets en Customer, que es una colección de objetos Pet.

5. Pet (Mascota)
   
La entidad Pet representa una mascota que pertenece a un cliente (Customer) y puede ser tratada por uno o más doctores (Doctor). Tiene los siguientes atributos:


id_pet: Identificador único de la mascota (clave primaria).

name: Nombre de la mascota.

type: Tipo de mascota (por ejemplo, perro, gato, etc.).

age: Edad de la mascota.

customer: Relación muchos a uno con Customer. Una mascota pertenece a un único cliente.

doctors: Relación muchos a muchos con Doctor. Una mascota puede ser tratada por varios doctores y un doctor puede tratar a varias mascotas.

Relaciones:

Muchos a Uno con Customer: Cada mascota pertenece a un único cliente. Esta relación se gestiona a través del atributo customer en Pet.

Muchos a Muchos con Doctor: Una mascota puede ser tratada por varios doctores. Esta relación se gestiona a través del atributo doctors en Pet, que es una colección de objetos Doctor.

4. Doctor (Doctor)

La entidad Doctor representa un profesional médico que puede tratar a varias mascotas (Pet). Tiene los siguientes atributos:

id_doctor: Identificador único del doctor (clave primaria).

name_doctor: Nombre del doctor.

description: Descripción del doctor.

Relación:

Muchos a Muchos con Pet: Un doctor puede tratar a varias mascotas y una mascota puede ser tratada por varios doctores. Esta relación se gestiona a través del atributo doctors en Pet, que es una colección de objetos Doctor.

Pruebas para Address

Obtener todas las direcciones (GET)

Método: GET

URL: http://localhost:8080/addresses

Abre Postman.

Selecciona el método GET.

Ingresa la URL http://localhost:8080/addresses.

Haz clic en "Send".

Deberías recibir una lista de todas las direcciones almacenadas en tu base de datos.

Obtener una dirección por ID (GET)

Método: GET

URL: http://localhost:8080/addresses/{id}

Reemplaza {id} con el ID de la dirección que deseas obtener.

Selecciona el método GET.

Ingresa la URL con el ID de la dirección que deseas obtener.

Haz clic en "Send".

Deberías recibir los detalles de la dirección correspondiente al ID proporcionado.

Crear una nueva dirección (POST)

Método: POST

URL: http://localhost:8080/addresses

Cuerpo (Body): Selecciona raw y luego JSON (application/json). Ingresa el siguiente JSON:

{

  "street": "Calle Principal",
  
  "city": "Quito"
  
}

Selecciona el método POST.

Ingresa la URL http://localhost:8080/addresses.

Selecciona raw y asegúrate de que el tipo sea JSON (application/json).

Ingresa el JSON con los datos de la nueva dirección como se muestra arriba.

Haz clic en "Send".

Deberías recibir los detalles de la dirección recién creada, incluido el ID asignado.

Actualizar una dirección existente (PUT)

Método: PUT

URL: http://localhost:8080/addresses/{id}

Reemplaza {id} con el ID de la dirección que deseas actualizar.

Cuerpo (Body): Selecciona raw y luego JSON (application/json). Ingresa el siguiente JSON con los datos actualizados:

{

  "street": "Avenida Nuevo Mundo",
  
  "city": "Guayaquil"
  
}

Selecciona el método PUT.

Ingresa la URL con el ID de la dirección que deseas actualizar.

Selecciona raw y asegúrate de que el tipo sea JSON (application/json).

Ingresa el JSON con los datos actualizados como se muestra arriba.

Haz clic en "Send".

Deberías recibir los detalles de la dirección actualizada.

Eliminar una dirección (DELETE)

Método: DELETE

URL: http://localhost:8080/addresses/{id}

Reemplaza {id} con el ID de la dirección que deseas eliminar.

Selecciona el método DELETE.

Ingresa la URL con el ID de la dirección que deseas eliminar.

Haz clic en "Send".

Deberías recibir una confirmación de que la dirección fue eliminada correctamente.

Pruebas para Customer, Doctor y Pet

Para las entidades Customer, Doctor y Pet, el proceso es similar al de Address. A continuación te doy un formato general que puedes aplicar:

Obtener todas las entidades (GET)

Método: GET

URL: http://localhost:8080/addresses (para Address)

URL: http://localhost:8080/customers (para Customer)

URL: http://localhost:8080/doctors (para Doctor)

URL: http://localhost:8080/pets (para Pet)

Obtener una entidad por ID (GET)

Método: GET

URL: http://localhost:8080/addresses/{id} (para Address)

URL: http://localhost:8080/customers/{id} (para Customer)

URL: http://localhost:8080/doctors/{id} (para Doctor)

URL: http://localhost:8080/pets/{id} (para Pet)

Crear una nueva entidad (POST)

Método: POST

URL: http://localhost:8080/addresses(para Address)

URL: http://localhost:8080/customers (para Customer)

URL: http://localhost:8080/doctors (para Doctor)

URL: http://localhost:8080/pets (para Pet)

Actualizar una entidad existente (PUT)

Método: PUT

URL: http://localhost:8080/addresses/{id}(para Address)

URL: http://localhost:8080/customers/{id} (para Customer)

URL: http://localhost:8080/doctors/{id} (para Doctor)

URL: http://localhost:8080/pets/{id} (para Pet)

Eliminar una entidad (DELETE)

Método: DELETE

URL: http://localhost:8080/addresses/{id}(para Address)

URL: http://localhost:8080/customers/{id} (para Customer)

URL: http://localhost:8080/doctors/{id} (para Doctor)

URL: http://localhost:8080/pets/{id} (para Pet)

JSON para Address

Crear una nueva dirección (POST)

{

  "street": "Calle Principal",
  
  "city": "Quito"
  
}

Actualizar una dirección existente (PUT)

{

  "street": "Avenida Nuevo Mundo",
  
  "city": "Guayaquil"
  
}

JSON para Customer

Crear un nuevo cliente (POST)

{

  "name_customer": "Luisa",
  
  "address": {
    "street": "Calle Principal",
    "city": "Quito"
    
  }
  
}

Actualizar un cliente existente (PUT)

{

  "name_customer": "Luisa",
  
  "address": {
    "street": "Avenida Principal",
    "city": "Guayaquil"
  }
  
}

JSON para Doctor

Crear un nuevo doctor (POST)

{

  "name_doctor": "Dr. Watson",
  
  "description": "Especialista en perros"
  
}

Actualizar un doctor existente (PUT)

{

  "name_doctor": "Dr. Rodriguez",
  
  "description": "Especialista en gatos"
  
}
JSON para Pet

Crear una nueva mascota (POST)

{

  "name": "Luna",
  
  "type": "gato",
  
  "age": 1,
  
  "customer": {
    "id_customer": 10
    
  }
  
}

Actualizar una mascota existente (PUT)

{

  "name": "Oreo",
  
  "type": "gato",
  
  "age": 2,
  
  "customer": {
    "id_customer": 2
  }
  
}
