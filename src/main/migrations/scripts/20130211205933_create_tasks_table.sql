--// create_tasks_table
-- Migration SQL that makes the change goes here.
create table tasks (
    id identity primary key,
    description text not null,
    assigned_to bigint,
    due timestamp,
    completed_at timestamp,
    created_at timestamp default current_timestamp not null,
    foreign key (assigned_to) references assignees
);

insert into tasks (description, assigned_to, due)
values ('Implement REST service for task list.', 1, timestamp '2013-09-01 17:00:00');

insert into tasks (description, assigned_to, due, completed_at)
values ('Design GUI for task list signup form.', 2, timestamp '2013-09-02 12:00:00', timestamp '2013-08-29 13:42:22');

insert into tasks (description, assigned_to, due)
values ('Find first customer for task list app.', 3, timestamp '2013-10-01 08:00:00');

insert into tasks (description, assigned_to, due)
values ('Fix all bugs in task list app.', null, null);

insert into tasks (description, assigned_to, due)
values ('Add email reminds to task list app.', null, null);

--//@UNDO
-- SQL to undo the change goes here.
drop table tasks;
