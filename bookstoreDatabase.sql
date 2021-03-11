CREATE DATABASE bookstore_ct2425;

use bookstore_ct2425

create table book_ct2425(

	bookId int primary key auto_increment,
	bookName varchar(80),
	bookAuthor varchar(80),
	bookPublisher varchar(80),
	bookPrice double(15,2),
	bookDescription varchar(80)
);


create table customer_ct2425(
	custId int primary key auto_increment,
	custFName varchar(30),
	custLName varchar(30),
	custEmailId varchar(30)unique not null,
	custMobileNo varchar(10),
	custPassword varchar(30),
	custAddress varchar(225)
);

// here custEmailId is foregin key of Cart_ct2425 refer by Customer(custEmailId).
// here bookid also foregin key of Cart_ct2425 refer by Book(bookId).
create table cart_ct2425(
	cartId int primary key auto_increment,
	custEmailId varchar(30),
	bookId int,
	cartQuantity int default 1
	);
	
create table order_ct2425 (
orderId int primary key auto_increment,
custEmailId varchar(30),
orderDate datetime,
totalAmount double(15,2),
orderStatus varchar(30) default 'Processing'
);



CREATE TABLE orderdetails_ct2425 (
  orderId int,
  cartId int,
  custEmailId varchar(30),
  bookId int,
  cartQuantity int 
)

	
	
	
	
	delimiter $
	 create trigger orderbackup_ct2425
     after insert on order_ct2425
     for each row
     begin
     insert into orderdetails_ct2425 select new.orderId,cartId,custEmailId,bookId,cartQuantity 
     from cart_ct2425 where custEmailId=new.custEmailId;
     delete from cart_ct2425 where custEmailId=new.custEmailId;
     end;
     $

	
	
	
	
	
	
	
	
	
	
	