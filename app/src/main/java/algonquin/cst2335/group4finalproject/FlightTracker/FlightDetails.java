package algonquin.cst2335.group4finalproject.FlightTracker;

public class FlightDetails {
    public String flightNo;
    public  String destination;
    public String gate;
    public String delay;

    public Boolean isDetails;

    public FlightDetails(){

    }
    public FlightDetails( String f, String dstn, String g, String dl, Boolean isDtl ){
        flightNo = f;
        destination = dstn;
        gate = g;
        delay = dl;
        isDetails = isDtl;
    }

    public String getFlightNo(){
        return flightNo;
    }

    public String getDestination(){
        return destination;
    }

    public String getGate(){
        return gate;
    }

    public String getDelay(){
        return delay;
    }

    public Boolean getIsDetails(){
        return isDetails;
    }
}
