insert into users (username, password) values ('user1', 'pass1');
insert into users (username, password) values ('user2', 'pass2');

insert into authorities (username, authority)
    values ('user1', 'ROLE_USER');
insert into authorities (username, authority)
    values ('user2', 'ROLE_USER');

commit;

--delete from Taco_Order_Tacos;
--delete from Taco_Ingredients;
--delete from Taco;
--delete from Taco_Order;
--
--delete from Ingredient;
--insert into Ingredient (id, name, type)
--                values ('FLTO', 'Flour Tortilla', 'WRAP');
--insert into Ingredient (id, name, type)
--                values ('COTO', 'Corn Tortilla', 'WRAP');
--insert into Ingredient (id, name, type)
--                values ('GRBF', 'Ground Beef', 'PROTEIN');
--insert into Ingredient (id, name, type)
--                values ('CARN', 'Carnitas', 'PROTEIN');
--insert into Ingredient (id, name, type)
--                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
--insert into Ingredient (id, name, type)
--                values ('LETC', 'Lettuce', 'VEGGIES');
--insert into Ingredient (id, name, type)
--                values ('CHED', 'Cheddar', 'CHEESE');
--insert into Ingredient (id, name, type)
--                values ('JACK', 'Monterrey Jack', 'CHEESE');
--insert into Ingredient (id, name, type)
--                values ('SLSA', 'Salsa', 'SAUCE');
--insert into Ingredient (id, name, type)
--                values ('SRCR', 'Sour Cream', 'SAUCE');