import java.util.*;
public class GuessGameOasis
{
	int limit,level;
	GuessGameOasis(int limit,int level)
	{
		this.limit=limit;
		this.level=level;
		System.out.println("\t\t\t\t ------------------");
		System.out.println("\t\t\t\t| Level Number : "+level +" |");
		System.out.println("\t\t\t\t ------------------");
		System.out.println("\n\t\t\tNumber of attempts can be used is "+limit);
	}
	Random rand=new Random();
	Scanner sc=new Scanner(System.in);
	int sysNum,temp;
	int count,digit;
	public void check()
	{
		sysNum=0+rand.nextInt(100);
		if (level>=2)
		{
			sysNum=10+rand.nextInt(100);
		}
		temp=sysNum;
		while(temp>0)
		{
			digit+=1;
			temp=temp/10;
		}
		System.out.println("\nYour secret code is generated");
		do
		{
			int userNum=0,c=0,temp1;
			count++;
			System.out.println("\nAttempt number : "+count);
			System.out.print("Enter the "+digit+" digit code to guess: ");
			userNum=sc.nextInt();
			temp1=userNum;
			while(temp1>0)
			{
				c+=1;
				temp1=temp1/10;
			}
			if(c!=digit)
			{
				System.out.println("\tYour number is invalid");
				count-=1;
				continue;
			}
			if(userNum<sysNum)
			{
				System.out.println("\tYour number is less than the correct number");
			}
			else if(userNum>sysNum)
			{
				System.out.println("\tYour number is greater than the correct number");
			}
			else
			{
				System.out.println();
				System.out.println("\t-------------------------------------------------------------");
				System.out.println();
				System.out.println("\t\tYou WON the Game");
				System.out.println("\t\tLevel Number : "+level);
				System.out.println("\t\tYour Score is : "+(limit+1-count)+"/"+limit);
				System.out.println("\t\tYour accuracy is : "+(100/count)+"%");
				System.out.println();
				System.out.println("\t-------------------------------------------------------------");
				if(level==1)
				{
					GuessGameOasis game2=new GuessGameOasis(8,2);
					game2.check();
				}
				else if(level==2)
				{
					GuessGameOasis game3=new GuessGameOasis(5,3);
					game3.check();
				}
				break;
			}
			if(count>=limit)
			{
				System.out.println("\n\t\t\t\tYou LOST");
				System.out.println("\t\t\t\tAnswer is :"+sysNum);
				break;
			}
		}while(true);
	}
}
class GuessGameDriver
{
	public static void main(String args[])
	{
		GuessGameOasis game1=new GuessGameOasis(10,1);
		game1.check();
	}
}
