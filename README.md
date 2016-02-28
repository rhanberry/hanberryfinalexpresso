# hanberryfinalexpresso
This is a full stack Java app that documents ingredients for coffee drinks and tracks allergens in baked good items.

This is a maven project that uses Spring boot, AngularJS (using ui-router), and PostgreSQL.  
To initiate database, create new postgres database named finalproject. 

Populate Database: Set a login role (user role) to postgres. Using PGAdmin or psql, restore the database
you just named finalproject with the included finalprojectdump file.  If you are using PGAdmin, under
Restore Options #1 select pre-data, data, and post-data. All of the other default settings should be fine
confirm in messages window.  Once process has completed, cancel out of that and your database schema
should be populated.

   **Note: There is no file extension on the dump file, so yo will have to set your file types to all files.
   The file is of type custom in PGAdmin.

To run integration tests, please create a second database with the name finalprojecttest.
This will create an identical schema and test against that so that you don't contaminate your existing data
