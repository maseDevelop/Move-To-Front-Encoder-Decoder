// - This is a MTFencoder
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.FileWriter;

//encoded a give file into the MTF format and outputs to a new file specified by user
class MTFencoder
{
  //Print token prints the output to a file with a specified BufferedWriter & index
  private static void printToken(int i, String tokenToPrint, BufferedWriter bWriter)
  {
    try
    {
      if(i == 0)
      {
        //This will write "0 word" and than a new line
        bWriter.append( i + " "+ tokenToPrint + "\n");
      }
      else
      {
        //This will write the index
        bWriter.append(i + "\n");
      }

    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  //Main Method
  public static void main( String[] args)
  {
    if(args.length != 2)
    {
      System.err.println("Usage:  java MTFencoder <filename> <output filename>");
      return;
    }
    else
    {
      try
      {
        FileReader readerFile = new FileReader(args[0]);
        BufferedReader bufferReader = new BufferedReader(readerFile);
        FileWriter fileWriter = new FileWriter(args[1]);
        String fileString = bufferReader.readLine();
        String delims = ".,;:! -\t\n";
        int index;
        String newToken = null;
        BufferedWriter writer = new BufferedWriter(fileWriter);
        //Word List to store the tokens
        wordListString wordList = new wordListString();
        //Reading file
        while(fileString != null)
        {
          StringTokenizer tokenMake = new StringTokenizer(fileString,delims,true);
          //Going through the and tokenizing the strings
          while(tokenMake.hasMoreTokens())
          {

            newToken = tokenMake.nextToken();
            if(newToken.equals(" ")){ newToken = "><SPACE><";} //Checking if the token is a space token
            //Getting the INDEX of the token in the wordList
            wordList.add(newToken);
            index = wordList.getIndex(newToken);

            printToken(index,newToken,writer);//Printing to a file
            wordList.moveToFront(newToken);
          }
          //Dealing with the special case of a escape charter - \n
          wordList.add("\\n");
          index = wordList.getIndex("\\n");
          printToken(index, "\\n",writer);
          wordList.moveToFront("\\n");
          //Reading the new line
          fileString = bufferReader.readLine();
        }
        //Closing the reader
        bufferReader.close(); //Closing Bufferreader
        writer.close(); //Closing the writer
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
  }
}//End bracket
