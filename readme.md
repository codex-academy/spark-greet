# Java Spark App deployed to Heroku

App deployed at: https://spark-greet.herokuapp.com/

* http://sparkjava.com/
* http://sparkjava.com/documentation
* https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin

A Spark Java App using Handlebars.

## Deployment steps

Do this once:

* `git init`
* `git add .`
* `git commit -m "initial commit"`
* `heroku create` - you will need a heroku account.

Then deploy & redeploy using:

* `mvn clean heroku:deploy`

## Install PostgreSQL

You can install PostgreSQL on Ubuntu using these commands:

```
sudo apt-get update
sudo apt-get install postgresql postgresql-contrib
```

## Database setup

Once you have all the above installed you need to setup the database.

Create:
* a database called `greeter` 
* and username - `coder` (or matching the you using on Linux) with a password of `coder123` (or a password you choose). 

Enter the password you want the use for your PostgreSQL user when prompted after executing the `createuser` command. 

```
sudo -u postgres createdb greeter;
sudo -u postgres createuser coder -P;
```

Now run *psql* as the *postgres* user:

```
sudo -u postgres psql;
```

Grant the `coder` user access to the `greeter` database by running this command: 

```
grant all privileges on database greeter to coder;
```

Type in `\q` to exit *psql* as the *postgres* user.

Connect to your database using: `psql -d greeeter`

Execute these SQL commands to create the `person` using `\i db.sql` in `psql`. 

Or copy and paste this into `psql` and press enter

```sql

create table person(
    id serial not null primary key,
    first_name text,
    counter int
);


```

> To do this on your own project create sql file containing the table create scripts that's in your projects root folder. Run the scripts using `\i <your script file here>`

You see which tables are in the database by using this command:

```
\dt
```

You can see the columns of a database using this:

```
\d+ <table_name_here>
```

To see all the columns in the person table do this:

```
\d+ person
```

After doing the above your local app should be able run using the local instance of PostgreSQL.

## Database setup

To add a PostgreSQL database instance to Heroku for this application follow the steps below

```
heroku addons:create heroku-postgresql:hobby-dev
```

See the `DATABASE_URL` environment variable that was added to the Heroku app by typing.

```
heroku config
```

Connect to the Heroku PostgreSQL database instance using:

```
heroku pg:psql
```

Now create the `person` table in the database by running the `db.sql` script in the remote `psql` session.

```
\i db.sql
```




