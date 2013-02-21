Wyndham Jade Prospective Hire Test - Java Edition
=================================================


Project Overview
----------------

This is a web application for simple task management.  Currently, the
application simply reads a list of tasks from a relational data store and
presents the list in a simple table.


Your Tasks
----------

Add a REST web service for querying, adding, updating and removing tasks.
The service should respond to the following URLs and HTTP verbs:

*   `GET /tasks` - list all tasks; optionally accept query parameters for
    pagination and filters
*   `POST /tasks` - create a new task
*   `GET /tasks/<id>` - retrieve details of the task identified by *id*
*   `PUT /tasks/<id>` - update the existing task identified by *id*
*   `DELETE /tasks/<id>` - delete the existing task identified by *id*

The service MUST accept and return resources in JSON format.  Support for
other formats, such as XML and HTML are optional.  Design the JSON schema
you feel is appropriate given the existing data structure.

Add any necessary unit or integration tests.

You may use any IDE or text editor you are comfortable with.  You are
encouraged to add any open source third-party library (must be available on
Maven Central) that you feel makes your task easier.  You may make any
structural changes to the project that you see fit.


Evaluation Criteria
-------------------

1.  Correctness of solution

    Naturally, the project you submit must be functional.  You will also be
    evaluated on *how* your solution addresses the assigned tasks.  

2.  Platform knowledge

    Does your code demonstrate your knowledge of the capabilities of the
    Java platform and its resources?

3.  Coding style

    Is your coding style neat?  Does it fit in with the prevailing style of
    the project?  Is it idiomatic such that it will be easily understood by
    other Java developers?  Is it adequately (but not excessively)
    commented?

4.  Working with git

    Good git usage is important for collaborating with other developers.
    Make sure each change is logically distinct (i.e. don't combine
    unrelated changes into a single "mega" commit).  Make sure the commit
    message for each change is meaningful.


Getting Started
---------------

### Clone the project to your local machine

You are probably reading this on GitHub already.  If not, you can find the
project [on GitHub](https://www.github.com/wyndhamjade/interview-test-java).

To begin work on the project, start by cloning the repository to your local
machine.  Do your work locally, committing your changes to your local git
repository as you go.


### Building the project

The project includes a pom.xml file allowing it to be built by
[Maven](http://maven.apache.org).  Simply running `mvn package` will
download all dependencies and build a standard WAR file.

Additional Maven plugins have been configured for managing a database and
running the project in a servlet container.


### Managing the database

The project uses an [H2 Database](http://www.h2database.com) which is a
simple in-process file-backed data store.  This saves the trouble of
configuring a database server.

To create the project tables and populate them with some sample data, simply
run the following command:

    mvn migration:up

This will create a database file in the project root directory called
`development.h2.db` (there may be other, similarly named, supplemental
files), create the two project tables, and populate them with some sample
data.  If you ever need to reset the database to its default state, simply
delete the development.\*.db files and run mvn migration:up again.

If you require changes to the database schema, create a new database
migration file in the src/main/migrations/scripts directory.  This command
will create the appropriate file for you:

    mvn migration:new -Dmigration.description=my_new_migration

Fill out the migration file and then run it with `mvn migration:up`.

More details on the Maven database migration plugin can be found
[here](http://www.mybatis.org/maven-migration-plugin/examples.html).


### Running the application

You can run the project inside a Jetty container using this command:

    mvn jetty:run

This starts a Jetty server on your local machine listening on port 8080.  To
see the application's home page, point your browser to
`http://localhost:8080/`.  This page shows a list of tasks in the tasks
database.


Submitting Your Code For Evaluation
-----------------------------------

When you are finished and ready to submit your work, use the following
command to generate a series of patch files with all of your changes:

    git format-patch origin/master

This will create one or more numbered patch files.

Send an email with the patch files attached to the person who sent you this
test.  If you have git set up to send email, you may also use the `git
send-email` command to do this.

