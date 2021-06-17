create table passenger
(
    id            bigserial    not null
        constraint passenger_pkey
            primary key,
    date_of_birth date         not null,
    last_name     varchar(255) not null,
    name          varchar(255) not null
);

alter table passenger
    owner to postgres;

INSERT INTO public.passenger (id, date_of_birth, last_name, name) VALUES (1, '1998-06-25', 'Muñeton', 'Juan');
INSERT INTO public.passenger (id, date_of_birth, last_name, name) VALUES (2, '1998-06-17', 'De villa', 'Pablo');
INSERT INTO public.passenger (id, date_of_birth, last_name, name) VALUES (3, '1999-06-17', 'Ricaute', 'Carlos');
INSERT INTO public.passenger (id, date_of_birth, last_name, name) VALUES (4, '2009-06-18', 'Perez', 'Veronica');