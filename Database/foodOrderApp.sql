-- DataBase creation
create database foodOrderApp;
use  foodOrderApp;
show tables;

-- Restuarant Data.
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (1,'Bangalore','Adigas');
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (2,'Hyderabad','Rotighar');
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (3,'Chennai','PunjabiRasoi');
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (4,'Bangalore','Udipi');

-- Menu data

insert into menu values (2,'Veg','dosa',20,"https://b.zmtcdn.com/data/pictures/8/18953988/2e60af34412c4752b7e42d1c44cd77e0_o2_featured_v2.jpg?output-format=webp",1,1);
insert into menu values (6,'Veg','Gobi Manchuraian',150,"https://b.zmtcdn.com/data/dish_photos/10c/f9d49f08b5fdb355b78c0f55b7dc610c.jpg",1,1);
insert into menu values (3,'Veg','Chole Bature',80,"https://b.zmtcdn.com/data/pictures/chains/4/90034/1641565584ff60da9b1c6a8d2ae0feee_o2_featured_v2.jpg",1,1);
insert into menu values (4,'Non-Veg','Chicken 65',200,"https://b.zmtcdn.com/data/dish_photos/9ac/ca8d626b55b7e06114133d7c8d0b59ac.jpg?output-format=webp",1,1);
insert into menu values (5,'Non-Veg','Chicken Popcorn',180,"https://pinchofflavours.com/wp-content/uploads/2020/09/KFC-Chicken-Popcorn-3-e1598973638731.jpg",1,1);
insert into menu values (1,'Non-Veg','Chicken Biryani',250,"https://b.zmtcdn.com/data/pictures/chains/0/93970/ff2a033de7e1e643935b8899a1e2b42e_o2_featured_v2.jpg?output-format=webp",1,1);

insert into menu values (7,'Veg','Roti',20,"https://b.zmtcdn.com/data/pictures/1/56791/0cdce63fc9633eb489b4568c6a7e1917_o2_featured_v2.jpg",1,2);
insert into menu values (8,'Veg','Dal Makahni',150,"https://b.zmtcdn.com/data/dish_photos/1f4/4c841fc63596667ee9166ab67796c1f4.jpg",1,2);
insert into menu values (9,'Veg','Aloo Paratha',100,"https://b.zmtcdn.com/data/pictures/9/18601019/5a5edb2d888c88d873c49c994f6eb9b4_o2_featured_v2.jpg",1,2);
insert into menu values (10,'Non-Veg','Chicken Curry',200,"https://b.zmtcdn.com/data/dish_photos/5b2/87b51dbe8d5ea0db8b9102b80cf235b2.jpg?output-format=webp",1,2);
insert into menu values (11,'Non-Veg','Egg Biryani',180,"https://b.zmtcdn.com/data/dish_photos/f3a/a01d4321d86a35e39c160b6285ec0f3a.jpg",1,2);
insert into menu values (12,'Non-Veg','Chicken Shawarma',100,"https://b.zmtcdn.com/data/dish_photos/4b3/7d427c10551089d988c84e8a843694b3.jpg?output-format=webp",1,2);

 insert into menu values (13,'Veg','Dosa',50,"https://b.zmtcdn.com/data/pictures/5/19557715/4bcd527b7ea78f31092febd591cb8f9c_o2_featured_v2.jpg",1,3);
 insert into menu values (14,'Veg','Poha',110,"https://b.zmtcdn.com/data/pictures/5/19452965/e4f6505b77111a2a461626ffc29550b3_o2_featured_v2.jpeg?output-format=webp",1,3);
 insert into menu values (15,'Veg','Carrot Rice',100,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0544Loq3O5I9LoO0LbgvRrFQHPch5ZHCImw&usqp=CAU",1,3);
 insert into menu values (16,'Non-Veg','Fish Fry',20,"https://b.zmtcdn.com/data/pictures/7/50567/71f06fe4ae7acba6bc04c731342a50d6_o2_featured_v2.jpg",1,3);
 insert into menu values (17,'Non-Veg','Chicken Roll',170,"https://b.zmtcdn.com/data/dish_photos/363/66e764e26dd78aa8f1ea52bee8abc363.jpg?output-format=webp",1,3);
 insert into menu values (18,'Non-Veg','Boiled Egg',30,"https://b.zmtcdn.com/data/dish_photos/639/ec4e7f2fa70a24c366cec46a1ae2d639.jpg",1,3);
 
 insert into menu values (19,'Veg','Idly Vada',75,"https://b.zmtcdn.com/data/dish_photos/e8e/efc940870ffbcbc0d73168bad92cae8e.jpg?output-format=webp",1,4);
 insert into menu values (20,'Veg','French Fries',140,"https://b.zmtcdn.com/data/dish_photos/e46/a24176740f3d78efc03a0892d0d82e46.jpg?output-format=webp",1,4);
 insert into menu values (21,'Veg','Panner Birayani',200,"https://www.vidhyashomecooking.com/wp-content/uploads/2019/04/PaneerMakhaniBiryaniRecipe-480x270.jpg",1,4);
 insert into menu values (22,'Non-Veg','Egg Birayani',190,"https://b.zmtcdn.com/data/dish_photos/c2a/197cc7a23f09f28440049de835d26c2a.jpg",1,4);
 insert into menu values (23,'Non-Veg','Chicken Lollipop',250,"https://i1.wp.com/www.angsarap.net/wp-content/uploads/2015/03/Chicken-Lollipops-Wide.jpg?fit=1080%2C720&ssl=1",1,4);
 insert into menu values (24,'Non-Veg','Egg Burji',80,"https://c.ndtvimg.com/2019-01/js2vgrc8_egg-bhurji-for-weight-loss_625x300_03_January_19.jpg",1,4);
 
 insert into state values(1,'Andhra Pradesh');
 insert into state values(2,'Telangana');
 insert into state values(3,'karnataka');
 insert into state values(4,'Uttar Pradesh');
 insert into state values(5,'Madya Pradesh');

 
 select * from menu;
select * from cart;
 select * from customer;
 select * from order_details;
 select * from address;
  select * from state;

show tables;
 