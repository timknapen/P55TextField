
# Processing Text Field example

A very basic example of setting a paragraph with regular, italics and bold fonts.


## Usage

Just drop the TextField.java file in a new tab in your Processing sketch.


Create the fonts you want to use through the processing menu: **Tools > Create Font**. You'll want to create 3 files: a regular font, an italic and a bold one.

Then, in your sketch create a new TextField object and set it's font files. and font size:

	TextField myTextField = new TextField(this);
 	
 	myTextField.setFonts(
	    "Helvetica-30.vlw", 
	    "Helvetica-Oblique-30.vlw", 
	    "Helvetica-Bold-30.vlw" 
   	 );
 
  	myTextField.setFontSize(30);
	

Next set the textField's text. You can append italic, regular or bold text as much as you want.

	textField.setText("This is regular text.");
	textField.addItalic("This part is in italic.");
	textField.addText("Regular again.");
	textField.addBold("And bold!");





## Credits
by Tim Knapen, 2017.
For your coding pleasure.

[timknapen](www.timknapen.be)

