use master
go

create database[asmjav4]
go
use asmjav4
go

create table[user] (
	id           int primary  key identity,
	username     varchar(50)  unique not null,
	[password]   varchar(50)  not null,
	email        varchar(50)  unique not null,
	isAdmin      bit          not null default 0,
	isActive     bit          not null default 1
)
go

create table video (
	id           int  primary  key identity,
	title        nvarchar(255) not null,
	href         varchar(50)   unique not null,
	poster       varchar(255)  null,
	[views]      int           not null default 0,
	shares       int           not null default 0,
	[description]nvarchar(400) not null,
	isActive     bit           not null default 1
)
go
create table history(
	id           int  primary  key identity,
	userId       int  foreign key references [user](id),
	videoId      int  foreign key references video(id),
	viewDate     datetime not null default getDate(),
	isLiked      bit  not null default 0,
	likeDate     datetime null
)
go

insert into [user] (username, [password], email, isAdmin) values
('admin','123','admin@gmail.com',1),
('thanh','123','thanh@gmail.com',0)
go
--insert into video (title,href,poster,[views],shares,[description],isActive) values
--('')
insert into video (title,href,[description]) values
('Wednesday','Di310WS8zLk','Watch the official teaser for WEDNESDAY, an upcoming Netflix series from the imagination of Tim Burton. WEDNESDAY -- starring Jenna Ortega in the title role, alongside Catherine Zeta-Jones, Luis Guzman, Gwendoline Christie, Christina Ricci and more -- is a sleuthing, supernaturally infused mystery charting Wednesday Addams years as a student at Nevermore Academy. Snap snap.'),
('The Boys','elTgqUW-NYE','The Boys is an irreverent take on what happens when superheroes, who are as popular as celebrities, as influential as politicians and as revered as Gods, abuse their superpowers rather than use them for good. Its the powerless against the super powerful as The Boys embark on a heroic quest to expose the truth about The Seven, and their formidable Vought backing.'),
('What If...?','x9D0uUKJ5KI','Enter the multiverse of unlimited possibilities. Marvel Studios first animated series, What If...?, with new episodes Wednesdays on Disney+.What If… ? features fan-favorite characters, including Peggy Carter, TChalla, Doctor Strange, Killmonger, Thor and more. The new series, directed by Bryan Andrews with AC Bradley as head writer, features signature MCU action with a curious twist.'),
('Oppenheimer','uYPbbksJxIg','Written and directed by Christopher Nolan, Oppenheimer is an IMAX®-shot epic thriller that thrusts audiences into the pulse-pounding paradox of the enigmatic man who must risk destroying the world in order to save it.'),
('Barbie','pBk4NYhWNMM','To live in Barbie Land is to be a perfect being in a perfect place.  Unless you have a full-on existential crisis.  Or you’re a Ken.'),
('The Marvels','wS_qbDztgVY','This fall, The Marvels take flight.'),
('Blue Beetle','vS3_72Gb-bI','He’s A Superhero, Whether He Likes It Or Not #BlueBeetle - Only in Theaters August 18'),
('EXPEND4BLES (2023)','DhlaBO-SwVE','EXPEND4BLES – Only In Theaters September 22. Starring Jason Statham, Curtis “50 Cent” Jackson, Megan Fox, Dolph Lundgren, Tony Jaa, Iko Uwais, Randy Couture, Jacob Scipio, Levy Tran, with Andy Garcia, and Sylvester Stallone.'),
('SAW X (2023)','t3PzUo4P21c','Saw X - Watch the trailer now! Starring Tobin Bell,  Synnøve Macody Lund, Steven Brand, Michael Beach, and Renata Vaca.'),
('WONKA','otNh9bTjXWg','Based on the extraordinary character at the center of Charlie and the Chocolate Factory, Roald Dahl’s most iconic children’s book and one of the best-selling children’s books of all time, “Wonka” tells the wondrous story of how the world’s greatest inventor, magician and chocolate-maker became the beloved Willy Wonka we know today.')
go
insert into history (userId,videoId,isLiked,likeDate) values
(2, 1, 1, GETDATE()),
(2, 3, 0, NULL)
go

select * from [user]
go
select * from video
go
select * from history
go

-- store procedure
alter proc sp_selectUsersLikedVideoByVideoHref(@videoHref varchar(50))
as begin
	select u.id, u.username, u.[password], u.email, u.isAdmin, u.isActive 
	from [user] u inner join history h on u.id = h.userId
				  inner join video v on h.videoId = v.id
	where v.href = @videoHref and u.isActive = 1 and v.isActive = 1 and h.isLiked = 1
end

exec sp_selectUsersLikedVideoByVideoHref @videoHref = 'Di310WS8zLk'