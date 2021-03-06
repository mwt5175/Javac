/* The following code was generated by JFlex 1.4.3 on 11/12/14 9:29 PM */

import java_cup.runtime.Symbol;

class CSXToken 
{
	int linenum;
	int colnum;
	
	CSXToken(int line,int col) 
	{
		linenum = line;
		colnum = col;
	}
	
	CSXToken(Position p) 
	{
		linenum = p.linenum;
		colnum = p.colnum;
		
	}

}

class CSXIntLitToken extends CSXToken 
{
	int intValue;
	CSXIntLitToken(int val,Position p) 
	{
	   super(p);
	   intValue = val; 
	}
}

class CSXIdentifierToken extends CSXToken 
{
	String identifierText;
	CSXIdentifierToken(String text, Position p) 
	{
		super(p);
		identifierText = text;
	}
}

class CSXCharLitToken extends CSXToken 
{
	char charValue;
	String charText;
	CSXCharLitToken(char val, String s, Position p)
	{
		super(p);
		charText = s;
		charValue = val;
	}
}

class CSXStringLitToken extends CSXToken 
{
	String stringText; // Full text of string literal, including quotes & escapes
	CSXStringLitToken(String text, Position p) 
	{
		super(p);
		stringText = text;
	}
}

//Error token class
class CSXErrorToken extends CSXToken 
{
	String errorText;
	
	CSXErrorToken(String text, Position p) 
	{
		super(p);
		errorText = text;
	}
}

// This class is used to track line and column numbers
// Feel free to change to extend it
class Position {
	int  linenum; 			/* maintain this as line number current
                                 		   token was scanned on */
	int  colnum; 			/* maintain this as column number current
                                 		   token began at */
	int  line; 				/* maintain this as line number after
										   scanning current token  */
	int  col; 				/* maintain this as column number after
										   scanning current token  */
	Position()
	{
  		linenum = 1; 	
  		colnum = 1; 	
  		line = 1;  
  		col = 1;
	}									   
	void setpos() 
	{ // set starting position for current token
		linenum = line;
		colnum = col;
	}
	
	int countEOLs(String s) 
	{
		final char[] c = s.toCharArray();
		int cnt=0;
		for(int i=0; i < c.length; i++) {
			cnt+=(c[i]=='\n'?1:0);
		}
		return cnt;
	}
	int distFromLastEOL(String s) 
	{
		final char[] c = s.toCharArray();
		int dist=1;
		for(int i= c.length-1; i >= 0; i--) {
			if (c[i] == '\n') {
				return dist;
			} else {
				dist++;
			}
		}
		return 0;
	}
} 

/**
//This class is used by the scanner to return token information that is useful for the parser
//This class will be replaced in our parser project by the java_cup.runtime.Symbol class
class Symbol { 
	public int sym;
	public CSXToken value;
	public Symbol(int tokenType, CSXToken theToken) {
		sym = tokenType;
		value = theToken;
	}
}
**/


