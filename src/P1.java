import java.io.*;
import java.util.*;

public class P1
{

	// coach: CARTEKE 1999 ken carter 77 33 7 3 RIC
	// team: RIC Richmond Oilers A

	/* Define data structures for holding the data here */
	public List<Coach> coachList;
	public List<Team> teamList;
	private Scanner sc;

	public P1()
	{
		/* initialize the data structures */
		coachList = new ArrayList<Coach>();
		teamList = new ArrayList<Team>();
		
	}

	public void run()
	{
		CommandParser parser = new CommandParser();

		System.out.println("The mini-DB of NBA coaches and teams");
		System.out.println("Please enter a command.  Enter 'help' for a list of commands.");
		System.out.println();
		System.out.print("> ");

		Command cmd = null;
		while ((cmd = parser.fetchCommand()) != null) 
		{
//			System.out.println(cmd);

			boolean result = false;

			if (cmd.getCommand().equals("help"))
			{
				result = doHelp();

				/* You need to implement all the following commands */

			} 
			else if (cmd.getCommand().equals("add_coach"))
			{
				// add_coach CARTEKE 1999 ken carter 77 33 7 3 RIC
												
				if (cmd.getParameters().length == 9) {

					try {
						Coach tempCoach = new Coach(cmd.getParameters()[0],
								Integer.parseInt(cmd.getParameters()[1]),
								cmd.getParameters()[2],
								cmd.getParameters()[3],
								Integer.parseInt(cmd.getParameters()[4]),
								Integer.parseInt(cmd.getParameters()[5]),
								Integer.parseInt(cmd.getParameters()[6]),
								Integer.parseInt(cmd.getParameters()[7]),
								cmd.getParameters()[8]);
						if (tempCoach.verifyParameters()) {
							coachList.add(tempCoach);
							System.out.println("Coach successfully added to list.");
						}
					}
					catch(Exception e) {
						System.out.println("One or more parameters of incorrect type.");
						System.out.println("Please try again.");
					}					
				}
				else if (cmd.getParameters().length < 9) {
					System.out.println("Too few parameters.");
					System.out.println("Please try again.");
				}
				else {
					System.out.println("Too many parameters.");
					System.out.println("Please try again.");
				}
				
			} 
			else if (cmd.getCommand().equals("add_team"))
			{
				// add_team RIC Richmond Oilers A
				
				if (cmd.getParameters().length == 4) {
					
					try {
						Team tempTeam = new Team(cmd.getParameters()[0],
								cmd.getParameters()[1],
								cmd.getParameters()[2],
								cmd.getParameters()[3].charAt(0));						
						if (tempTeam.verifyParameters()) {
							teamList.add(tempTeam);
							System.out.println("Team successfully added to list.");
						}
					}
					catch (Exception e) {
						System.out.println("Invalid parameters.");
						System.out.println("Please try again.");
					}
				}
				else if (cmd.getParameters().length < 4) {
					System.out.println("Too few parameters.");
					System.out.println("Please try again.");
				}
				else {
					System.out.println("Too many parameters.");
					System.out.println("Please try again.");
				}
			} 
			else if (cmd.getCommand().equals("print_coaches"))
			{
				for (Coach coach : coachList) {
					coach.printCoaches();
				}
			} 
			else if (cmd.getCommand().equals("print_teams"))
			{
				for (Team team : teamList) {
					team.printTeams();
				}
			} 
			else if (cmd.getCommand().equals("coaches_by_name"))
			{
				for (int i = 0; i < coachList.size(); i++) {
					if (cmd.getParameters().length <= 0) {
						break;
					}
					if (coachList.get(i).getLastName().equals(cmd.getParameters()[0])) {
						coachList.get(i).printCoaches();
					}
				}
			} 
			else if (cmd.getCommand().equals("teams_by_city"))
			{
				for (int i = 0; i < teamList.size(); i++) {
					if (cmd.getParameters().length <= 0) {
						break;
					}
					if (teamList.get(i).getLocation().equals(cmd.getParameters()[0])) {
						teamList.get(i).printTeams();
					}
				}
			} 
			else if (cmd.getCommand().equals("load_coaches"))
			{
				try {
					sc = new Scanner(new File("coaches_season.txt"));
					while (sc != null) {
						String temp = sc.nextLine();
						if (temp != null) {
							System.out.println(temp);
						}
						else {
							break;
						}
					}
				}
				catch (Exception e) {
					System.out.println("404 - File not found.");
				}
			}
			else if (cmd.getCommand().equals("load_teams"))
			{

			} 
			else if (cmd.getCommand().equals("best_coach"))
			{
				int bestCoachIndex = -1;
				int tempEquation1 = -1;
				int tempEquation2 = -2;
				
				for (int i = 0; i < coachList.size(); i++) {
					if (cmd.getParameters().length <= 0) {
						break;
					}
					if (coachList.get(i).getSeason() == Integer.parseInt(cmd.getParameters()[0])) {
						tempEquation1 = coachList.get(i).getSeasonWin() - coachList.get(i).getSeasonLoss()
								+ coachList.get(i).getPlayoffWin() - coachList.get(i).getPlayoffLoss();
						if (tempEquation1 > tempEquation2) {
							bestCoachIndex = i;
							tempEquation2 = tempEquation1;
						}
					}
				}
				
				coachList.get(bestCoachIndex).printCoaches();
				
			} 
			else if (cmd.getCommand().equals("search_coaches"))
			{
				boolean isCoachFound = true;
				
				for (int i = 0; i < coachList.size(); i++) {
					for (int j = 0; j < cmd.getParameters().length; j++) {
						String attribute[] = cmd.getParameters()[j].split("=");
						if (!verifyAttribute(attribute[0])) {
							continue;
						}
						isCoachFound = coachList.get(i).searchAttribute(attribute[0], attribute[1]);
						if (!isCoachFound) {
							break;
						}
					}
					if (isCoachFound) {
						coachList.get(i).printCoaches();
					}
				}
			} 
			else if (cmd.getCommand().equals("delete_coaches"))
			{
				// delete_coaches
				boolean isCoachFound = true;
				boolean isAttribute = true;
				
				for (int i = coachList.size() - 1; i >= 0; i--) {
					for (int j = 0; j < cmd.getParameters().length; j++) {
						String attribute[] = cmd.getParameters()[j].split("=");
						isAttribute = verifyAttribute(attribute[0]); 
						if (!isAttribute) {
							continue;
						}
						isCoachFound = coachList.get(i).searchAttribute(attribute[0], attribute[1]);
						if (!isCoachFound) {
							break;
						}
					}
					if (isCoachFound && isAttribute && cmd.getParameters().length > 0) {
						coachList.remove(i);
					}
				}
				
				
			} 
			else if (cmd.getCommand().equals("exit"))
			{
				System.out.println("Leaving the database, goodbye!");
				break;
			} 
			else if (cmd.getCommand().equals(""))
			{

			} 
			else
			{
				System.out.println("Invalid Command, try again!");
			}

			if (result)
			{
				// ...
			}

			System.out.print("> ");
		}
	}

