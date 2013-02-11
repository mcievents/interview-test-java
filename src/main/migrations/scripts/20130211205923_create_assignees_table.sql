--// create_assignees_table
-- Migration SQL that makes the change goes here.
create table assignees (
    id identity primary key,
    name text not null,
    email text not null,
    created_at timestamp default current_timestamp not null
);

insert into assignees (name, email) values ('John Smith', 'jsmith@gmail.com');
insert into assignees (name, email) values ('Jane Doe', 'jdoe@gmail.com');
insert into assignees (name, email) values ('Steve Jones', 'sjones@gmail.com');

--//@UNDO
-- SQL to undo the change goes here.
drop table assignees;