class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int Idnt = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\65\1\13\2\0\1\14\22\0\1\64\1\52\1\7\1\63"+
    "\2\11\1\53\1\5\1\43\1\44\1\51\1\15\1\57\1\16\1\11"+
    "\1\12\12\1\1\62\1\50\1\55\1\47\1\56\2\11\1\24\1\17"+
    "\1\26\1\36\1\23\1\37\1\2\1\27\1\34\1\2\1\25\1\21"+
    "\1\2\1\31\1\20\1\40\1\2\1\22\1\30\1\33\1\35\1\41"+
    "\1\42\3\2\1\45\1\6\1\46\1\11\1\3\1\11\1\24\1\17"+
    "\1\26\1\36\1\23\1\37\1\2\1\27\1\34\1\2\1\25\1\21"+
    "\1\2\1\32\1\20\1\40\1\2\1\22\1\30\1\10\1\35\1\41"+
    "\1\42\3\2\1\60\1\54\1\61\1\4\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\3\1\1\3\1\5"+
    "\1\6\1\1\1\7\1\10\11\3\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\2\1\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\1\1\1\27\1\7\1\10"+
    "\2\0\1\30\2\0\1\31\1\0\1\32\4\0\1\33"+
    "\1\34\1\0\1\3\2\0\11\3\1\35\5\3\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\0\1\44\1\45"+
    "\1\0\1\46\1\31\2\47\1\3\1\50\11\3\1\51"+
    "\1\52\4\3\3\0\1\53\1\54\2\3\1\55\1\56"+
    "\4\3\1\57\2\3\1\60\1\3\1\61\1\62\1\3"+
    "\1\63\1\3\1\64\1\65\1\66\1\67\1\70\1\71"+
    "\2\3\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\154\0\242\0\330\0\u010e\0\u0144\0\u017a"+
    "\0\u01b0\0\u01e6\0\u021c\0\154\0\u0252\0\u0288\0\u02be\0\u02f4"+
    "\0\u032a\0\u0360\0\u0396\0\u03cc\0\u0402\0\u0438\0\u046e\0\u04a4"+
    "\0\154\0\154\0\154\0\154\0\u04da\0\154\0\154\0\u0510"+
    "\0\u0546\0\u057c\0\u05b2\0\u05e8\0\154\0\154\0\154\0\154"+
    "\0\u061e\0\154\0\u0654\0\u068a\0\u06c0\0\u06f6\0\u072c\0\u0762"+
    "\0\u0798\0\154\0\u07ce\0\154\0\u0804\0\u083a\0\u01b0\0\u0870"+
    "\0\154\0\154\0\u08a6\0\u08dc\0\u0912\0\u0948\0\u097e\0\u09b4"+
    "\0\u09ea\0\u0a20\0\u0a56\0\u0a8c\0\u0ac2\0\u0af8\0\u0b2e\0\330"+
    "\0\u0b64\0\u0b9a\0\u0bd0\0\u0c06\0\u0c3c\0\154\0\154\0\154"+
    "\0\154\0\154\0\154\0\u0c72\0\u0948\0\154\0\u0144\0\154"+
    "\0\u0ca8\0\154\0\u0cde\0\u0d14\0\u0d4a\0\u0d80\0\u0db6\0\u0dec"+
    "\0\u0e22\0\u0e58\0\u0e8e\0\u0ec4\0\u0efa\0\u0f30\0\330\0\330"+
    "\0\u0f66\0\u0f9c\0\u0fd2\0\u1008\0\u103e\0\u0cde\0\u1074\0\330"+
    "\0\330\0\u10aa\0\u10e0\0\330\0\330\0\u1116\0\u114c\0\u1182"+
    "\0\u11b8\0\330\0\u11ee\0\u1224\0\330\0\u125a\0\154\0\330"+
    "\0\u1290\0\330\0\u12c6\0\330\0\330\0\330\0\330\0\330"+
    "\0\330\0\u12fc\0\u1332\0\330";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\3\1\11"+
    "\1\12\1\3\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\2\5\1\21\1\22\2\5\1\23\4\5\1\12\1\24"+
    "\2\5\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\2\52\1\3"+
    "\1\4\1\5\1\6\1\7\1\10\1\3\1\11\1\12"+
    "\1\3\1\13\1\14\1\15\1\53\1\54\1\20\2\5"+
    "\1\21\1\22\2\5\1\23\4\5\1\12\1\24\2\5"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\2\52\67\0\1\4"+
    "\2\6\4\0\1\6\6\0\24\6\24\0\3\5\4\0"+
    "\1\5\4\0\1\55\1\56\24\5\24\0\3\6\4\0"+
    "\1\6\6\0\24\6\24\0\1\57\64\0\1\60\4\61"+
    "\1\62\1\63\4\61\1\64\1\65\50\61\1\60\1\66"+
    "\5\67\1\70\1\71\3\67\1\72\1\73\50\67\1\66"+
    "\1\0\3\5\4\0\1\5\4\0\1\55\1\56\3\5"+
    "\1\74\20\5\35\0\1\75\66\0\1\14\67\0\1\76"+
    "\66\0\1\76\50\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\1\5\1\77\1\5\1\100\20\5\24\0\3\5"+
    "\4\0\1\5\4\0\1\55\1\56\4\5\1\101\17\5"+
    "\24\0\3\5\4\0\1\5\4\0\1\55\1\56\2\5"+
    "\1\102\7\5\2\103\10\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\1\5\1\104\1\105\5\5\1\106"+
    "\13\5\24\0\3\5\4\0\1\5\4\0\1\55\1\56"+
    "\12\5\2\107\4\5\1\110\3\5\24\0\3\5\4\0"+
    "\1\5\4\0\1\55\1\56\1\5\1\111\3\5\1\112"+
    "\16\5\24\0\3\5\4\0\1\5\4\0\1\55\1\56"+
    "\3\5\1\113\20\5\24\0\3\5\4\0\1\5\4\0"+
    "\1\55\1\56\1\5\1\114\22\5\24\0\3\5\4\0"+
    "\1\5\4\0\1\55\1\56\10\5\1\115\13\5\72\0"+
    "\1\116\65\0\1\117\71\0\1\120\66\0\1\121\60\0"+
    "\1\122\65\0\1\123\101\0\1\124\17\0\1\125\66\0"+
    "\1\125\64\0\1\126\66\0\1\126\50\0\1\57\2\0"+
    "\1\127\61\0\5\60\1\62\5\60\1\64\1\65\56\60"+
    "\1\130\5\60\1\64\1\65\56\60\1\131\1\61\1\60"+
    "\1\61\2\60\1\64\1\65\15\60\1\61\33\60\13\0"+
    "\1\64\52\0\7\66\1\132\3\66\1\72\1\73\57\66"+
    "\1\67\1\133\1\67\2\66\1\72\1\73\15\66\1\67"+
    "\33\66\13\0\1\72\53\0\3\5\4\0\1\5\4\0"+
    "\1\55\1\56\16\5\1\134\5\5\23\0\13\75\1\14"+
    "\52\75\2\0\1\135\5\0\1\135\6\0\24\135\24\0"+
    "\3\5\4\0\1\5\4\0\1\55\1\56\1\5\1\136"+
    "\22\5\24\0\3\5\4\0\1\5\4\0\1\55\1\56"+
    "\4\5\1\137\17\5\24\0\3\5\4\0\1\140\4\0"+
    "\1\55\1\56\5\5\1\141\6\5\1\140\7\5\24\0"+
    "\3\5\4\0\1\5\4\0\1\55\1\56\11\5\1\142"+
    "\12\5\24\0\3\5\4\0\1\5\4\0\1\55\1\56"+
    "\17\5\1\143\4\5\24\0\3\5\4\0\1\5\4\0"+
    "\1\55\1\56\12\5\2\144\10\5\24\0\3\5\4\0"+
    "\1\5\4\0\1\55\1\56\5\5\1\145\16\5\24\0"+
    "\3\5\4\0\1\5\4\0\1\55\1\56\5\5\1\146"+
    "\16\5\24\0\3\5\4\0\1\147\4\0\1\55\1\56"+
    "\14\5\1\147\7\5\24\0\3\5\4\0\1\5\4\0"+
    "\1\55\1\56\3\5\1\150\20\5\24\0\3\5\4\0"+
    "\1\5\4\0\1\55\1\56\2\5\1\151\21\5\24\0"+
    "\3\5\4\0\1\5\4\0\1\55\1\56\15\5\1\152"+
    "\6\5\24\0\3\5\4\0\1\5\4\0\1\55\1\56"+
    "\15\5\1\153\6\5\24\0\3\5\4\0\1\5\4\0"+
    "\1\55\1\56\15\5\1\154\6\5\23\0\63\124\1\155"+
    "\2\124\5\0\1\130\61\0\5\156\1\157\1\71\3\156"+
    "\2\0\50\156\2\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\4\5\1\160\17\5\24\0\3\135\4\0\1\135"+
    "\6\0\24\135\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\2\5\1\161\21\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\5\5\1\162\16\5\24\0\3\5"+
    "\4\0\1\5\4\0\1\55\1\56\16\5\1\163\5\5"+
    "\24\0\3\5\4\0\1\5\4\0\1\55\1\56\17\5"+
    "\1\164\4\5\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\4\5\1\165\17\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\15\5\1\166\6\5\24\0\3\5"+
    "\4\0\1\167\4\0\1\55\1\56\11\5\1\170\2\5"+
    "\1\167\7\5\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\11\5\1\171\12\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\3\5\1\172\20\5\24\0\3\5"+
    "\4\0\1\5\4\0\1\55\1\56\11\5\1\173\12\5"+
    "\24\0\3\5\4\0\1\5\4\0\1\55\1\56\12\5"+
    "\2\174\10\5\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\17\5\1\175\4\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\2\5\1\176\21\5\23\0\63\124"+
    "\1\177\2\124\6\0\3\156\21\0\1\156\34\0\3\5"+
    "\4\0\1\5\4\0\1\55\1\56\6\5\1\200\15\5"+
    "\24\0\3\5\4\0\1\5\4\0\1\55\1\56\3\5"+
    "\1\201\20\5\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\20\5\1\202\3\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\15\5\1\203\6\5\24\0\3\5"+
    "\4\0\1\204\4\0\1\55\1\56\14\5\1\204\7\5"+
    "\24\0\3\5\4\0\1\5\4\0\1\55\1\56\11\5"+
    "\1\205\12\5\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\4\5\1\206\17\5\24\0\3\5\4\0\1\207"+
    "\4\0\1\55\1\56\14\5\1\207\7\5\24\0\3\5"+
    "\4\0\1\5\4\0\1\55\1\56\4\5\1\210\17\5"+
    "\24\0\3\5\4\0\1\5\4\0\1\55\1\56\12\5"+
    "\2\211\10\5\24\0\3\5\4\0\1\5\4\0\1\55"+
    "\1\56\12\5\2\212\10\5\24\0\3\5\4\0\1\5"+
    "\4\0\1\55\1\56\16\5\1\213\5\5\24\0\3\5"+
    "\4\0\1\5\4\0\1\55\1\56\4\5\1\214\17\5"+
    "\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4968];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\10\1\1\11\14\1\4\11\1\1\2\11"+
    "\5\1\4\11\1\1\1\11\2\1\2\0\1\1\2\0"+
    "\1\11\1\0\1\11\4\0\2\11\1\0\1\1\2\0"+
    "\17\1\6\11\1\0\1\1\1\11\1\0\1\11\1\1"+
    "\1\11\22\1\3\0\17\1\1\11\15\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
