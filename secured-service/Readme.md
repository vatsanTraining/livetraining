CREATE TABLE  users(  `username` varchar(50) NOT NULL,  `password` varchar(200) NOT NULL,  `enabled` tinyint(1) NOT NULL,  PRIMARY KEY (`username`)) 

CREATE TABLE  authorities (  `username` varchar(50) NOT NULL,  `authority` varchar(50) NOT NULL,  KEY `fk_authorities_users` (`username`),  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)) 


public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("india");
            System.out.println(encoded);
        encoded = encoder.encode("nepal");
          System.out.println(encoded);

}


insert into users (username, password,enabled) values ('india',,true);
insert into authorities (username, authority) values ('india', 'ROLE_USER');
insert into test.users (username, password, enabled) values ('nepal',,true);
insert into authorities (username, authority) values ('nepal', 'ROLE_ADMIN');
