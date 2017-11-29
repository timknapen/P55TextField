/*******************************
Simple attributed text drawing example 
by Tim Knapen
November 2017
*****************************/
import processing.core.*;

public class TextField {

  PApplet parent;
  String[] words;
  int[] attr; // every word can have an attribute (0 normal, 1 italic, 2 bold)
  // attributes types
  public static final int REGULAR = 0;
  public static final int ITALIC = 1;
  public static final int BOLD = 2;
  
  PFont regular;
  PFont italic;
  PFont bold;

  int fontSize;
  float width;

  // constructor
  public TextField(PApplet parent) {
    this.parent = parent;
    this.width = 100;
    fontSize = 12;
  }

  public void draw(float x, float y) {
    float textx = x;
    float texty = y;

    if (this.words.length != this.attr.length) {
      return; // Something went wrong!
    }

    for (int i = 0; i < this.words.length; i++) {
      String word = words[i];

      switch(attr[i]) {
      case REGULAR: // regular
        parent.textFont(regular, fontSize);
        break;
      case ITALIC: // italic
        parent.textFont(italic, fontSize);
        break;
      case BOLD: // bold
        parent.textFont(bold, fontSize);
        break;
      }

      float wordWidth = parent.textWidth(word);
      if (textx + wordWidth > this.width) {
        texty += fontSize * 1.2;
        textx = x;
      }
      word += " ";
      parent.text( word, textx, texty);
      wordWidth = parent.textWidth(word);
      textx = textx + wordWidth;
    }
  }

  public void setText(String text) {
    this.words = parent.split(text, " ");
    this.attr = new int[this.words.length];
    for (int i = 0; i < this.attr.length; i++) {
      this.attr[i] = REGULAR; // regular
    }
  }

  public void addText(String text) {
    String[] tmp = words;
    String[] newWords = parent.split(text, " ");
    words = new String[tmp.length + newWords.length];
    // copy into new array
    // System.arraycopy( src, srcPos, dest, destPos, srcLength );
    System.arraycopy( tmp, 0, words, 0, tmp.length );
    System.arraycopy( newWords, 0, words, tmp.length, newWords.length);

    // and now the same with attributes
    int[] atmp = attr;
    attr = new int[words.length];
    System.arraycopy( atmp, 0, attr, 0, atmp.length );
    for (int i = atmp.length; i < attr.length; i++) {
      attr[i] = REGULAR;
    }
  }

  public void addItalic(String text) {
    String[] tmp = words;
    String[] newWords = parent.split(text, " ");
    words = new String[tmp.length + newWords.length];
    // copy into new array
    // System.arraycopy( src, srcPos, dest, destPos, srcLength );
    System.arraycopy( tmp, 0, words, 0, tmp.length );
    System.arraycopy( newWords, 0, words, tmp.length, newWords.length);

    // and now the same with attributes
    int[] atmp = attr;
    attr = new int[words.length];
    System.arraycopy( atmp, 0, attr, 0, atmp.length );
    for (int i = atmp.length; i < attr.length; i++) {
      attr[i] = ITALIC;
    }
  }

  public void addBold(String text) {
    String[] tmp = words;
    String[] newWords = parent.split(text, " ");
    words = new String[tmp.length + newWords.length];
    // copy into new array
    // System.arraycopy( src, srcPos, dest, destPos, srcLength );
    System.arraycopy( tmp, 0, words, 0, tmp.length );
    System.arraycopy( newWords, 0, words, tmp.length, newWords.length);

    // and now the same with attributes
    int[] atmp = attr;
    attr = new int[words.length];
    System.arraycopy( atmp, 0, attr, 0, atmp.length );
    for (int i = atmp.length; i < attr.length; i++) {
      attr[i] = BOLD;
    }
  }

  // Getters
  public float getWidth() {
    return this.width;
  }


  // Setters
  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public void setFont(String fontName) {
    this.regular = parent.loadFont(fontName);
  }

  public void setFonts(  String regularFont, String italicFont, String boldFont) {
    this.regular = parent.loadFont(regularFont);
    this.italic = parent.loadFont(italicFont);
    this.bold = parent.loadFont(boldFont);
  }
}