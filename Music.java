package com.onebill.testyentra.music;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Music  {  
	public static void main(String[] args)  { 
	      
		Thread t = new Thread();
		Connection con=null;  
		Statement s=null;  
		ResultSet rs=null;  
		PreparedStatement p=null;
		char ch;
		int menuInput;  
		boolean flag=true;  
		Scanner sc=new Scanner(System.in);  
		try   
		{  

			Class.forName("com.mysql.jdbc.Driver");  
			System.out.println("Successfully registered driver");  
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicPlayer?user=root&password=Onebill@2020");
            System.out.println("Got connected with DB");  
		}  
		catch(Exception e)  
		{  
			System.out.println("Unable to connect with DB");  

		}      

		do  
		{   
			System.out.println(" Press 1 - play a songs \n press 2 - Search a song \n press 3 -show all songs\n press 4 - operate on songs database");  
			System.out.println("Enter your choice");  
			menuInput =sc.nextInt();
			switch(menuInput)  
			{  
			case 1:  
				System.out.println("Enter your choice\n A. B. C. ");  
				ch=sc.next().charAt(0);  
				switch(ch){

				case 'A' :  
					System.out.println("songs playing in sequential order");
					s = (Statement) con.createStatement();
					rs = ((java.sql.Statement) s).executeQuery("select Song_Title from MusicFiles order by asc");
					ArrayList<String> songsList = new ArrayList<String>();
					while(rs.next()) {
						songsList.add(rs.getString(1));
					}
					for(int i=0;i<songsList.size();i++) {
						System.out.println(songsList.get(i)+" is playing");
						t.sleep(300);//milisecond
					}    
					break;
				case 'B' : 
					System.out.println("songs playing in random order"); 
					s = (Statement) con.createStatement();
					rs = ((java.sql.Statement) s).executeQuery("select Song_Title from MusicFiles order by asc");
					ArrayList<String> songsLst = new ArrayList<String>();
					while(rs.next()) {
						songsList.add(rs.getString(1));
					}
					Collections.shuffle(songsLst);
					for(int i=0;i<songsList.size();i++) {
						System.out.println(songsList.get(i)+" is playing");
						t.sleep(300);//milisecond
					}    
					break;
				case 'C' :
					System.out.println("Enter the song title");
					String songName = sc.next();
					s = (Statement) con.createStatement();
					rs = ((java.sql.Statement) s).executeQuery("select Song_Title from MusicFiles where songname='"+songName+"'");
					if(rs.next()==false) {
						System.out.println("Entered song is not exist");
					}
					else {
						System.out.println(songName+" is playing");
					}
					break;
				}
				case 2:  
					System.out.println("Enter the song title");
					String name = sc.next();
					break;  

				case 3:  
					s = (Statement) con.createStatement();
					rs = ((java.sql.Statement) s).executeQuery("select * from MusicFiles order by asc");
					while(rs.next()) {
						System.out.println("| "+rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)+" | ");
					}
					break;  

				case 4:  
					System.out.println("Enter your choice\n A. B. C. ");  
					ch=sc.next().charAt(0);  
					String[] args;
					switch(ch){
					case 'A' :  System.out.println("add songs"); 
					           
								String query = "insert into MusicFiles values(?,?,?,?,?,?)";
					            p = con.prepareStatement(query);
					            String Song_ID       = args[0];
					            String Song_Title    = args[1];
					            String Artist_Name   = args[2];
					            String Album_Name    = args[3];
					            String Song_Location = args[4];
					            String  Description  = args[5];
					          
					            int  sid= Integer.parseInt(Song_ID);
					            p.setInt(1,sid);
					            p.setString(2,Song_Title );
					            p.setString(3, Artist_Name);
					            p.setString(4, Album_Name);
					            p.setString(5,Song_Location );
					            int res  = p.executeUpdate();
					            System.out.println(" Record inserted succesfully!");
					           break;
						
					case 'B' : System.out.println("editing songs"); 

				     	String query1 = "update MusicFiles set Song_Title=?,Artist_Name=?,Album_Name=?,Description=? where Song_ID=?";
		                p = con.prepareStatement(query1);
		                String Song_ID1     = args[0];
		                String Song_Title1  = args[1];
		                String Artist_Name1 = args[2];
		                String Album_Name1  = args[3];
		                String Song_Location1 = args[4];
		                String  Description1  = args[5];
			            int  sid1= Integer.parseInt(Song_ID1);
			           
			            p.setInt(1,5);
			            p.setString(2,"dhoom" );
			            p.setString(3, "shreya");
			            p.setString(4, "dhoom2");
			            p.setString(5,"/home/abhi/Desktop" );
			            int res1 =p.executeUpdate();
			            System.out.println("updated succesfully!");
				           break;


						
					case 'C' : 
						      String query2 = "delete from Student where Song_ID=?";
		                      p = con.prepareStatement(query);
		                      System.out.println("Enter id : ");
		          			  int s_id = sc.nextInt();
		          			  p.setInt(1, s_id);
		          			  int res2 = p.executeUpdate();
                              
						break;
						
					} 
			}	
					System.out.println("do u want to continue(yes /no)");  
					String str=sc.nextLine();  
					if(str.equals("yes")|| str.equals("y"))  
						flag=true;  
					if(str.equals("no")||str.equals("no"))  
						flag=false;  

				}while(flag);   
			}  
		} 
	