	private boolean doHelp()
	{
		System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WIN ");
		System.out.println("          SEASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
		System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
		System.out.println("print_coaches - print a listing of all coaches");
		System.out.println("print_teams - print a listing of all teams");
		System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
		System.out.println("teams_by_city CITY - list the teams in the specified city");
		System.out.println("load_coach FILENAME - bulk load of coach info from a file");
		System.out.println("load_team FILENAME - bulk load of team info from a file");
		System.out
				.println("best_coach SEASON - print the name of the coach with the most netwins in a specified season");
		System.out.println(
				"search_coaches field=VALUE - print the name of the coach satisfying the specified conditions");
		System.out.println("delete_coaches field=VALUE - delete the coach satisfying the specified conditions");
		System.out.println("exit - quit the program");
		return true;
	}
	
	private boolean verifyAttribute(String attribute) {
		
		// CoachCoach_ID : a alphanumeric string,
		if (attribute.equals("Coach_ID")) {
			return true;
		}
		
		// season : 4 digit year,
		if (attribute.equals("season")) {
			return true;
		}
		
		// first_name : any reasonable English name ,
		if (attribute.equals("first_name")) {
			return true;
		}
		
		// last_name : any reasonable English name,
		if (attribute.equals("last_name")) {
			return true;
		}
		
		// season_win : non-negative integer,
		if (attribute.equals("season_win")) {
			return true;
		}
		
		// season_loss : non-negative integer,
		if (attribute.equals("season_loss")) {
			return true;
		}
		
		// playoff_win : non-negative integer,
		if (attribute.equals("playoff_win")) {
			return true;
		}
		
		// playoff_loss : non-negative integer,
		if (attribute.equals("playoff_loss")) {
			return true;
		}
		
		// team : capital letters and/or digits)
		if (attribute.equals("team")) {
			return true;
		}		
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new P1().run();
	}

}
