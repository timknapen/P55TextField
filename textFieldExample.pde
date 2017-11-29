/*******************************
Simple attributed text drawing example 
by Tim Knapen
November 2017
*****************************/

TextField textField;

void setup() {
  size(1000, 600);

  textField = new TextField(this);
  textField.setFonts(
    "Helvetica-30.vlw", 
    "Helvetica-Oblique-30.vlw", 
    "Helvetica-Bold-30.vlw" 
    );
  textField.setFontSize(30);
  textField.setText("The");
  textField.addItalic("split()");
  textField.addText("function breaks a");
  textField.addBold("String");
  textField.addText("into pieces using a character or string as the delimiter. The delim parameter specifies the character or characters that mark the boundaries between each piece. A");
  textField.addBold("String[]");
  textField.addText("array is returned that contains each of the pieces. If the result is a set of numbers, you can convert the ");
  textField.addBold("String[]");
  textField.addText("array to a");
  textField.addBold("float[]");
  textField.addText("or");
  textField.addBold("int[]");
  textField.addText("array using the datatype conversion functions ");
  textField.addItalic("int()");
  textField.addText("and");
  textField.addItalic("float().");
}

void draw() {
  background(255);

  fill(230);
  rect(0, 0, mouseX, height);

  noStroke();
  fill(50, 0, 150);
  textField.setWidth(mouseX - 10);
  textField.draw(10, 30);

}