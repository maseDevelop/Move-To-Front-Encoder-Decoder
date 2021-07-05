# Move To Front Encoder Decoder
This is an Encoder and Decoder that Uses a Move to front List


MTFencoder
-----------
This takes two text files as its argument:
-The first file being the file that you want to encoded
-The second file is the encoded output file named as specified by the user

Usage:  java MTFencoder <filename> <output filename>
Return: encoded output file

MTFdecoder
-----------
This takes one file as an argument:
-This is a txt file that has been encoded by the MTFencoder. This will return the
same file that has been decoded to the original file.

Usage:  java MTFdecoder <filename to be decoded>
Return: decoded file

wordListString
---------------
This has a private tNode class
