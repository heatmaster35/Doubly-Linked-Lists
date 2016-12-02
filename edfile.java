/*##########################
# Name: Leo Gomez          #
# CruzID: legomez          #
# Class: CMPS-12B          #
# Date: Nov 5, 2014        #
# filename: edfile.java    #
# Details: creates the text#
#   editor for our asg2    #
############################
*/
// edfile.java
// Template for a line-oriented text editor inspired by ed.

import java.util.Scanner;
import static java.lang.System.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.PrintWriter;


class edfile
{
	public static void main (String[] args) throws IOException
	{
		System.out.println("Welcome!");
		File InFile = null;
		int linecount = -1;
		if (args.length == 0)
			InFile = new File("");
		if (args.length > 1)
		{
			InFile = new File(args[1]);
		} else if (args.length == 1)
		{
			InFile = new File(args[0]);
		}
		boolean want_echo = true;
		dllist lines = new dllist ();
		if (args.length > 0)
		if (args[0].compareTo("-e") != 0)
		{
			want_echo = false;
		}
		if(args.length != 0)
		{
			Scanner d = new Scanner(InFile);
			while(d.hasNextLine())
			{
				lines.insert(d.nextLine(),dllist.Position.LAST);
				linecount++;
			}
		}
		Scanner stdin = new Scanner (in);
		for (;;) 
		{
			if (! stdin.hasNextLine()) break;
			String inputline = stdin.nextLine();
			if(inputline.compareTo("") == 0)
				break;
			if (want_echo) out.printf ("%s%n", inputline);
			if (inputline.matches ("^\\s*$")) continue;
			char command = inputline.charAt(0);
			String part;
			String dummy[] = inputline.split(" ");
			if(dummy.length == 2 && (command == 'r'))
				part = dummy[1];
			else
			part = inputline.substring(1);
			switch (command) 
			{
				case '#': break;
				case '$': if(linecount>=0)
					  {
					  	lines.setPosition(dllist.Position.LAST);
					  	System.out.println(lines.getItem());
					  }else
						System.out.println("");
					  break;
				case '*': if(linecount >= 0)
					  {
					  	lines.setPosition(dllist.Position.FIRST);
					  	while (true)
					  	{
					  		System.out.println(lines.getItem());
							lines.setPosition(dllist.Position.PREVIOUS);
							if(lines.getPosition() == linecount+1)
							{
								lines.setPosition(dllist.Position.LAST);
								break;
							}
					 	 }
					  }else
						System.out.println("");
					  break;
				case '.': if(linecount >= 0)
					  	System.out.println(lines.getItem());
					  else
						System.out.println("");
					  break;
				case '0': if(linecount >= 0)
					  {
					  	lines.setPosition(dllist.Position.FIRST);
                                          	System.out.println(lines.getItem());
					  }else
						System.out.println("");
					  break;
				case '<': if(linecount >= 0)
					  {
					  	  if(lines.getPosition() >= linecount) 
					  		lines.setPosition(dllist.Position.LAST);
					  	  else
							lines.setPosition(dllist.Position.PREVIOUS);
                                        	  System.out.println(lines.getItem());
					  }else
						System.out.println("");
					  break;
				case '>': if(linecount >= 0)
					  {
					  	if(lines.getPosition() <= 0)
							lines.setPosition(dllist.Position.FIRST);
						  else
							lines.setPosition(dllist.Position.FOLLOWING);
						  System.out.println(lines.getItem());
					  }else
						System.out.println("");
					  break;
				case 'a': lines.insert(part, dllist.Position.FOLLOWING);
					  linecount++;
					  System.out.println(lines.getItem());
					  break;
				case 'd': if(linecount >= 0)
					  {
					  	lines.delete();
					  	linecount--;
					  }
					  break;
				case 'i': lines.insert(part, dllist.Position.PREVIOUS);
					  linecount++;
					  System.out.println(lines.getItem());
					  break;
				case 'r': File newFile = new File(part);
					  if(newFile.exists())
					  {  
					  	Scanner c = new Scanner(newFile);
					  	int lcount = 0;
					  	while(c.hasNextLine())
					  	{
							lines.insert(c.nextLine(),dllist.Position.PREVIOUS);
							lcount++;
							linecount++;
						}
					  	System.out.println(lcount + " new inserted lines");
					  }else
					  {
						System.out.println(part+" does not exist");
					  }
					  break;
				case 'w': lines.setPosition(dllist.Position.FIRST);
					  File outFile = new File(part);
					  if(!outFile.exists())
					  {
						outFile.createNewFile();
					  }
					  FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
					  BufferedWriter bw = new BufferedWriter(fw);
					  for(int i = 0;i < linecount+1; i++)
					  {
						System.out.println(lines.getItem());
						bw.write(lines.getItem()+"\n");
						lines.setPosition(dllist.Position.PREVIOUS);
					  }
					  bw.close();
					  System.out.println(linecount+1 + " numbers of lines written.");
					  break;
				default : System.out.println ("Invalid command."); break;
			}
		}
		System.exit(1);
	}
}

