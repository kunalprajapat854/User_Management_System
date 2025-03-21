show databases;
use user;
show tables;
//insert into country table
select * from country;
insert into country(country_id,country_name) values (1, "India");
insert into country(country_id,country_name) values (2, "USA");

select * from states;
insert into states (states_id, states_name, country_id) 
values(1,'AP',1);
insert into states (states_id, states_name, country_id) 
values(2,'TN',1);
insert into states (states_id, states_name, country_id) 
values(3,'Texas',2);
insert into states (states_id, states_name, country_id) 
values(4,'Alaska',2);

select * from city;
insert into city (city_id, city_name, states_id) values(1,'Tirumala',1);
insert into city (city_id, city_name, states_id) values(2,'Warangal',2);
insert into city (city_id, city_name, states_id) values(4,'Dallas',3);
insert into city (city_id, city_name, states_id) values(5,'FairBanks',4);



