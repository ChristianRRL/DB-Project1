//coach:    CARTEKE 1999 ken carter 77 33 7 3 RIC
public class Coach
{

	private String coachID;
	private int season;
	private String firstName;
	private String lastName;
	private int seasonWin;
	private int seasonLoss;
	private int playoffWin;
	private int playoffLoss;
	private String team; // team == teamID

	public Coach(String coachID, int season, String firstName, String lastName, int seasonWin, int seasonLoss,
			int playoffWin, int playoffLoss, String team)
	{
		this.setCoachID(coachID);
		this.setSeason(season);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSeasonWin(seasonWin);
		this.setSeasonLoss(seasonLoss);
		this.setPlayoffWin(playoffWin);
		this.setPlayoffLoss(playoffLoss);
		this.setTeam(team);

	}

	public Coach()
	{
		this.setCoachID("CARTEKE");
		this.setSeason(1999);
		this.setFirstName("Ken");
		this.setLastName("Carter");
		this.setSeasonWin(77);
		this.setSeasonLoss(33);
		this.setPlayoffWin(7);
		this.setPlayoffLoss(3);
		this.setTeam("RIC");
	}
	
//	// Copy Constructor if necessary
//	public Coach(Coach copy) {
//		this.setCoachID(copy.getCoachID());
//		this.setSeason(copy.getSeason());
//		this.setFirstName(copy.getFirstName());
//		this.setLastName(copy.getLastName());
//		this.setSeasonWin(copy.getSeasonWin());
//		this.setSeasonLoss(copy.getSeasonLoss());
//		this.setPlayoffWin(copy.getPlayoffWin());
//		this.setPlayoffLoss(copy.getPlayoffLoss());
//		this.setTeam(copy.getTeam());
//	}

	public String getCoachID()
	{
		return coachID;
	}

	public void setCoachID(String coachID)
	{
		this.coachID = coachID;
	}

	public int getSeason()
	{
		return season;
	}

	public void setSeason(int season)
	{
		this.season = season;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getSeasonWin()
	{
		return seasonWin;
	}

	public void setSeasonWin(int seasonWin)
	{
		this.seasonWin = seasonWin;
	}

	public int getSeasonLoss()
	{
		return seasonLoss;
	}

	public void setSeasonLoss(int seasonLoss)
	{
		this.seasonLoss = seasonLoss;
	}

	public int getPlayoffWin()
	{
		return playoffWin;
	}

	public void setPlayoffWin(int playoffWin)
	{
		this.playoffWin = playoffWin;
	}

	public int getPlayoffLoss()
	{
		return playoffLoss;
	}

	public void setPlayoffLoss(int playoffLoss)
	{
		this.playoffLoss = playoffLoss;
	}

	public String getTeam()
	{
		return team;
	}

	public void setTeam(String team)
	{
		this.team = team;
	}

	// add_coach CARTEKE01 1999 ken carter 77 33 7 3 RIC
	public boolean verifyParameters()
	{
		// Coach_ID: a alphanumeric string
		if (!(getTeam().matches("[A-Za-z]+") || !(getTeam().matches("[0-9]+"))))
		{
			System.out.println(getCoachID());
			return false;
		}

		// season: 4 digit year
		if (Integer.toString(getSeason()).length() != 4)
		{
			return false;
		}

		// first_name: any reasonable English name
		if (!getFirstName().matches("[A-Za-z0-9]+"))
		{
			return false;
		}

		// last_name: any reasonable English name
		if (!getLastName().matches("[A-Z+a-z]+"))
		{
			return false;
		}

		// season_win: non-negative integer
		if (getSeasonWin() < 0)
		{
			return false;
		}

		// season_loss: non-negative integer
		if (getSeasonLoss() < 0)
		{
			return false;
		}

		// playoff_win: non-negative integer
		if (getPlayoffWin() < 0)
		{
			return false;
		}

		// playoff_loss: non-negative integer
		if (getPlayoffLoss() < 0)
		{
			return false;
		}

		// team: capital letters and/or digits
		if (!(getTeam().matches("[A-Z]+") || !(getTeam().matches("[0-9]+"))))
		{
			return false;
		}

		return true;
	}
	
	public boolean searchAttribute(String field, String value) {
		
//		System.out.println("***" + getFirstName() + " " + value + ": " + field.equals("first_name") + " " + value.equals(getFirstName()));
		
		// Coach_ID : a alphanumeric string,
		if (field.equals("Coach_ID") && value.equals(getCoachID())) {
			return true;
		}
		
		// season : 4 digit year,
		if (field.equals("season") && Integer.parseInt(value) == getSeason()) {
			return true;
		}
		
		// first_name : any reasonable English name ,
		if (field.equals("first_name") && value.equals(getFirstName())) {
			return true;
		}
		
		// last_name : any reasonable English name,
		if (field.equals("last_name") && value.equals(getLastName())) {
			return true;
		}		
		
		// season_win : non-negative integer,
		if (field.equals("season_win") && Integer.parseInt(value) == getSeasonWin()) {
			return true;
		}
		
		// season_loss : non-negative integer,
		if (field.equals("season_loss") && Integer.parseInt(value) == getSeasonLoss()) {
			return true;
		}
		
		// playoff_win : non-negative integer,
		if (field.equals("playoff_win") && Integer.parseInt(value) == getPlayoffWin()) {
			return true;
		}
		
		// playoff_loss : non-negative integer,
		if (field.equals("playoff_loss") && Integer.parseInt(value) == getPlayoffLoss()) {
			return true;
		}
		
		// team : capital letters and/or digits)
		if (field.equals("team") && value.equals(getTeam())) {
			return true;
		}
		
		
		return false;
	}
	
	public void printCoaches()
	{
		System.out.println(
				getCoachID() + " " + getSeason() + " " + getFirstName() + " " + getLastName() + " " + getSeasonWin()
						+ " " + getSeasonLoss() + " " + getPlayoffWin() + " " + getPlayoffLoss() + " " + getTeam());
	}
}
