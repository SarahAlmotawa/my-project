
package projectgroupd;
public class Football extends Event {

    private String team1;
    private String team2;

    public Football() {
    }

    public Football(String name, String contactInfo, String city,
                    String date, String time, String location,
                    Ticket ticket, String team1, String team2) {

        super(name, contactInfo, city, date, time, location, ticket);
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void about() {
        System.out.println("This is a football event.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Football Match[ Team 1: " + team1 +
                " | Team 2: " + team2 + " ]");
    }

    @Override
    public String toString() {
        return super.toString() + "," + team1 + "," + team2;
    }
}