Position Pos = new Position();


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 174) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Symbol yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 35: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.GEQ,
		new CSXToken(Pos));
          }
        case 59: break;
        case 11: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.LBRACKET,
		new CSXToken(Pos));
          }
        case 60: break;
        case 14: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.SEMI,
		new CSXToken(Pos));
          }
        case 61: break;
        case 2: 
          { Pos.setpos();
	Pos.col += yytext().length();
	int i;
	final double d = Double.parseDouble(yytext());
	if (d > Integer.MAX_VALUE) 
	{
		System.out.println("Error: Integer literal "+
			yytext()+" too large; replaced with "+ Integer.MAX_VALUE);
		i=Integer.MAX_VALUE;
	} 
	else 
	{
		i = Integer.parseInt(yytext());
	}
	return new Symbol(sym.INTLIT,
		new CSXIntLitToken(i, Pos));
          }
        case 62: break;
        case 34: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.LEQ,
		new CSXToken(Pos));
          }
        case 63: break;
        case 23: 
          { Pos.col +=1;
          }
        case 64: break;
        case 13: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.ASG,
		new CSXToken(Pos));
          }
        case 65: break;
        case 36: 
          { Pos.setpos();
	Pos.col +=2;
	yybegin(YYINITIAL);
	int operator;
	if (yytext().charAt(0)== '+')
    	  operator = sym.INC;
      else
      	  operator = sym.DEC;
	return new Symbol(operator,
		new CSXToken(Pos));
          }
        case 66: break;
        case 20: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.LBRACE,
		new CSXToken(Pos));
          }
        case 67: break;
        case 1: 
          { Pos.setpos(); 
	Pos.col += yytext().length();
	String s = "invalid token: (" + yytext() + ")";
	
	return new Symbol(sym.error, new CSXErrorToken(s, Pos));
          }
        case 68: break;
        case 26: 
          { Pos.setpos(); 
	Pos.line +=1;
	Pos.col = 1;
	String s = "runaway char: (" + yytext().substring(0, yylength() -1) + ")";
	
	return new Symbol(sym.error, new CSXErrorToken(s, Pos));
          }
        case 69: break;
        case 53: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_CLASS,
		new CSXToken(Pos));
          }
        case 70: break;
        case 46: 
          { Pos.setpos();
	Pos.col +=4;
	return new Symbol(sym.rw_ELSE,
	new CSXToken(Pos));
          }
        case 71: break;
        case 28: 
          { Pos.setpos(); 
	Pos.line +=1;
	Pos.col = 1;
	String s = "runaway string: (" + yytext().substring(0, yylength() -1) + ")";
	
	return new Symbol(sym.error, new CSXErrorToken(s, Pos));
          }
        case 72: break;
        case 17: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.LT,
		new CSXToken(Pos));
          }
        case 73: break;
        case 52: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_CONST,
		new CSXToken(Pos));
          }
        case 74: break;
        case 38: 
          { Pos.setpos();
	Pos.col += yytext().length();
	final String val = yytext();
	char cval =  val.charAt(val.length()-2);
	if (val.length()==4) 
	{
		if (val.charAt(2)=='n') 
		{
			cval = '\n';
		} 
		else if (val.charAt(2)== 't') 
		{
			cval = '\t';
		}
	}
	return new Symbol(sym.CHARLIT,
			new CSXCharLitToken(cval, yytext(), Pos));
          }
        case 75: break;
        case 19: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.COMMA,
		new CSXToken(Pos));
          }
        case 76: break;
        case 5: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.SLASH,
		new CSXToken(Pos));
          }
        case 77: break;
        case 21: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.RBRACE,
		new CSXToken(Pos));
          }
        case 78: break;
        case 3: 
          { Pos.setpos();
	Pos.col += yytext().length();
	return new Symbol(sym.IDENTIFIER,
		new CSXIdentifierToken(yytext().toLowerCase(), Pos));
          }
        case 79: break;
        case 16: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.NOT,
		new CSXToken(Pos));
          }
        case 80: break;
        case 31: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.NOTEQ,
		new CSXToken(Pos));
          }
        case 81: break;
        case 57: 
          { Pos.setpos();
	Pos.col +=6;
	return new Symbol(sym.rw_RETURN,
		new CSXToken(Pos));
          }
        case 82: break;
        case 55: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_PRINT,
		new CSXToken(Pos));
          }
        case 83: break;
        case 9: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.LPAREN,
		new CSXToken(Pos));
          }
        case 84: break;
        case 54: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_FALSE,
		new CSXToken(Pos));
          }
        case 85: break;
        case 22: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.COLON,
			new CSXToken(Pos));
          }
        case 86: break;
        case 47: 
          { Pos.setpos();
	Pos.col +=4;
	return new Symbol(sym.rw_CHAR,
		new CSXToken(Pos));
          }
        case 87: break;
        case 40: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 2;
          { Pos.setpos();
	Pos.col +=2;
	int operator;
	if (yytext().charAt(0)== '+')
    	  operator = sym.INC;
      else
      	  operator = sym.DEC;
	return new Symbol(operator,
		new CSXToken(Pos));
          }
        case 88: break;
        case 37: 
          // lookahead expression with fixed lookahead length
          yypushback(2);
          { yybegin(Idnt);
	Pos.setpos();
	Pos.col += yytext().length();
	return new Symbol(sym.IDENTIFIER,
		new CSXIdentifierToken(yytext().toLowerCase(), Pos));
          }
        case 89: break;
        case 27: 
          { Pos.setpos(); 
	Pos.col += yytext().length();
	return new Symbol(sym.STRLIT,
		new CSXStringLitToken(yytext(), Pos));
          }
        case 90: break;
        case 41: 
          { Pos.setpos();
	Pos.col +=3;
	return new Symbol(sym.rw_INT,
		new CSXToken(Pos));
          }
        case 91: break;
        case 24: 
          { Pos.setpos();
	Pos.col += yytext().length();
	final String unsignedVal = yytext().substring(1);
	int i;
	final double d = -Double.parseDouble(unsignedVal);
	if (d < Integer.MIN_VALUE) {
		System.out.println("Error: Integer literal "+
			yytext()+" too small; replaced with "+ Integer.MIN_VALUE);
		i=Integer.MIN_VALUE;
	} 
	else {
		i = -Integer.parseInt(unsignedVal); 
	}
	return new Symbol(sym.INTLIT,
		new CSXIntLitToken(i, Pos));
          }
        case 92: break;
        case 50: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_BREAK,
		new CSXToken(Pos));
          }
        case 93: break;
        case 4: 
          { Pos.setpos(); 
	Pos.col += yytext().length();
	String s = "Illegal identifier: (" + yytext() + ")";
	
	return new Symbol(sym.error, new CSXErrorToken(s, Pos));
          }
        case 94: break;
        case 10: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.RPAREN,
		new CSXToken(Pos));
          }
        case 95: break;
        case 12: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.RBRACKET,
		new CSXToken(Pos));
          }
        case 96: break;
        case 8: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.MINUS,
		new CSXToken(Pos));
          }
        case 97: break;
        case 42: 
          { Pos.setpos();
	Pos.col +=3;
	return new Symbol(sym.rw_FOR,
		new CSXToken(Pos));
          }
        case 98: break;
        case 15: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.TIMES,
		new CSXToken(Pos));
          }
        case 99: break;
        case 18: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.GT,
		new CSXToken(Pos));
          }
        case 100: break;
        case 44: 
          { Pos.setpos();
	Pos.col +=4;
	return new Symbol(sym.rw_BOOL,
		new CSXToken(Pos));
          }
        case 101: break;
        case 51: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_ENDIF,
	new CSXToken(Pos));
          }
        case 102: break;
        case 56: 
          { Pos.setpos();
	Pos.col +=5;
	return new Symbol(sym.rw_WHILE,
			new CSXToken(Pos));
          }
        case 103: break;
        case 58: 
          { Pos.setpos();
	Pos.col +=8;
	return new Symbol(sym.rw_CONTINUE,
		new CSXToken(Pos));
          }
        case 104: break;
        case 45: 
          { Pos.setpos();
	Pos.col +=4;
	return new Symbol(sym.rw_READ,
		new CSXToken(Pos));
          }
        case 105: break;
        case 33: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.COR,
		new CSXToken(Pos));
          }
        case 106: break;
        case 48: 
          { Pos.setpos();
	Pos.col +=4;
	return new Symbol(sym.rw_VOID,
		new CSXToken(Pos));
          }
        case 107: break;
        case 30: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.EQ,
		new CSXToken(Pos));
          }
        case 108: break;
        case 25: 
          { Pos.setpos(); 
	Pos.col += yytext().length();
	String s = "Illegal char: (" + yytext() + ")";
	
	return new Symbol(sym.error, new CSXErrorToken(s, Pos));
          }
        case 109: break;
        case 43: 
          { Pos.setpos();
	Pos.col +=4;
	return new Symbol(sym.rw_TRUE,
		new CSXToken(Pos));
          }
        case 110: break;
        case 39: 
          { Pos.setpos(); 
	Pos.col += yytext().length();
	String s = "Illegal string: (" + yytext() + ")";
	
	return new Symbol(sym.error, new CSXErrorToken(s, Pos));
          }
        case 111: break;
        case 29: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.rw_IF,
		new CSXToken(Pos));
          }
        case 112: break;
        case 49: 
          { if (Pos.countEOLs(yytext()) > 0) {
		Pos.line +=Pos.countEOLs(yytext());
		Pos.col = Pos.distFromLastEOL(yytext());
	} else {
		Pos.col += yytext().length();
	}
          }
        case 113: break;
        case 6: 
          { Pos.line +=1;
	Pos.col = 1;
          }
        case 114: break;
        case 32: 
          { Pos.setpos();
	Pos.col +=2;
	return new Symbol(sym.CAND,
		new CSXToken(Pos));
          }
        case 115: break;
        case 7: 
          { Pos.setpos();
	Pos.col +=1;
	return new Symbol(sym.PLUS,
		new CSXToken(Pos));
          }
        case 116: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {   return new Symbol(sym.EOF, new CSXToken(0,0));
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
