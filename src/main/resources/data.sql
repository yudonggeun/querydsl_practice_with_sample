call next value for team_seq;
insert into team (`id`, `name`) values (1, 'light team');
call next value for team_seq;
insert into team (`id`, `name`) values (2, 'heavy team');

call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (1, 'member1', 13, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (2, 'member2', 23, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (3, 'member3', 38, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (4, 'member4', 22, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (5, 'member5', 20, 1);

call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (6, 'member6', 4, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (7, 'member7', 24, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (8, 'member8', 50, 1);
call next value for member_seq;
insert into member (`id`, `username`, `age`, `team_id`) values (9, 'member9', 15, 1);