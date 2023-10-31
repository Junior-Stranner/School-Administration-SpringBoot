create table usuarios(
 id text primary key unique not null,
 login text not null unique,
 password text not null,
 role text not null
);