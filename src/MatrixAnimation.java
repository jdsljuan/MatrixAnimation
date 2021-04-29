import java.util.ArrayList;
import java.lang.Character;

/**
 * MatrixAnimation.java
 * @author Juan David Sanchez Leal
 * date: 27/04/21
 */
public class MatrixAnimation{

	/** The representation of the Screen */
	private ArrayList<String> animationArray;

	/** Unicode Index */
	private final int finalCharInt = 12538;	
	private final int startCharInt = 12449;	
	private final int space = 12288;

	/** Util vars */		
	private final int maxColumnChars = 20;	
	private final int sleepTime = 100;
	private final double firstPipeOnP = 0.3;
	private final double commonPipeOnP = 0.05;
	private int columns, lines;
	private int pipeOn[];

	/**
	 * MatrixAnimation := Build the context.
	 * @param columns It's a representation for the linux environment variable called $COLUMNS.
	 * @param lines It's a representation for the linux environment variable called $LINES.
	 */
	public MatrixAnimation(int columns, int lines){
		this.animationArray = new ArrayList<String>();
		this.columns = columns;
		this.lines = lines;
		this.pipeOn = new int[this.columns];

		for(int i = 0; i < this.columns; i++){
			pipeOn[i] = pipeSwitch(this.firstPipeOnP);
		}

		for(int i = 0;i < this.lines; i++){
			animationArray.add(0, createNewLine());
		}
	}

	/**
	 * runAnimation := Principal loop animation
	 */
	private void runAnimation(){
		//@todo Implement variation of the character on run.
		while(true){
			printFrame();
			try{
				Thread.sleep(this.sleepTime);
			}catch(Exception e){

			}
		}
	}

	/**
	 * printFrame := Add a new line at the top of the animation Array 
	 *				 and print all the lines between zero and lines. Removes
	 *				 the last one too.
	 */
	private void printFrame(){
		animationArray.add(0, createNewLine());
		animationArray.remove((animationArray.size()-1)); 
			for(String s: animationArray){
				if(animationArray.indexOf(s) <= this.lines){
					System.out.println(s);
				}
		}
	}

	/**
	 * createNewLine := Creates a String and puts it into the array.
	 *					-> String(int [], int, int) constructor to generate the unicode string.
	 *					Use the pipe system to create a concordance between every new line and
	 *					the last one.
	 *
	 * @return a new top line of the animation, this string is linked to a hypothetical pipe flow.
	 */
	private String createNewLine(){
		int uIntRandomArray[] = new int[this.columns];
		
		for(int i = 0; i < this.columns; i++){
			if(pipeOn[i] != 0){
				uIntRandomArray[i] = getRandomIntChar();
				pipeOn[i]--;
			}else{
				uIntRandomArray[i] = this.space;
				pipeOn[i] = pipeSwitch(this.commonPipeOnP); 
			}
		}
		return new String(uIntRandomArray, 0, this.columns);
	}

	/**
	 * pipeSwitch := Given a probability, return a vertical line size or zero.
	 * 				 A non-zero value will keep the pipe alive until it is zero.
	 * 
	 * @param probability The probability of turn ON the pipe.
	 * @return Zero if it's turn off, else the number with the posible vertical line size.
	 */
	private int pipeSwitch(double probability){
		return (Math.random() <= probability) ? (int)(Math.random()*this.maxColumnChars) : 0;
	}

	/**
	 * getRandomIntChar := Generates a random Unicode index between characters on the same unicode block.
	 * 
	 * @return A integer that represents a index of unicode charbase.
	 */
	private int getRandomIntChar(){
		return this.startCharInt + (int) Math.floor(Math.random()*(this.finalCharInt - this.startCharInt));
	}

	/** 
	 * showHelp := Shows the correct usage if it is wrong.
	 */
	public static void showHelp(){
		String helpStr = """
			----- Matrix Animation - JAVA -----
			A simple animation inspired by Matrix The Movie.
			For the Command Prompt of all systems with JVM.

			On GNU/Linux systems use env vars $COLUMNS $LINES
				
				Usage: 	 MatrixAnimation COLUMNS_SIZE ROWS_SIZE 
				param: 	 COLUMNS_SIZE and ROWS_SIZE are numbers.

				Example: Matrix Animation 142 45
			
			""";
		System.out.println(helpStr);
	}

	//--------------<<< MAIN >>>--------------
	public static void main(String[] args){
		if(args.length == 2){
			try{
				int columnsArg = Integer.decode(args[0]).intValue();
				int linesArg = Integer.decode(args[1]).intValue();
				//@hack At the moment fill all the screen with half of columns. why? :|
				MatrixAnimation ma = new MatrixAnimation(columnsArg/2,linesArg);
				ma.runAnimation();
			}catch(Exception e){
				MatrixAnimation.showHelp();
			}
		}else{
			MatrixAnimation.showHelp();
		}
	}
}