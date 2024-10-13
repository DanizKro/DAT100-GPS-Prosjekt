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
		
		boolean svar = false;
		
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			svar = true;
			
		}	return svar;	
}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		
		int tid = GPSDataConverter.toSeconds(time); 	 
	    double lat = Double.parseDouble(latitude);          
	    double lon = Double.parseDouble(longitude);          
	    double elev = Double.parseDouble(elevation);         
	    
		// Laget en ny objekt referansetabell med dataene
	    
	    GPSPoint point = new GPSPoint(tid, lat, lon, elev);
		
	    // sjekker om plass i objekt tabell, og returnerer tabellen hvis TRUE
	    return insertGPS(point);
	}

	public void print() {
		
		System.out.println("===== GPS Data - START =====");
		
		for (int i = 0; i < gpspoints.length; i ++) {
			System.out.print(gpspoints[i]);
			
		} System.out.print("===== GPS Data - Slutt =====");
	}
}
