import java.util.*;


class TicTacToe
{
	public static char[][] board={{' ','|',' ','|',' '},
		                          {'-','+','-','+','-'},
								  {' ','|',' ','|',' '},
					              {'-','+','-','+','-'},
		                          {' ','|',' ','|',' '}};

	public static Scanner sc=new Scanner(System.in);
	public static Random rand=new Random();
	public static void main(String[] args)
	{
		
		while(true)
		{
			for(int i=0;i<5;i+=2)                          //Clearing the board for the next play.
		    {
			   for(int j=0;j<5;j+=2)
		     	{
					board[i][j]=' ';
				}
			}			
            
			System.out.print("Welcome to TicTacToe!\n1-Play with 2 players\n2-Play with computer\n3-Exit\nEnter your choice : ");
			int ch=sc.nextInt();sc.nextLine();
			if(ch==1)
			{
				loop(false,' ');
			}
			else if(ch==2)
			{
				System.out.print("'X' or 'O' ? : ");
				char symbol=sc.nextLine().charAt(0);
				if(symbol=='X' || symbol=='x')
				{
					loop(true,'O');                       //Computer will be playing with 'O'.
				}
				else
				{
					loop(true,'X');
				}
			}
			else if(ch==3)
			{
				System.out.println("Thank You!");break;
			}
		}

	}
	public static void loop(boolean comp,char symb)
	{
 
		int c=1;
		char symbol;

		display_board();
		while(true)
		{
			int pos=-1;
			int flag=0;
			String in_control=null;
			if(c%2==1)
			{   
		        if(comp && symb=='X')
				{
				  in_control="Comp :";
				  pos=rand.nextInt(9)+1;
				}
				else 
				{
				  in_control="Player 1:";
				}
				symbol='X';
			}
			else
			{
		        if(comp && symb=='O')
				{
	    			in_control="Comp :";
				    pos=rand.nextInt(9)+1;
				}
				else 
				{
	    			in_control="Player 2:";
				}
    			symbol='O';
			}
			System.out.println(in_control);
			if(pos==-1)
			{
			  pos=sc.nextInt();
			}
			switch(pos)
			{
				case 1:
				  if(board[0][0]==' ')
				   {
				     board[0][0]=symbol;break;
				   }
				   flag=1;break;
				case 2:
				  if(board[0][2]==' ')
				   {
				     board[0][2]=symbol;break;
				   }
				   flag=1;break;
				case 3:
				  if(board[0][4]==' ')
				   {
				     board[0][4]=symbol;break;
				   }
				   flag=1;break;
				case 4:
	    		  if(board[2][0]==' ')
				   {
				     board[2][0]=symbol;break;
				   }
				   flag=1;break;
				case 5:
				  if(board[2][2]==' ')
				   {
				     board[2][2]=symbol;break;
				   }
				   flag=1;break;
				case 6:
				   if(board[2][4]==' ')
				   {
				     board[2][4]=symbol;break;
				   }
				   flag=1;break;
				case 7:
				   if(board[4][0]==' ')
				   {
				     board[4][0]=symbol;break;
				   }
				   flag=1;break;
				case 8:
				  if(board[4][2]==' ')
				   {
				     board[4][2]=symbol;break;
				   }
				   flag=1;break;
				case 9:
				  if(board[4][4]==' ')
				   {
				     board[4][4]=symbol;break;
				   }
				   flag=1;break;
				default:
				    System.out.println("Invalid Input! Try again");c-=1;
			}
			if(flag==1)
			{
				System.out.println("Field already contains value!");c-=1;
			}
            
     		display_board();
			int v=check_board(symbol);
			if(v==1)
			{
				/*
				if(c%2==0)
				{
					System.out.println("Player 2 Wins!");
				}
				else
				{
					System.out.println("Player 1 Wins!");
				}
				break;
				*/
			
				System.out.println(in_control.substring(0,in_control.length()-1)+" Wins!");
				break;
			}
			else if(v==2)
			{
				System.out.println("Game Tied!");
				break;
			}
			c+=1;
			
		}
		
		
	}
	
	public static void display_board()
	{
		for(char[] i:board)
		{
			System.out.print("\t\t\t");
			for(char j:i)
			{
				System.out.print(j);
				
			}
			System.out.println();
		}			
	}
	public static int check_board(char symbol)
	{
		int flag=0;
        if((((board[0][0]==board[0][2] && board[0][2]==board[0][4])||(board[0][0]==board[2][0] && board[2][0]==board[4][0])||(board[0][0]==board[2][2] && board[2][2]==board[4][4]))&& board[0][0]==symbol)
			||(((board[2][0]==board[2][2] && board[2][2]==board[2][4])||(board[0][2]==board[2][2] && board[2][2]==board[4][2])||(board[0][4]==board[2][2] && board[2][2]==board[4][0]))&&board[2][2]==symbol)
		    ||(((board[4][0]==board[4][2] && board[4][2]==board[4][4])||(board[0][4]==board[2][4] && board[2][4]==board[4][4])) && board[4][4]==symbol))
		{
			return 1;
		}
		else
		{   
			for(int i=0;i<5;i+=2)
		    {
			   for(int j=0;j<5;j+=2)
		     	{
				  if(board[i][j]==' ')
				  {
					  flag=1;
					  break;
				  }					  
		    	}
			}
            if(flag==0)
			{
				return 2;
			}				
	
		    return 0;	
		}

	}

}