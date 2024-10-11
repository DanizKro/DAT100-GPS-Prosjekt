package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		gpspoints = new GPSPoint[antall];
	
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			return true;
		}	else {
            return false;
		}	
}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		// ta inn parametre og konvertere til data
		
		int tid = GPSDataConverter.toSeconds(time); 	 // Konverterer tiden til sekunder
	    double lat = Double.parseDouble(latitude);           // Konverterer breddegrad til double
	    double lon = Double.parseDouble(longitude);          // Konverterer lengdegrad til double
	    double elev = Double.parseDouble(elevation);         // Konverterer høyde til double
		
		// sjekke om plass i objekt tabell
	  
		
		// Hvis plass, putte lage ny objekt peker
	    
	    GPSPoint point = new GPSPoint(tid, lat, lon, elev);
		
	}

	public void print() {

		throw new UnsupportedOperationException(TODO.method());

		// TODO 
	}
}
