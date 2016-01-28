//team:     RIC Richmond Oilers A
public class Team {
	
  private String teamID;	// teamID == team
  private String location;
  private String teamName;
  private char league;

	public Team(String teamID, String location, String teamName, char league) 
	{
		this.setTeamID(teamID);
		this.setLocation(location);
		this.setTeamName(teamName);
		this.setLeague(league);
	}
	
	public Team() 
	{
		this.setTeamID("RIC");
		this.setLocation("Richmond");
		this.setTeamName("Oilers");
		this.setLeague('A');
	}

	public String getTeamID()
	{
		return teamID;
	}

	public void setTeamID(String teamID)
	{
		this.teamID = teamID;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getTeamName()
	{
		return teamName;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public char getLeague()
	{
		return league;
	}

	public void setLeague(char league)
	{
		this.league = league;
	}
	
	// add_team RIC Richmond Oilers A
	public boolean verifyParameters() {
		// team_ID: capital letters and/or digits
		if (!(getTeamID().matches("[A-Z]+") || !(getTeamID().matches("[0-9]+")))) {
			return false;
		}

		// Location: American City name, one or two English words(s)
		if (!getLocation().matches("[A-Za-z]+")) {
			return false;
		}
		
		// Name: team name, any reasonable English word
		if (!getTeamName().matches("[A-Za-z]+")) {
			return false;
		}
		
		// League: one capital letter
		if (!Character.isUpperCase(getLeague()) ) {
			return false;
		}		
		
		return true;
	}
	
	public void printTeams() {
		System.out.println(
				getTeamID() + " " + getLocation() + " " + getTeamName() + " " + getLeague());
	}
	
}
