# Movie-Recommendation-Engine
Final project for COP4710, Data Modeling

The .py file includes the Python script used to acquire the data via the IMBD API and parse it into the tables. 

Project requirements:

Undergraduate Students

For your final project, you are going to build a movie recommendation system. The data should be downloaded from here: The top 5000 movie data from IMDB: https://www.kaggle.com/tmdb/tmdb-movie-metadata/data (Links to an external site.). This data contains information about 5000 movies from IMDB. 

Instructions for project completion

All the coding will be done in a Java environment. MySQL will only be used to store the dataset and new tables and access them for information extraction. You will give a demo of the project in class/in instrctor's office (date and location will be finalized later). You will submit EVERYTHING that the instructor needs to execute your project.

When you create the database tables with the dataset, make sure that your tables are in 1NF (see the attached video). In layman's terms, each cell in your tables will contain at most 1 data entry.
1 Keywords

To develop the recommendation engine, you should make an extensive use of the keywords that describe the films. Indeed, a basic assumption is that films described by similar keywords should have similar contents. "Keywords" is an attribute in the tmdb_5000_movies.csv file. 

Create and store a list of keywords which appear at least 5 times in the database. Do not store the keywords which appear less than 5 times in the given database.

2. Genres

The genres attribute will surely be important while building the recommendation engines since it describes the content of the film (i.e. Drama, Comedy, Action, ...). "Genres" is an attribute in the tmdb_5000_movies.csv file.

3. Recommendation Engine

3.1 Architecture of the Recommender System

In order to build the recommendation engine, you will proceed in two steps:

    determine  films with a content similar to the entry provided by the user
    select the 5 most popular films among these  films.
