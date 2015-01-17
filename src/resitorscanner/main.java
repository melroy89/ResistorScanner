package resitorscanner;

import resitorscanner.Webcam;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting...");
		Webcam webcam = null;
		try {
			webcam = new resitorscanner.Webcam();
			
			webcam.setup();		
		} catch (Exception e){
			if(webcam != null)
			{
				System.out.println("Releasing the camera...");
				webcam.closeCamera();
			}
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}


