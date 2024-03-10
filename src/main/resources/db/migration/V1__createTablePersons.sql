Create Table If Not Exists public.Persons(
     name Character Varying(32) Not Null Collate pg_catalog.default,
     surname Character Varying(32) Not Null Collate pg_catalog.default,
     age Integer Not Null,
     phone_number Character Varying(16) Null Collate pg_catalog.default,
     city_of_living Character Varying(64) Null Collate pg_catalog.default,
     Constraint PK_Persons Primary Key(name, surname, age)
) Tablespace pg_default;