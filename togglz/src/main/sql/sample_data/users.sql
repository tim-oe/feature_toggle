insert into `users`
(`username`,`password`,`enabled`)
values
('admin','$2a$10$oGKOqfl1pjexWJgQ1psp5OsOsqKjBHUrkLNyG1T9hHNSbndTZLFoi',true),
('disabled','$2a$10$cGmPGO2GLbfMjm3xmEkTeevzPuhF2eX083YeOb.c8xR2geXox8Esy',false),
('user','$2a$10$b1aWCVhHgOFV.YmDJ2Sxm.ELpCdU.1KDf5vtHIJmiREso27XA4mGO',true);;

insert into `roles`
(`users_id`,`role`)
values
((select id from users where username='admin'),'ROLE_ADMIN'),
((select id from users where username='user'),'ROLE_CUSTOMER'),
((select id from users where username='disabled'),'ROLE_CUSTOMER');;
