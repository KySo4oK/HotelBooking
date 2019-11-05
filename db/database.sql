CREATE table users(
    user_id  serial Primary KEY,
    password VARCHAR (50) NOT NULL,
    login varchar (50) unique not null
);
CREATE table additional_options(
  option_id serial PRIMARY KEY ,
  name varchar (50) unique not null ,
  price serial not null
);
create table categories(
  categories_id serial primary key ,
  name varchar (50) unique not null
);
create table rooms(
    number serial primary key,
    category varchar(50) references categories(name) not null,
    price serial not null
);
create table orders(
    order_id serial primary key,
    room serial references rooms(number),
    user_id serial references users(user_id),
    category serial references categories(categories_id),
    additional_options serial references additional_options(option_id),
    startDate varchar(50) not null,
    endDate varchar(50) not null,
    days serial not null ,
    totalPrice serial not null
);
create table hotel(
    booking_id serial primary key,
    bookings serial references orders(order_id)
);
ALTER TABLE additional_options ALTER COLUMN price TYPE int;
ALTER TABLE rooms ALTER COLUMN price TYPE int;
ALTER TABLE orders ALTER COLUMN order_id TYPE int;
ALTER TABLE orders ALTER COLUMN user_id TYPE int;
ALTER TABLE orders ALTER COLUMN category TYPE int;
ALTER TABLE orders ALTER COLUMN additional_options TYPE int;
ALTER TABLE orders ALTER COLUMN days TYPE int;
ALTER TABLE orders ALTER COLUMN totalPrice TYPE int;
ALTER TABLE rooms DROP COLUMN category;
ALTER TABLE rooms ADD COLUMN category int references categories(categories_id);
ALTER TABLE orders
    ALTER endDate DROP DEFAULT
    ,ALTER endDate type timestamp USING endDate::timestamp
    ,ALTER endDate SET DEFAULT '1970-01-01 01:00:00'::timestamp;
ALTER TABLE orders
    ALTER startDate DROP DEFAULT
    ,ALTER startDate type timestamp USING startDate::timestamp
    ,ALTER startDate SET DEFAULT '1970-01-01 01:00:00'::timestamp;
create table orderAdditionalOptions(
    order_id int references orders(order_id),
    additionalOptions_id int references additional_options(option_id),
    constraint order_option_id primary key(order_id,additionalOptions_id)
);
ALTER TABLE orders
    DROP COLUMN room,
    add column room_id int references rooms(number),
    drop column additional_options;
drop table hotel;
ALTER table users add column order_id int references orders(order_id);
ALTER table rooms add column order_id int references orders(order_id);
