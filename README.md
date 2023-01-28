# DXC Encoding Assessment

### Introduction:

This repository serves as my response to DXC's "Encoding" coding assessment, this time in Java. There were a few assumptions made when working on this assessment, in which I will highlight below.

### Assumptions:

As the coding assessment did not specify certain details, I did my best to adhere to as close to the requirements as possible. The assumptions that I made to do so were as follows:

<ul> 
 <li> I assumed that the characters in the reference table are case sensitive. Therefore, any characters in the plain text / specified offset character that is not found in the specified reference table would be treated as not within the reference table, even if it is just the lower-case version of the characters</li>
 <li> As the assessment required me to cater to custom offset characters, I implemented my encode() and decode() functions to take in an additional argument that specifies the offset character, which I assume it is alright to do so. </li>
</ul>

### Instructions:

Firstly, download the .jar file, as well as the .txt file from the Releases tab.

To execute the program, ensure you are at the right directory and run the following command <code>java -jar DXC.jar arg1 arg2 arg3 </code>

The program takes in up to three arguments:

<ul> 
 <li> arg1 : The command type. Valid commands include Encode and Decode, and these commands are not case-sensitive. </li>
 <li> arg2 : The target text. If there are space-type characters within the target text, ensure that the entire text is surrounded by quotation marks (""). </li>
 <li> arg3 : The offset character. If an invalid offset character(s) is specified, an exception would be thrown and handled by the program by printing the error message. Quotation marks aren't necessary unless there are spaces specified. Note that this argument only applies to encoding. The decode command only takes in the first two arguments </li>
</ul>

Here are some examples of valid commands:
<ul> 
 <li> <code>java -jar DXC.jar Encode "HELLO WORLD" B </code> </li>
 <li> <code>java -jar DXC.jar dECOde "BGDKKN VNQKC" </code> </li>
 <li> <code>java -jar DXC.jar DeCODe "FC/GGJ RJMG." </code> </li>
 <li> <code>java -jar DXC.jar encode "!!!!!!!!!!" "H" </code> </li>
</ul>

Here are some examples of invalid commands:
<ul> 
 <li> <code>java -jar DXC.jar encode HELLO WORLD B </code> missing quotations around HELLO WORLD </li>
 <li> <code>java -jar DXC.jar dECOde "bGDKKN VNQKC" </code> program executes but an exception would be thrown as offset character is not recognized </li>
 <li> <code>java -jar DXC.jar DeCODer "FC/GGJ RJMG." </code> unrecognized arg1 parameter </li>
 <li> <code>java -jar DXC.jar DeCODer "FC/GGJ RJMG." B </code> too many arguments for decode command </li>
</ul>