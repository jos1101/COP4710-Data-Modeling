"""
James Smith
Project 1
Data Modeling
Spring 2019

A simple script parsing the data for our recommendation engine from a CSV file
"""

import pandas
import json
import csv

# Load the movie info
file = r"tmdb_5000_movies.csv"
imbd_movie_info = pandas.read_csv(file)
# Reformat the JSON columns
imbd_movie_info["genres"] = imbd_movie_info["genres"].apply(json.loads)
imbd_movie_info["keywords"] = imbd_movie_info["keywords"].apply(json.loads)
imbd_movie_info["production_companies"] = imbd_movie_info["production_companies"].apply(json.loads)
imbd_movie_info["production_countries"] = imbd_movie_info["production_countries"].apply(json.loads)
imbd_movie_info["spoken_languages"] = imbd_movie_info["spoken_languages"].apply(json.loads)

# Load the information needed into lists to be converted to a new, parsed CSV to be used by the engine
# All of these may not be used by the engine, but they are what I think may be necessary.
movie_IDs = []
movie_names = []
keyword_IDs = []
keyword_names = []
genre_IDs = []
genre_names = []
popularity = []
rating = []

for row in imbd_movie_info["id"]:
    movie_IDs.append(row)

for row in imbd_movie_info["original_title"]:
    movie_names.append(row)

for row in imbd_movie_info["keywords"]:
    for genres in row:
        keyword_IDs.append(genres["id"])
        keyword_names.append(genres["name"])

for row in imbd_movie_info["genres"]:
    for genres in row:
        genre_IDs.append(genres["id"])
        genre_names.append(genres["name"])


for row in imbd_movie_info["popularity"]:
    popularity.append(row)

for row in imbd_movie_info["vote_average"]:
    rating.append(row)

# Create a header list

header = ["movie_IDs", "movie_names", "keyword_IDs", "keyword_names", "genre_IDs", "genre_names","popularity",
          "ratings"]

# Create a list of all the lists

all_lists = [movie_IDs, movie_names, keyword_IDs, keyword_names, genre_IDs, genre_names, popularity, rating]

# Create new csv, and load the data

with open('movies.csv', 'w', encoding="utf-8") as movie_file:
    out = csv.writer(movie_file, delimiter =',', lineterminator='\n')
    out.writerow(header)
    out.writerows(zip(*all_lists))

