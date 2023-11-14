# Внесение в БД Юзера и Админа
insert into users (first_name, last_name, age, email, password) values ('Admin', 'Admin', 38, 'admin@mail.ru', '$2y$10$18cXiKrZ3I.wqIh3vSxREu12cwEmxyBRhyPlHxUkuegkXt/aupDyq');
insert into users (first_name, last_name, age, email, password) values ('User', 'User', 38, 'user@mail.ru', '$2y$10$18cXiKrZ3I.wqIh3vSxREu12cwEmxyBRhyPlHxUkuegkXt/aupDyq');

# Установка ролей
insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_USER');

# Распределение ролей
insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (1, 2);
insert into users_roles (user_id, role_id) values (2, 2);