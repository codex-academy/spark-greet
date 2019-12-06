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

