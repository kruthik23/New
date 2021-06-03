 desc MusicFiles;
+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| Song_ID       | int(10)      | NO   | PRI | NULL    | auto_increment |
| Song_Title    | varchar(50)  | YES  |     | NULL    |                |
| Artist_Name   | varchar(50)  | YES  |     | NULL    |                |
| Album_Name    | varchar(50)  | YES  |     | NULL    |                |
| Song_Location | varchar(50)  | YES  |     | NULL    |                |
| Description   | varchar(250) | YES  |     | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+
6 rows in set (0.00 sec)



select * from MusicFiles;
+---------+----------------------+---------------+------------+----------------------+-------------------------------+
| Song_ID | Song_Title           | Artist_Name   | Album_Name | Song_Location        | Description                   |
+---------+----------------------+---------------+------------+----------------------+-------------------------------+
|       1 | allah waariyan       | Shaqfwat      | yaariyan   | /home/abhi/Documents | allahawaariyan description    |
|       2 | dheera dheera        | ravibasur     | kgf        | /home/abhi/Documents | dheeradheera description      |
|       3 | pataki               | vijay prakash | kotigobba3 | /home/abhi/Documents | pataaaaaakiporiyo description |
|       4 | singham title        | sidram        | singham    | /home/abhi/Documents | singham description           |
|       5 | ba baro pailwantitle | shankar       | pailwan    | /home/abhi/Documents | barobaro description          |
+---------+----------------------+---------------+------------+----------------------+-------------------------------+
5 rows in set (0.00 sec)
