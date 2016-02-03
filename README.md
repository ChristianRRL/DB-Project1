# DB-Project1: NBA Statistics Database

##Description

In this project, you are expected to build a small database that stores data related to NBA coaches and teams. Users can send simple queries to this database, and add new data to the database. The database has two tables (or relations) - one for coaches and one for teams. The schemas for the two tables are as follows (and you must follow the schemas in this project):

coaches (Coach_ID : a alphanumeric string,
season : 4 digit year,
first_name : any reasonable English name ,
last_name : any reasonable English name,
season_win : non-negative integer,
season_loss : non-negative integer,
playoff_win : non-negative integer,
playoff_loss : non-negative integer,
team : capital letters and/or digits)

teams (team_ID : capital letters and/or digits,
Location : American City name, one or two English word(s),
Name : team name, any reasonable English word, 
League : one capital letter)

Your database should have a command-line interface to allow users to add data and send in queries. This is important as deviation from this design could yield a low score in your project. The interface accepts the following commands:

1. add_coach: add a new record describing the performance of one coach in one season. It should have the following 9 arguments: ID SEASON FIRST_NAME LAST_NAME SEASON_WIN SEASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM, the types of which should match the schema of relation "coaches" mentioned above ;

2. add_team: add a new record with one team's basic information. It should be followed by the following 4 arguments: ID LOCATION NAME LEAGUE, the types of which should match the schema of the "teams" table;

3. load_coaches : bulk load of multiple coach/season records from a data file specified by the only argument of the command. Note that the file stores each record in one line of text, and different fields of the line/record are separated by commas. In our sample files, you may find empty attribute values (nothing in between two commas) and you should still load that line into your database instead of rejecting it.

4. load_teams : bulk load of multiple team records from a file specified by the only argument of the command. Records in such files are organized in the same way as in those for load_coaches.

5. print_coaches: print a list of all coaches, with info about one coach's performance in one season in a line;

6. print_teams: print a list of all teams, with info about one team per line;

7. coaches_by_name : print the information of coach(es) with the specified last name, which is given by the only argument of this command;

8. teams_by_city : print the information of teams in the city specified by the only argument;

9. best_coach: print the name of the coach who has the most net wins in a season specified by the only argument. Note that the net wins should be calculated as (season_win - season_loss) + (playoff_win - playoff_loss).

10. search_coaches: print the info of coaches with the specified properties, which are given by the arguments in the following format: field=VALUE where field represents the name of a search criterion and 'VALUE' is the value of that field you want the query results to match. Multiple fields can be used in the same query. For example, a command "search_coaches first_name=John season_win=40" means "finding all performance data of a coach with first name 'John' who had a seasonal win of 40". Note that a meaningful field should match exactly one of the column names in the coaches table (just ignore those that do not match any column names).

11. delete_coaches: this command has the same arguments and allows you to do the same things as in search_coaches, except that you delete from the database the coach(es) found using the specified conditions. 

A coach's last name can be two words with a space in between (e.g., van Gundy). Your code should be able to handle this. There will be testcases that search by such names. In order to not confuse your program, we will add a "+" sign between the two words of the last name in the testcases. For example,

coaches_by_name van+Gundy

Obviously, your job here would be to process the argument by replacing the "+" sign with a space before you do the search. The same should be done for city names and other commands such as add_coach and add_team.

###Acknowledgements
Data used in this project is provided by basketballconference.com
![Image of SteroidToCat](https://octodex.github.com/images/steroidtocat.png)
Don't mess with the Octocat
