package com.company;

import java.io.*;
import java.sql.*;
import java.util.*;


public class n01400606_Project {

    private static ArrayList<Movie> movies = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    class SomeSort implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {
            return b.score - a.score;
        }
    }

    static class Movie {
        int movie_id;
        String name;
        double popularity;
        int vote;
        int score;
        ArrayList<Integer> genre_ids = new ArrayList<>();
        ArrayList<Integer> keyword_ids = new ArrayList<>();
        ArrayList<Integer> actor_ids = new ArrayList<>();
        ArrayList<Integer> crew_ids = new ArrayList<>();

        public void incrementScore() {
            this.score++;
        }

        public int getScore() {
            return this.score;
        }
    }

    private static void readStarred_in(Connection con) {
        String line;
        String sql;
        int movie_id;
        int actor_id;

        try (BufferedReader br = new BufferedReader(new FileReader("starred_in.csv"))) {
            sql = "INSERT INTO starred_in VALUES(?,?)";
            int i = 0;
            PreparedStatement pst = con.prepareStatement(sql);
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] temp = line.split(",");
                movie_id = Integer.parseInt(temp[0]);
                actor_id = Integer.parseInt(temp[1]);
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, movie_id);
                pst.setInt(2, actor_id);
                pst.executeUpdate();

            }
            con.commit();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readActors(Connection con) {
        String line;
        String sql;

        try (BufferedReader br = new BufferedReader(new FileReader("actors.csv"))) {
            sql = "INSERT INTO actors VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] temp = line.split(",");
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, Integer.parseInt(temp[0]));
                pst.setString(2, temp[1].replaceAll("^\"|\"$", ""));
                pst.executeUpdate();

            }
            con.commit();
            pst.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void readDirectors(Connection con) {
        String line;
        String sql;

        try (BufferedReader br = new BufferedReader(new FileReader("directors.csv"))) {
            sql = "INSERT INTO directors VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (i == 0) {
                    i++;
                    continue;
                }
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, Integer.parseInt(temp[0]));
                pst.setInt(2, Integer.parseInt(temp[1]));
                pst.setString(3, temp[2]);
                pst.executeUpdate();
            }
            con.commit();
            pst.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }


    private static void readGenre_Connect(Connection con) {
        String line;
        String sql;

        try (BufferedReader br = new BufferedReader(new FileReader("has_genres.csv"))) {
            sql = "INSERT INTO has_genres VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] temp = line.split(",");
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, Integer.parseInt(temp[0]));
                pst.setInt(2, Integer.parseInt(temp[1]));
                pst.executeUpdate();
            }
            con.commit();
            pst.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void readGenres(Connection con) {
        String line = "";
        String sql = "";

        try (BufferedReader br = new BufferedReader(new FileReader("genres.csv"))) {
            sql = "INSERT INTO genres VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] temp = line.split(",");
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, Integer.parseInt(temp[0]));
                pst.setString(2, temp[1]);
                pst.executeUpdate();

            }
            con.commit();
            pst.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void readKeywords_in(Connection con) {
        String line = "";
        String sql = "";

        try (BufferedReader br = new BufferedReader(new FileReader("kewords_in.csv"))) {
            sql = "INSERT INTO keywords_in VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] temp = line.split(",");
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, Integer.parseInt(temp[0]));
                pst.setInt(2, Integer.parseInt(temp[1]));
                pst.executeUpdate();

            }
            con.commit();
            pst.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void readKeywords(Connection con) {
        String line = "";
        String sql = "";

        try (BufferedReader br = new BufferedReader(new FileReader("keywords.csv"))) {
            sql = "INSERT INTO keywords VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] temp = line.split(",");
                con.prepareStatement(sql);
                pst.clearParameters();
                pst.setInt(1, Integer.parseInt(temp[0]));
                pst.setString(2, temp[1]);
                pst.executeUpdate();

            }
            con.commit();
            pst.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }


    private static void readMovies(Connection con) {
        String line = "";
        String sql = "";

        try (BufferedReader br = new BufferedReader(new FileReader("movies.csv"))) {
            sql = "INSERT INTO movies VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                con.prepareStatement(sql);
                pst.clearParameters();
                if (temp.length == 4) {
                    pst.setInt(1, Integer.parseInt(temp[0]));
                    pst.setString(2, temp[1].replaceAll("^\"|\"$", ""));
                    pst.setDouble(3, Double.parseDouble(temp[2]));
                    pst.setInt(4, Integer.parseInt(temp[3]));
                } else if (temp.length == 5) {
                    pst.setInt(1, Integer.parseInt(temp[0]));
                    pst.setString(2, temp[1].replaceAll("^\"|\"$", "") + temp[2].replaceAll("^\"|\"$", ""));
                    pst.setDouble(3, Double.parseDouble(temp[3]));
                    pst.setInt(4, Integer.parseInt(temp[4]));
                } else if (temp.length == 6) {
                    pst.setInt(1, Integer.parseInt(temp[0]));
                    pst.setString(2, temp[1].replaceAll("^\"|\"$", "") + temp[2].replaceAll("^\"|\"$", "") + temp[3].replaceAll("^\"|\"$", ""));
                    pst.setDouble(3, Double.parseDouble(temp[4]));
                    pst.setInt(4, Integer.parseInt(temp[5]));
                } else if (temp.length == 7) {
                    pst.setInt(1, Integer.parseInt(temp[0]));
                    pst.setString(2, temp[1].replaceAll("^\"|\"$", "") + temp[2].replaceAll("^\"|\"$", "") + temp[3].replaceAll("^\"|\"$", "") + temp[4].replaceAll("^\"|\"$", ""));
                    pst.setDouble(3, Double.parseDouble(temp[5]));
                    pst.setInt(4, Integer.parseInt(temp[6]));

                }
                pst.executeUpdate();

            }
            con.commit();
            pst.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static Boolean isInt(String x) {
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static void fillMovies(Connection con) throws SQLException{
        PreparedStatement st1 = con.prepareStatement("SELECT * FROM movies");
        PreparedStatement st2;
        ResultSet output = st1.executeQuery();
        ResultSet outputTwo;
        while (output.next()) {
            Movie movie = new Movie();
            movie.movie_id = output.getInt("movie_id");
            movie.name = output.getString("name");
            movie.popularity = output.getDouble("popularity");
            movie.vote = output.getInt("vote");
            st2 = con.prepareStatement("SELECT genre_id FROM has_genres G WHERE G.movie_id = " + movie.movie_id);
            outputTwo = st2.executeQuery();
            while (outputTwo.next()) {
                movie.genre_ids.add(outputTwo.getInt("genre_id"));
            }
            st2 = con.prepareStatement("SELECT keyword_id FROM keywords_in G WHERE G.movie_id = " + movie.movie_id);
            outputTwo = st2.executeQuery();
            while (outputTwo.next()) {
                movie.keyword_ids.add(outputTwo.getInt("keyword_id"));
            }
            st2 = con.prepareStatement("SELECT actor_id FROM starred_in G WHERE G.movie_id = " + movie.movie_id);
            outputTwo = st2.executeQuery();
            while (outputTwo.next()) {
                movie.actor_ids.add(outputTwo.getInt("actor_id"));

            }
            st2 = con.prepareStatement("SELECT director_id FROM directors G WHERE G.movie_id = " + movie.movie_id);
            outputTwo = st2.executeQuery();
            while (outputTwo.next()) {
                movie.crew_ids.add(outputTwo.getInt("director_id"));
            }
            movies.add(movie);
        }
    }

    private static void recommendationEngine(Connection con) throws SQLException{
        PreparedStatement st = con.prepareStatement("SELECT * FROM movies");
        Movie currentMovie = null;
        String userChoice;
        System.out.println("Welcome to my movie recommendation engine!");
        while (true) {
            System.out.println("Enter a movie title to receive a list of recommendations, or 0 to exit: ");
             userChoice = input.nextLine();
            if (userChoice.equals("0")) {
                st.executeUpdate("DROP DATABASE Movie_DB");
                System.out.println("Goodbye!");
                break;
            } else {
                boolean movieFound = false;
                for (Movie movie : movies) {
                    if (movie.name.equals(userChoice)) {
                        currentMovie = movie;
                        movieFound = true;
                        break;
                    }
                }
                if (movieFound) {
                    for (Movie movie : movies) {
                        if (movie.name.equals(currentMovie.name)) {
                            continue;
                        } else {
                            for (int genreOne : currentMovie.genre_ids) {
                                for (int genreTwo : movie.genre_ids) {
                                    if (genreOne == genreTwo)
                                        movie.score++;

                                }
                            }
                            for (int keywordOne : currentMovie.keyword_ids) {
                                for (int keywordTwo : movie.keyword_ids) {
                                    if (keywordOne == keywordTwo)
                                        movie.score++;

                                }
                            }
                            for (int actorOne : currentMovie.actor_ids) {
                                for (int actorTwo : movie.actor_ids) {
                                    if (actorOne == actorTwo)
                                        movie.score++;

                                }
                            }
                            for (int crewOne : currentMovie.crew_ids) {
                                for (int crewTwo : movie.crew_ids) {
                                    if (crewOne == crewTwo)
                                        movie.score++;
                                }
                            }
                        }

                    }
                    Collections.sort(movies, (o1, o2) -> o1.getScore() - o2.getScore());
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Recommendations for " + userChoice);
                    int j = 0;
                    for (int i = movies.size() - 1; i > movies.size() - 6; i--) {
                        j++;
                        System.out.println(j + " - " + movies.get(i).name);
                    }
                    for (Movie m : movies) {
                        m.score = 0;
                    }
                    System.out.println("-------------------------------------------------------");
                } else {
                    System.out.println("\nSorry, movie not found.\n");
                }
            }


        }
    }

    private static void readCSVs(Connection con) throws SQLException{
        con.setAutoCommit(false);
        Statement st = con.createStatement();
        String sql = "CREATE DATABASE IF NOT EXISTS Movie_DB";
        st.executeUpdate(sql);
        sql = "USE Movie_DB";
        st.executeUpdate(sql);
        System.out.println("Loading movies...");
        sql = "CREATE TABLE IF NOT EXISTS starred_in(movie_id INT UNSIGNED, actor_id INT UNSIGNED)";
        st.executeUpdate(sql);
        //System.out.println("Table actor_connect created");
        sql = "CREATE TABLE IF NOT EXISTS actors(actor_id INT UNSIGNED, name VARCHAR(50))";
        st.executeUpdate(sql);
        //System.out.println("Table actors created");
        sql = "CREATE TABLE IF NOT EXISTS directors(movie_id INT UNSIGNED, director_id INT UNSIGNED, name VARCHAR(50))";
        st.executeUpdate(sql);
        //System.out.println("Table directors created");
        sql = "CREATE TABLE IF NOT EXISTS has_genres(movie_id INT UNSIGNED, genre_id INT UNSIGNED)";
        st.executeUpdate(sql);
        //System.out.println("Table genre_connect created");
        sql = "CREATE TABLE IF NOT EXISTS genres(genre_id INT UNSIGNED, name VARCHAR(20))";
        st.executeUpdate(sql);
        //System.out.println("Table genres created");
        sql = "CREATE TABLE IF NOT EXISTS keywords_in(movie_id INT UNSIGNED, keyword_id INT UNSIGNED)";
        st.executeUpdate(sql);
        //System.out.println("Table keyword_connect created");
        sql = "CREATE TABLE IF NOT EXISTS keywords(keyword_id INT UNSIGNED, name VARCHAR(50))";
        st.executeUpdate(sql);
        //System.out.println("Table keywords created");
        sql = "CREATE TABLE IF NOT EXISTS movies(movie_ID INT UNSIGNED, name VARCHAR(100), popularity DOUBLE UNSIGNED, vote INT UNSIGNED)";
        st.executeUpdate(sql);
        //System.out.println("Table movies created");
        //System.out.println("Loading starred_in.csv into actor_connect table");
        readStarred_in(con);
        //System.out.println("Loading actors.csv into actors table");
        readActors(con);
        //System.out.println("Loading directors.csv into director table");
        readDirectors(con);
        //System.out.println("Loading has_genres.csv into genres table");
        readGenre_Connect(con);
        //System.out.println("Loading genres.csv into genres table");
        readGenres(con);
        //System.out.println("Loading kewords_in.csv into keyword_connect table");
        readKeywords_in(con);
        //System.out.println("Loading keywords.csv into keywords table");
        readKeywords(con);
        //System.out.println("Loading movies.csv into movies table");
        readMovies(con);
        con.setAutoCommit(true);
    }


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false";
        String uname = "root";
        String pass = "Melissa1!";
        Connection con = DriverManager.getConnection(url, uname, pass);
        readCSVs(con);
        fillMovies(con);
        recommendationEngine(con);

    }
}

