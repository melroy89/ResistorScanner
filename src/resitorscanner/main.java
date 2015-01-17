package resitorscanner;

import javax.swing.JOptionPane;

import resitorscanner.Webcam;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting...");
		Webcam webcam = null;
		try {
			// Load the native library.
			System.loadLibrary("opencv_java248");
			
			int count = 0;
			int dialogResult = -1;
			while(true) 
			{			
				if(count == 0 )
				{
					dialogResult = JOptionPane.YES_OPTION;
				}
				else
				{		
					dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to scan more resistors...?", "Do you have more..?", JOptionPane.YES_NO_OPTION);					
				}
				
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					webcam = new resitorscanner.Webcam();			
					webcam.setup();
					webcam = null;
					count++;
				}
				else
				{
					break;
				}
			}
		} 
		catch (Exception e)
		{
			if(webcam != null)
			{
				System.out.println("\nError! Close all\n\n");
				webcam.closeAll();
			}
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			System.out.println("\nThanks for using Resistor Scanner");
		}
	}

}
