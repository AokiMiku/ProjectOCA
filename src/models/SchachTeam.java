package models;

public enum SchachTeam
{
	WEISS,
	SCHWARZ;
	
	@Override
	public String toString()
	{
		return super.toString().substring(0, 1) + super.toString().toLowerCase().substring(1);
	}
}