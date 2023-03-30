# __Product and Reviews__
![Java](label.png)

## __Описание__
Консольная версия работы с обьектами из баззы данных.

### __Функционал__
[1]:(https://www.postgresql.org/)

- добавление продукта в [БД][1];
- удаление продукта из [БД][1];
- добавление в [БД][1] отзыва на продукт;
- удаление из [БД][1] отзыва на продукт;
- просмотр всех продуктов, сохраненных [БД][1];
- просмотр продукта и всех отзывов на него;

#### Интерфейсы 
- [InputOutput](https://github.com/Alexey7721/hibernate-spring-postgresql/blob/master/src/main/java/com/shatrov/interfaces/InputOutput.java)
- [OpeningClosingSessions](https://github.com/Alexey7721/hibernate-spring-postgresql/blob/master/src/main/java/com/shatrov/interfaces/OpeningClosingSessions.java)
- [ProgramFunctionality](https://github.com/Alexey7721/hibernate-spring-postgresql/blob/master/src/main/java/com/shatrov/interfaces/ProgramFunctionality.java)
<br>
<br>


## __Языки и инструменты__

[![IntelliJ IDEA](icons/intellij-idea-48.png)](https://www.jetbrains.com/idea/)
[![Java](icons/java-coffee-cup-48.png)](https://www.java.com/ru/)
[![PostgreSQL](icons/pgSQL.png)](https://www.postgresql.org/)
[![Spring](icons/spring-48.png)](https://spring.io/)
[![XML](icons/xml-48.png)](https://www.xml.com/)
[![Hibenate](icons/hibernate-1.png)](https://hibernate.org/)
[![Visual studio code](icons/visual-studio-code-2019-48.png)](https://code.visualstudio.com/)
<br>
<br>

## __Установка и настойка__
### Для запуска данного кода скачатйте и установите:
- [IntelliJ IDEA](https://www.jetbrains.com/idea/);
- [PostgreSQL](https://www.postgresql.org/);
<br>
###  Скрипт PostgreSQL для создания таблиц
<br>

```
create table directors(
    id serial primary key,
    name varchar(45),
    description text,
    price INTEGER
);

create table reviews(
    id serial primary key,
    number integer,
    description text,
    stars INTEGER,
    product_id integer references products(id)
);
```
### В [hibernate.cfg.xml](https://github.com/Alexey7721/hibernate-spring-postgresql/blob/master/src/main/resources/hibernate.cfg.xml) укажите название, имя пользователя и пароль базы данных.
```xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="connection.url">jdbc:postgresql://localhost:5432/НАЗВАНИЕ БД?useSSL=false&amp;serverTimezone=UTC</property>
        <property name="connection.username">ИМЯ ПОЛЬЗОВАТЕЛЯ</property>
        <property name="connection.password">ПАРОЛЬ</property>

        <property name="current_session_context_class">thread</property>
        <property name="dialect">org.hibernate.dialect.PostgreSQL9Dialect</property>
        <property name="show_sql">true</property>

    </session-factory>
</hibernate-configuration>
```


