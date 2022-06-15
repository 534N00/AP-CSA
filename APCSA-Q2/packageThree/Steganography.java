package packageThree;

import java.awt.Color;

/**
 * Steganography class 
 * Author: Sean Craig
 * Date: 13Dec2021
 * Description: Steganography demonstrates how
 * you can hide an image inside of another image,
 * and pull it back out after while the hidden
 * image is still identifiable.
 * 
 * The maximum number of bits that can be masked
 * while not making the fact that there is an image
 * hidden too obvious, is 4 bits masked.
 */
public class Steganography
{
	/**
	 * Constructor for objects of class Steganography
	 */
	  public Steganography()
	  {
		  
	  }
	  
	  /**
	   * Clear the lower (rightmost) two bits in a pixel.
	   * @param p pixel to be changed
	   */
	  public static void clearLow( Pixel p, int n )
	  {
	    Color oldColor = p.getColor();
	    
	    p.setColor(new Color((int)Math.pow(2, n)*(oldColor.getRed()/(int)Math.pow(2, n)),
	    		(int)Math.pow(2, n)*(oldColor.getGreen()/(int)Math.pow(2, n)), 
	    		(int)Math.pow(2, n)*(oldColor.getBlue()/(int)Math.pow(2, n))));
	  }
	  
	  /**
	   * Method to test clearLow on all pixels in a Picture
	   * @param pic Picture to be changed
	   * @return modified picture
	   */
	  public static Picture testClearLow(Picture pic, int n)
	  {
	    Picture p = new Picture(pic);
	    Pixel [][] pixels = p.getPixels2D();
	    for (int r = 0; r < pixels.length; r++)
	    {
	      for (int c = 0; c < pixels[0].length; c++)
	      {
	        clearLow(pixels[r][c], n);
	      }
	    }
	    return p;
	  }
	  
	  /**
	   * Set the lower n bits in a pixel to the highest n bits in c
	   * @param p pixel to be changed
	   * @param c color to be used for modification
	   */
	  public static void setLow(Pixel p, Color c, int n)
	  {
	    clearLow(p, n);
	    Color oldColor = p.getColor();
	    int rAdd = c.getRed() / (int)Math.pow(2, 8-n);
	    int gAdd = c.getGreen() / (int)Math.pow(2, 8-n);
	    int bAdd = c.getBlue() / (int)Math.pow(2, 8-n);
	    p.setColor(new Color(oldColor.getRed()+rAdd,
	                         oldColor.getGreen()+gAdd, oldColor.getBlue()+bAdd));
	  }
	  
	  /**
	   * Method to test setLow on all pixels in a Picture
	   * @param pic picture to be changed
	   * @param col color to be used in modification
	   * @param n is the number of bits being masked
	   * @return modified picture
	   */
	  public static Picture testSetLow(Picture pic, Color col, int n)
	  {
	    Picture p = new Picture(pic);
	    Pixel [][] pixels = p.getPixels2D();
	    for (int r = 0; r < pixels.length; r++)
	    {
	      for (int c = 0; c < pixels[0].length; c++)
	      {
	        setLow(pixels[r][c], col, n);
	      }
	    }
	    return p;
	  }
	  
	  /**
	   * Sets the highest two bits of each pixel’s colors
	   * to the lowest two bits of each pixel’s colors
	   * @param hidden picture with hidden image
	   * @param n is the number of bits being masked
	   * @return revealed picture
	   */
	  public static Picture revealPicture(Picture hidden, int n)
	  {
	    Picture copy = new Picture(hidden);
	    Pixel[][] pixels = copy.getPixels2D();
	    Pixel[][] source = hidden.getPixels2D();
	    for (int r = 0; r < pixels.length; r++)
	    {
	      for (int c = 0; c < pixels[0].length; c++)
	      {   
	        Color col = source[r][c].getColor();
	        Pixel p = pixels[r][c];     
	        p.setRed(col.getRed() % (int)Math.pow(2, n) * (int)Math.pow(2, 8-n));
	        p.setGreen(col.getGreen() % (int)Math.pow(2, n) * (int)Math.pow(2, 8-n));
	        p.setBlue(col.getBlue() % (int)Math.pow(2, n) * (int)Math.pow(2, 8-n));
	      }
	    }
	    return copy;
	  }
	  
	  /**
	   * Determines whether secret can be hidden in source, which is
	   * true if source and secret are the same dimensions.
	   * @param source is not null
	   * @param secret is not null
	   * @return true if secret can be hidden in source, false otherwise.
	   */
	  public static boolean canHide(Picture source, Picture secret)
	  {
	    return source.getWidth() == secret.getWidth() &&
	      source.getHeight() == secret.getHeight();
	  }
	  
	  /**
	   * Creates a new Picture with data from secret hidden in data from source
	   * @param source is not null
	   * @param secret is not null
	   * @param n is number of bits being masked
	   * @return combined Picture with secret hidden in source
	   * precondition: source is same width and height as secret
	   */
	  public static Picture hidePicture(Picture source, Picture secret, int n)
	  {
	    Picture hidden = new Picture(source);
	    Pixel[][] hPixels = hidden.getPixels2D();
	    Pixel[][] sPixels = secret.getPixels2D();
	    // Since the images are the same size,
	    // either can be used for loop conditions.
	    for (int r = 0; r < hPixels.length; r++)
	    {
	      for (int c = 0; c < hPixels[0].length; c++)
	      {
	        Pixel s = sPixels[r][c];
	        setLow(hPixels[r][c], s.getColor(), n);
	      }
	    }
	    return hidden;
	  }
	  
	  /**
	   * Main method
	   */
	  public static void main(String[] args) 
	  {
		  
		  // Activity 2.8
		  Picture beach = new Picture("beach.jpg");
		  Picture arch = new Picture("arch.jpg");
		  System.out.println ("beach same size as arch: " + 
				  canHide(beach, arch));
		  // Activity 2.9
		  Picture swan = new Picture("swan.jpg");
		  swan.explore();
		  Picture gorge = new Picture("gorge.jpg");
		  // Picture combined = hidePicture(swan, gorge);
		  //  combined.explore();
		  // Activity 2.11 - pics are already loaded above
		  if(canHide(swan, gorge)) 
		  {
			  Picture combined1 = hidePicture(swan, gorge, 7);
			  combined1.explore();
			  Picture revealed = revealPicture(combined1, 7);
			  revealed.explore();
		  }	
		  
	  }
	  
}
