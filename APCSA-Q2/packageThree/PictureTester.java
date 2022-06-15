package packageThree;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /**
   * Method to test zeroBlue 
   */
  public static void testZeroBlue()
  {
    Picture mrM = new Picture("DrWhoJMeinzen.jpg");
    mrM.explore();
    mrM.zeroBlue();
    mrM.explore();
  }
  
/**
 * Method to remove the blue and red color
 */
public static void testKeepOnlyGreen()
{
	Picture mrM = new Picture("DrWhoJMeinzen.jpg");
	mrM.explore();
	mrM.zeroBlue();
	mrM.zeroRed();
	mrM.explore();
}
  
  /**
   * Method to test negateIt
   */
  public static void testNegate()
  {
	  Picture mrM = new Picture("DrWhoJMeinzen.jpg");
	  mrM.explore();
	  mrM.negateIt();
	  mrM.explore();
  }
  
  /**
   * Method to test greyIt
   */
  public static void testGrayscale()
  {
	  Picture mrM = new Picture("DrWhoJMeinzen.jpg");
	  mrM.explore();
	  mrM.greyIt();
	  mrM.explore();
  }
  
  /**
   * Method to test mirrorDiagonal
   */
  public static void testMirrorDiagonal()
  {
	  Picture mrM = new Picture("DrWhoJMeinzen.jpg");
	  mrM.explore();
	  mrM.mirrorDiagonal();
	  mrM.explore();
  }
  
  /** 
   * Method to test mirrorHorizontal
   */
  public static void testMirrorHorizontal()
  {
	  Picture mrM = new Picture("DrWhoJMeinzen.jpg");
	  mrM.explore();
	  mrM.mirrorHorizontal();
	  mrM.explore();
  }
 
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
	//testMirrorHorizontal();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
	  testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}