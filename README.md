Проект "RESTful User Management"

Этот проект представляет собой пример реализации системы управления пользователями с использованием технологий Java, Spring Boot, Hibernate и MySQL. Основной архитектурный стиль — REST, а данные передаются в формате JSON.

Требования

Для успешного запуска проекта у вас должны быть установлены следующие компоненты:

- Java 17+
- Log4j2 как система логирования
- Spring Boot 3
- Hibernate 6
- MySQL 8


Запуск проекта

1. Склонируйте репозиторий на свой локальный компьютер:

git clone https://github.com/ProkopovichA/testTaskBootcamp.git

2. Настройте базу данных MySQL:

- Создайте новую базу данных с именем "users".
- В файле "application.properties" (src/main/resources/application.properties) укажите настройки базы данных, такие как URL, имя пользователя и пароль:

spring.datasource.url=jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Minsk&useSSL=false

spring.datasource.username=root

spring.datasource.password=Root_123

3. Запустите приложение:

Приложение будет доступно по адресу http://localhost:8080.

Endpoint для добавления пользователя

URL: POST /api/users

Пример запроса:

{

    "name": "Emma",
    
    "family": "Wilson",
    
    "surname": "Miller",
    
    "email": "emma.miller@example.com",
    
    "userRole": "CUSTOMER_USER"
    
}

Пример успешного ответа:
"User successfully created"

Endpoint для получения всех пользователей

URL: GET /api/users

Пример ответа:

[

    {
    
        "id": 11,
        
        "name": "John",
        
        "family": "Black",
        
        "surname": "Jackson",
        
        "email": "Black.jackson@example.com",
        
        "userRole": "SECURE_API_USER"
        
    },
    
    {
    
        "id": 3,
        
        "name": "Emily",
        
        "family": "Johnson",
        
        "surname": "Smith",
        
        "email": "emily.smith@example.com",
        
        "userRole": "SALE_USER"
        
    },
    
    {
    
        "id": 6,
        
        "name": "Emma",
        
        "family": "Wilson",
        
        "surname": "Miller",
        
        "email": "emma.miller@example.com",
        
        "userRole": "CUSTOMER_USER"
        
    },
    
    {
    
        "id": 9,
        
        "name": "James",
        
        "family": "Jackson",
        
        "surname": "Thomas",
        
        "email": "james.thomas@example.com",
        
        "userRole": "SECURE_API_USER"
        
    }
    
]

Endpoint для постраничного вывода записей по 10 пользователей

URL: GET /api/users/paged?page=0&size=10 - вернет первые 10 записей.

URL: GET /api/users/paged?page=1&size=10 - вернет следующие 10 записей.

Обратите внимание, что для использования параметров page и size в URL, вы можете воспользоваться стандартным способом: ?page=0&size=10.

Описание ролей

- Administrator: Администратор системы с полными правами.
- Sale User: Пользователь с правами для управления продажами.
- Customer User: Пользователь с правами для управления клиентами.
- Secure API User: Пользователь с правами доступа к безопасным API.

