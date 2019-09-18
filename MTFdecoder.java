// - MTFdecoder - this program decodes decoded files from the MTFencoder
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

//Decode codees MTF files that have be encoded
class MTFdecoder
{
  //Main Method
  public static void main(String[] args)
  {
    if (args.length != 1)
    {
      System.err.println("Usage:  java MTFdecoder <filename to be decoded>");
      return;
    }
    else
    {
      try
      {
        FileReader readerFile = new FileReader(args[0]);
        BufferedReader BufferReader = new BufferedReader(readerFile);
        String fileString = BufferReader.readLine();
        String delims = " ";
        FileWriter fileWriter = new FileWriter(args[0]);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        //Word List to store the tokens
        wordListString wordList = new wordListString();

        //Reading file
        while (fileString != null)
        {
          StringTokenizer tokenMake = new StringTokenizer(fileString,delims);
          String nextToken;
          boolean canTokenAdd = false;
          //Making sure the line still has tokens to make
          while (tokenMake.hasMoreTokens())
          {
            nextToken = tokenMake.nextToken();

            if (canTokenAdd == true)
            {
              wordList.add(nextToken);
              canTokenAdd = false;
              printToken(nextToken,writer);//Printing to the file
              wordList.moveToFront(nextToken);
            }
            //Checking if hte input is a zero to allow the next word to print
            else if (nextToken.equals(Integer.toString(0)))
            {
              canTokenAdd = true;
            }
            else
            {
              nextToken = wordList.getStringAtIndex(nextToken);//Getting the String at the specificed index
              printToken(nextToken,writer);//Printin the file
              wordList.moveToFront(nextToken);
            }
            nextToken = null;
          }
          fileString = BufferReader.readLine();//Reading the nextline of the file
        }
        //Closing reader and writer
        BufferReader.close();
        writer.close();
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
  }
  //Write to a file given the Bufferedreader
  //Will write for special cases
  private static void printToken(String nextToken, BufferedWriter writer)
  {
    try
    {
      //Goes through the special cases of space and \n line characters
      if(nextToken.equals("><SPACE><"))
      {
        writer.append(" ");
      }
      else if(nextToken.equals("\\n"))
      {
        writer.append("\n");
      }
      else
      {
        writer.write(nextToken);
      }
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
  }
}//End Bracket
