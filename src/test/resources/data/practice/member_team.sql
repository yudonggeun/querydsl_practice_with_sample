call next value for team_seq;
insert into team (`id`, `name`) values (1, 'light team');
call next value for team_seq;
insert into team (`id`, `name`) values (2, 'heavy team');

call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (1, 'member1', 13, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (2, 'member2', 23, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (3, 'memb3', 38, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (4, 'membe4', 22, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (5, 'memer5', 20, 1);

call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (6, 'bmember6', 4, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (7, 'cmember7', 24, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (8, 'tmember8', 50, 2);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (9, 'member9', 15, 2);
